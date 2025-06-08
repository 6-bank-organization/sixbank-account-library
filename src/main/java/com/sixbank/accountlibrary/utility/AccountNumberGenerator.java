package com.sixbank.accountlibrary.utility;

import java.security.SecureRandom;

/**
 * Utility class for generating and managing account numbers for customer or internal accounts.
 * <p>
 * Account numbers follow the format: {@code PREFIXxxxxxxxxxx}, where:
 * <ul>
 *   <li>{@code PREFIX} is a system-defined prefix (e.g., "SIX")</li>
 *   <li>{@code xxxxxxxxxx} is a 10-character uppercase alphanumeric string</li>
 * </ul>
 * Example: {@code SIXD29KF83LQ}
 *
 * <p>
 * Features:
 * <ul>
 *   <li>Secure random generation using {@link SecureRandom}</li>
 *   <li>Simple validation of account number format</li>
 *   <li>Support for masking account numbers in logs or UIs</li>
 * </ul>
 *
 * <p><b>Usage Example:</b></p>
 * <pre>{@code
 * // Prefix from your application configuration (e.g., application.yml)
 * String prefix = "SIX";
 *
 * // Generate a new account number
 * String accountNumber = AccountNumberGenerator.generateAccountNumber(prefix);
 *
 * // Mask the account number for display
 * String masked = AccountNumberGenerator.maskAccountNumber(accountNumber);
 *
 * // Validate the account number
 * boolean isValid = AccountNumberGenerator.isValidAccountNumber(accountNumber, prefix);
 * }</pre>
 *
 * <p><b>Spring Boot Integration:</b></p>
 * <p>
 * To use the generator with a value defined in your application YAML file:
 * </p>
 * <pre>{@code
 * // application.yml
 * sixbank:
 *   account:
 *     prefix: SIX
 * }</pre>
 *
 * Then create a configuration class in your application:
 * <pre>{@code
 * @Component
 * @ConfigurationProperties(prefix = "sixbank.account")
 * public class AccountProperties {
 *     private String prefix;
 *
 *     public String getPrefix() {
 *         return prefix;
 *     }
 *
 *     public void setPrefix(String prefix) {
 *         this.prefix = prefix;
 *     }
 * }
 * }</pre>
 *
 * And inject it where needed:
 * <pre>{@code
 * @Service
 * public class MyService {
 *     private final AccountProperties properties;
 *
 *     public MyService(AccountProperties properties) {
 *         this.properties = properties;
 *     }
 *
 *     public void createAccount() {
 *         String accountNumber = AccountNumberGenerator.generateAccountNumber(properties.getPrefix());
 *         // ...
 *     }
 * }
 * }</pre>
 *
 * @author SIX Bank Engineering Team
 * @since 0.0.3-SNAPSHOT
 */
public final class AccountNumberGenerator {

    private static final int RANDOM_LENGTH = 10;
    private static final String CHAR_POOL = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    private AccountNumberGenerator() {
        // Prevent instantiation
    }

    /**
     * Generates a new account number using the given prefix.
     *
     * @param prefix the system-defined account number prefix
     * @return a newly generated account number, e.g., {@code SIX9G7L2B5Q1W}
     */
    public static String generateAccountNumber(String prefix) {
        StringBuilder sb = new StringBuilder(prefix);
        for (int i = 0; i < RANDOM_LENGTH; i++) {
            int index = RANDOM.nextInt(CHAR_POOL.length());
            sb.append(CHAR_POOL.charAt(index));
        }
        return sb.toString();
    }

    /**
     * Returns a masked version of the given account number, showing only the last 4 characters.
     * Example: {@code SIX******Q1W}
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
                && accountNumber.substring(prefix.length()).matches("^[A-Z0-9]{" + RANDOM_LENGTH + "}$");
    }
}
