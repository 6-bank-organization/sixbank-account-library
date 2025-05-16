package com.sixbank.accountlibrary.events;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Event representing a change in an account's balance.
 */
public class AccountBalanceUpdatedEvent extends BaseEvent {

    private final UUID accountId;
    private final BigDecimal previousBalance;
    private final BigDecimal newBalance;
    private final String reason;

    /**
     * Constructs a new AccountBalanceUpdatedEvent.
     *
     * @param accountId       the ID of the account whose balance changed
     * @param previousBalance the previous balance before the update
     * @param newBalance      the new balance after the update
     * @param reason          the reason for the balance update
     */
    public AccountBalanceUpdatedEvent(UUID accountId, BigDecimal previousBalance, BigDecimal newBalance, String reason) {
        super();
        this.accountId = accountId;
        this.previousBalance = previousBalance;
        this.newBalance = newBalance;
        this.reason = reason;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public BigDecimal getPreviousBalance() {
        return previousBalance;
    }

    public BigDecimal getNewBalance() {
        return newBalance;
    }

    public String getReason() {
        return reason;
    }
}
