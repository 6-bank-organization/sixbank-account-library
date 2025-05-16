package com.sixbank.accountlibrary.enums;

/**
 * Represents the current status of a bank account.
 */
public enum AccountStatus {
    /**
     * Account is created but not yet activated.
     */
    PENDING,

    /**
     * Account is fully functional and can perform transactions.
     */
    ACTIVE,

    /**
     * Account has not been used for a long time.
     */
    DORMANT,

    /**
     * Account is temporarily restricted from performing operations.
     */
    FROZEN,

    /**
     * Account has been permanently closed.
     */
    CLOSED,

    /**
     * Account is flagged and blocked due to suspicious or fraudulent activity.
     */
    BLOCKED
}
