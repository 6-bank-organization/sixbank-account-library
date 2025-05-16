package com.sixbank.accountlibrary.enums;

/**
 * Defines the different types of bank accounts.
 */
public enum AccountType {
    /**
     * Standard savings account with interest accrual.
     */
    SAVINGS,

    /**
     * Checking/current account for day-to-day transactions.
     */
    CHECKING,

    /**
     * Fixed deposit account with a set maturity date.
     */
    FIXED_DEPOSIT,

    /**
     * Loan account for borrowed funds.
     */
    LOAN,

    /**
     * Credit account for issuing credit lines.
     */
    CREDIT,

    /**
     * Investment account for holding stocks, bonds, or mutual funds.
     */
    INVESTMENT,

    /**
     * Account used for business or commercial purposes.
     */
    BUSINESS,

    /**
     * Jointly held account by two or more individuals.
     */
    JOINT
}
