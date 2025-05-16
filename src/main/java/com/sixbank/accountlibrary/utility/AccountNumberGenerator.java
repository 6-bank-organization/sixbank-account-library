package com.sixbank.accountlibrary.utility;

import java.util.UUID;

/**
 * Utility class for generating standardized account numbers.
 */
public class AccountNumberGenerator {
    public static String generateAccountNumber() {
        return "SIX" + UUID.randomUUID().toString().substring(0, 10).toUpperCase();
    }
}
