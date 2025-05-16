package com.sixbank.accountlibrary.events;

import com.sixbank.accountlibrary.enums.AccountStatus;

import java.util.UUID;

/**
 * Event representing a change in an account's status.
 * <p>
 * Used to notify other microservices or components when an account's status transitions
 * (e.g., from PENDING to ACTIVE, ACTIVE to FROZEN, etc.).
 */
public class AccountStatusChangedEvent extends BaseEvent {

    private final UUID accountId;
    private final AccountStatus oldStatus;
    private final AccountStatus newStatus;

    /**
     * Constructs a new AccountStatusChangedEvent.
     *
     * @param accountId the ID of the account whose status changed
     * @param oldStatus the previous account status
     * @param newStatus the updated account status
     */
    public AccountStatusChangedEvent(UUID accountId, AccountStatus oldStatus, AccountStatus newStatus) {
        super();
        this.accountId = accountId;
        this.oldStatus = oldStatus;
        this.newStatus = newStatus;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public AccountStatus getOldStatus() {
        return oldStatus;
    }

    public AccountStatus getNewStatus() {
        return newStatus;
    }
}
