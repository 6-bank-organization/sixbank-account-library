package com.sixbank.accountlibrary.events;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Base class for all domain events in the account microservice.
 * <p>
 * Provides common metadata such as a unique event ID and creation timestamp
 * to support traceability, auditing, and idempotency across distributed systems.
 */
public abstract class BaseEvent {

    private final UUID eventId;
    private final LocalDateTime createdAt;

    /**
     * Constructs a new BaseEvent with auto-generated event ID and creation timestamp.
     */
    public BaseEvent() {
        this.eventId = UUID.randomUUID();
        this.createdAt = LocalDateTime.now();
    }

    /**
     * Returns the unique identifier for this event.
     *
     * @return UUID representing the event ID
     */
    public UUID getEventId() {
        return eventId;
    }

    /**
     * Returns the timestamp when this event was created.
     *
     * @return LocalDateTime of event creation
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
