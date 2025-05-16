package com.sixbank.accountlibrary.enums;

/**
 * Represents the role of an individual associated with a bank account.
 */
public enum HolderType {
    /**
     * The primary owner of the account.
     */
    PRIMARY,

    /**
     * A secondary owner with limited or shared access.
     */
    SECONDARY,

    /**
     * A person authorized to operate the account on behalf of the owner.
     */
    AUTHORIZED,

    /**
     * Legal guardian managing a minor's account.
     */
    GUARDIAN
}
