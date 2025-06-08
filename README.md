# sixbank-account-library

**Version:** `0.0.3-SNAPSHOT`  
**Java Package:** `com.sixbank.accountlibrary`  
**License:** MIT  
**Author:** SIX Bank Engineering Team

---

## 🏦 Overview

The `sixbank-account-library` is a core Java library designed to provide **standardized domain models, enums, events**, and **utility helpers** for the Account Microservice within the **SIX Bank Platform**. This library enables consistent representation of account-related concepts across distributed services in the banking ecosystem.

It promotes reusability, event-driven architecture, domain consistency, and standardized utility logic across services such as account management, ledger, notifications, and customer services.

---

## ✨ Features

- ✅ Centralized account-related enums (status, type, holder, limit).
- ✅ Standardized domain events for Kafka or messaging layers.
- ✅ Utility class for account number generation and masking.
- ✅ Built-in metadata for traceability (`eventId`, `createdAt`).
- ✅ Lightweight and suitable for modular microservice deployments.
- ✅ Extensible for future account-related actions or statuses.

---

## 📦 Package Structure

```

com.sixbank.accountlibrary
│
├── enums
│   ├── AccountStatus.java
│   ├── AccountType.java
│   ├── HolderType.java
│   └── LimitType.java
│
├── events
│   ├── BaseEvent.java
│   ├── AccountCreatedEvent.java
│   ├── AccountStatusChangedEvent.java
│   └── AccountBalanceUpdatedEvent.java
│
└── utility
└── AccountNumberGenerator.java

````

---

## 🚀 Usage

You can import this library as a dependency in your microservices:

<details>
<summary>Gradle</summary>

```groovy
implementation 'com.sixbank:sixbank-account-library:0.0.3'
````

</details>

<details>
<summary>Maven</summary>

```xml
<dependency>
    <groupId>com.sixbank</groupId>
    <artifactId>sixbank-account-library</artifactId>
    <version>0.0.3-SNAPSHOT</version>
</dependency>
```

</details>

---

## ⚙️ Configuring Account Number Prefix

The library includes a `AccountNumberGenerator` utility that generates account numbers using a configurable prefix.

### Option 1: `application.yaml`

```yaml
sixbank:
  account:
    prefix: SIX
```

### Option 2: `application.properties`

```properties
sixbank.account.prefix=SIX
```

### Create a Configuration Class

```java
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "sixbank.account")
public class AccountProperties {
    private String prefix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
```

### Inject and Use in Service

```java
@Service
public class AccountService {

    private final AccountProperties properties;

    public AccountService(AccountProperties properties) {
        this.properties = properties;
    }

    public void createAccount() {
        String accountNumber = AccountNumberGenerator.generateAccountNumber(properties.getPrefix());
        // Use account number as needed
    }
}
```

> ✅ If the prefix is not set, the generator defaults to `"SIX"`.

---

## 🛡️ Best Practices

* All services using account events should subscribe to changes via Kafka or a message broker.
* Extend the event model to support versioning (`v1`, `v2`, etc.) if the schema evolves.
* Avoid including business logic in this library — keep it lightweight and focused on models and shared utilities.

---

## 🧪 Testing

This library is intended to be used within microservices. Unit and integration testing should be performed at the service level using mocks for domain models, enums, and events.

---

## 📄 License

This project is licensed under the MIT License. See the `LICENSE` file for details.

---

## 💬 Contact

For internal contributions, issues, or improvements, please reach out to the **SIX Bank Engineering Team**.
