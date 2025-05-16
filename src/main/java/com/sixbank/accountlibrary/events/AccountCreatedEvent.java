package com.sixbank.accountlibrary.events;

import java.util.UUID;

/**
 * Event representing the creation of a new account.
 * <p>
 * Typically emitted after an account has been successfully created in the system.
 */
public class AccountCreatedEvent extends BaseEvent {

    private final UUID accountId;
    private final String accountNumber;
    private final UUID customerId;

    /**
     * Constructs a new AccountCreatedEvent.
     *
     * @param accountId     the unique ID of the created account
     * @param accountNumber the public account number assigned
     * @param customerId    the ID of the customer who owns the account
     */
    public AccountCreatedEvent(UUID accountId, String accountNumber, UUID customerId) {
        super();
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.customerId = customerId;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public UUID getCustomerId() {
        return customerId;
    }
}
