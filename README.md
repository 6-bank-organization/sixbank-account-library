# sixbank-account-library

**Version:** `0.0.1-SNAPSHOT`  
**Java Package:** `com.sixbank.accountlibrary`  
**License:** MIT  
**Author:** SIX Bank Engineering Team

---

## 🏦 Overview

The `sixbank-account-library` is a core Java library designed to provide **standardized domain models, enums, and events** for the Account Microservice within the **SIX Bank Platform**. This library enables consistent representation of account-related concepts across distributed services in the banking ecosystem.

It promotes reusability, event-driven architecture, and domain consistency across multiple services such as account management, ledger, notifications, and customer services.

---

## ✨ Features

- ✅ Centralized account-related enums (status, type, holder, limit).
- ✅ Standardized domain events for Kafka or messaging layers.
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
└── events
├── BaseEvent.java
├── AccountCreatedEvent.java
├── AccountStatusChangedEvent.java
└── AccountBalanceUpdatedEvent.java

````

## 🚀 Usage

You can import this library as a dependency in your microservices:

<details>
<summary>Gradle</summary>

```groovy
implementation 'com.sixbank:sixbank-account-library:0.0.1-SNAPSHOT'
````

</details>

<details>
<summary>Maven</summary>

```xml
<dependency>
    <groupId>com.sixbank</groupId>
    <artifactId>sixbank-account-library</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

</details>

---

## 🛡️ Best Practices

* All services using account events should subscribe to changes via Kafka or a message broker.
* Extend the event model to support versioning (`v1`, `v2`, etc.) if the schema evolves.
* Avoid including business logic in this library — keep it lightweight and focused on model definitions.

---

## 🧪 Testing

This library is designed to be used in microservices, so unit testing should be performed at the service level using mocked events and enums.

---

## 📄 License

This project is licensed under the MIT License. See `LICENSE` for more details.

---

## 💬 Contact

For internal contributions or improvements, please contact the **SIX Bank Engineering Team**.
