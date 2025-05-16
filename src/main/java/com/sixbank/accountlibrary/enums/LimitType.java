package com.sixbank.accountlibrary.enums;


/**
 * Types of account limits imposed on transactions.
 */
public enum LimitType {
    /**
     * Limit for ATM withdrawals.
     */
    ATM_WITHDRAWAL,

    /**
     * Limit for Point-of-Sale payments.
     */
    POS_PAYMENT,

    /**
     * Limit for online or intra-bank transfers.
     */
    ONLINE_TRANSFER,

    /**
     * Limit for transfers made across international borders.
     */
    INTERNATIONAL_TRANSFER,

    /**
     * Limit for transactions via mobile banking channels.
     */
    MOBILE_BANKING
}
