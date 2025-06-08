package com.sixbank.accountlibrary.utility;

import java.security.SecureRandom;

/**
 * Utility class for generating and managing account numbers for customer or internal accounts.
 * <p>
 * Account numbers follow the format: {@code PREFIX##########}, where:
 * <ul>
 *   <li>{@code PREFIX} is a system-defined prefix (e.g., "SIX")</li>
 *   <li>{@code ##########} is a 10-digit numeric string</li>
 * </ul>
 * Example: {@code SIX0532013000}
 *
 * <p>
 * Features:
 * <ul>
 *   <li>Secure random generation using {@link SecureRandom}</li>
 *   <li>Simple validation of account number format</li>
 *   <li>Support for masking account numbers in logs or UIs</li>
 *   <li>Method to extract numeric part for IBAN generation</li>
 * </ul>
 *
 * <p><b>Usage Example:</b></p>
 * <pre>{@code
 * String prefix = "SIX";
 *
 * // Generate a new numeric account number
 * String accountNumber = AccountNumberGenerator.generateAccountNumber(prefix);
 *
 * // Extract the numeric part for IBAN
 * String numericPart = AccountNumberGenerator.extractNumericPart(accountNumber, prefix);
 *
 * // Mask the account number for display
 * String masked = AccountNumberGenerator.maskAccountNumber(accountNumber);
 *
 * // Validate the account number
 * boolean isValid = AccountNumberGenerator.isValidAccountNumber(accountNumber, prefix);
 * }</pre>
 *
 * @author SIX Bank Engineering Team
 * @since 0.0.4-SNAPSHOT
 */
public final class AccountNumberGenerator {

    private static final int RANDOM_LENGTH = 10;
    private static final SecureRandom RANDOM = new SecureRandom();

    private AccountNumberGenerator() {
        // Prevent instantiation
    }

    /**
     * Generates a new account number using the given prefix and 10-digit numeric body.
     *
     * @param prefix the system-defined account number prefix
     * @return a newly generated account number, e.g., {@code SIX1234567890}
     */
    public static String generateAccountNumber(String prefix) {
        StringBuilder sb = new StringBuilder(prefix);
        for (int i = 0; i < RANDOM_LENGTH; i++) {
            sb.append(RANDOM.nextInt(10)); // 0-9 only
        }
        return sb.toString();
    }

    /**
     * Extracts the numeric part of the account number (after the prefix).
     *
     * @param accountNumber the full account number, e.g., {@code SIX1234567890}
     * @param prefix the prefix used in generation
     * @return the 10-digit numeric part, or null if invalid
     */
    public static String extractNumericPart(String accountNumber, String prefix) {
        if (isValidAccountNumber(accountNumber, prefix)) {
            return accountNumber.substring(prefix.length());
        }
        return null;
    }

    /**
     * Returns a masked version of the given account number, showing only the last 4 characters.
     * Example: {@code SIX******7890}
     *
     * @param accountNumber the full account number
     * @return masked account number, or original input if format is invalid or too short
     */
    public static String maskAccountNumber(String accountNumber) {
        if (accountNumber == null || accountNumber.length() < 6) {
            return accountNumber;
        }

        int unmaskedLength = 4;
        int maskLength = accountNumber.length() - unmaskedLength;

        String maskedPart = "*".repeat(maskLength);
        String unmaskedPart = accountNumber.substring(maskLength);

        return maskedPart + unmaskedPart;
    }

    /**
     * Validates if a given string is a valid account number based on the expected prefix.
     *
     * @param accountNumber the account number to validate
     * @param prefix the expected prefix used in account number generation
     * @return true if valid, false otherwise
     */
    public static boolean isValidAccountNumber(String accountNumber, String prefix) {
        if (accountNumber == null || accountNumber.length() != prefix.length() + RANDOM_LENGTH) {
            return false;
        }
        return accountNumber.startsWith(prefix)
                && accountNumber.substring(prefix.length()).matches("^\\d{" + RANDOM_LENGTH + "}$");
    }
}
