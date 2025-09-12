# Online Shop - Spring Boot Project

[![Java](https://img.shields.io/badge/Java-21-blue)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.5-green)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-Build-orange)](https://maven.apache.org/)
[![MySQL](https://img.shields.io/badge/Database-MySQL-blue)](https://www.mysql.com/)
[![Docker](https://img.shields.io/badge/Docker-Container-lightblue)](https://www.docker.com/)
[![Swagger](https://img.shields.io/badge/API%20Docs-Swagger-yellowgreen)](https://swagger.io/)


---

## 📖 Project Overview

**Online Shop** is a **comprehensive, production-ready e-commerce backend** built with **Spring Boot**.  
It demonstrates **modern backend practices**, including:

- **Clean separation of layers**: Controller, Service, Repository, DTO, Entity  
  - Ensures that each layer has a **single responsibility**, making the code **maintainable**, **testable**, and **scalable**.

- **Validation & Custom Field Validation**
  - Ensures input integrity using **Jakarta Bean Validation** (`@NotNull`, `@Size`, etc.) and **custom validators** (e.g., phone numbers, product constraints).

- **Transactional operations** to ensure data consistency  
  - Guarantees that **multiple database operations** either complete successfully together or **rollback entirely** in case of errors, preventing inconsistent data.

- **Security** with JWT authentication and role-based access  
  - Protects endpoints with **JSON Web Tokens**

- **Caching** with **Caffeine cache provider** for high-performance queries  
  - Reduces database load and **improves response times** for frequently accessed endpoints by storing results in memory.

- **Auditing**  
  - Automatically tracks **created and modified timestamps**, along with the **user responsible** for changes, providing visibility into entity lifecycle.

- **Historical Tracking**  
  - Spring Data **Envers** keeps **previous versions of entities**, allowing **audit trails**, **rollback**, and **version comparison**.

- **Object Mapping with ModelMapper**
  - Simplifies **DTO ↔ Entity conversions**, keeping services and controllers clean.

- **Boilerplate Reduction with Lombok**
  - Reduces repetitive code for getters, setters, constructors, and builders, improving readability.

- **Dockerized deployment** for quick setup  
  - Enables **one-command setup** of the application and database, making it easy to deploy in any environment without manual configuration.

- **Sample data initialization** using `import.sql`  
  - Provides **preloaded data** for development and testing, so you can **run the project immediately** without manually inserting records.

- **Unit and integration tests** across all layers  
  - Ensures the **reliability of business logic**, API endpoints, and database interactions, helping prevent regressions and improve code quality.

The project covers all essential modules of an e-commerce system: **Users, Products, Categories, Customers, Orders, Order Items, Stock, and Shipping Addresses**.

---

## 🏗️ Architecture & Modules

The project is organized in **well-defined modules**, each responsible for a specific domain:

| Module              | Description                                                                           |
|---------------------|---------------------------------------------------------------------------------------|
| **User**            | Manage user information, username and user password                                   |
| **Customer**        | Manage customer information, addresses, and user associations                         |
| **Order**           | Handle customer orders, link orders to order items, and manage stock updates          |
| **OrderItem**       | Represents individual items in an order with quantity, price, and product association |
| **Product**         | Catalog management with stock tracking, category association, and price management    |
| **Category**        | Groups products into categories (ManyToMany relationship with Product)                |
| **Stock**           | Tracks product inventory, ensures atomic stock deduction during order creation        |
| **ShippingAddress** | Stores shipping information per order                                                 |

---

### 🔑 Core Features
- **Spring Boot**  
  - Provides rapid application development with **auto-configuration**, **embedded server**, and production-ready features, reducing boilerplate setup.

- **Maven**  
  - Handles **project build, dependency management, and plugins**, ensuring consistent builds across environments.

- **Database Management**:  
  - MySQL for **development and production**, H2 for **testing**.  
  
  **Sample data** is loaded automatically via `import.sql`.

- **REST API with Versioning**:  
  - Versioned endpoints (`/api/v1/...`) ensure backward compatibility and smooth API evolution.  

- **Multiple Profiles**:  
  - `application-dev.properties` → Development  
  - `application-prod.properties` → Production  
  - `application-test.properties` → Test  
  Profiles can be switched easily during runtime.  

- **Interactive API Documentation**:  
  Swagger / Springdoc OpenAPI provides **interactive documentation**, making it easy to test APIs.  
  JWT authentication is required to access secured endpoints, including Swagger UI.  

- **Security**:  
  - **JWT Authentication** protects all sensitive endpoints  
  - **Role-based access control** ensures proper permissions  
  - **Swagger UI is secured** to prevent unauthorized access  
  - **Disabling security:** **app.security.enabled=false**
- 
- **Global Exception Handling**:  
  - Custom `@ControllerAdvice` ensures **consistent error responses** across all endpoints.  

- **Field validation**: Using standard validation annotations to enforce data integrity.

- **Custom field validation**: Implementing custom validation logic for advanced business rules. For example Iranian phone number. 
- 
- **ModelMapper** for clean and efficient mapping between Entities and DTOs

- **Caching**:  
  Frequently accessed endpoints are cached using **Caffeine**, reducing database load and improving response times.  
- 
- **Lombok** to reduce boilerplate code (getters, setters, constructors, builders, etc.)

- **Auditing**:  
  - Automatically tracks **created** and **modified timestamps**  
  - Provides insight into entity lifecycle events  

- **Historical Tracking**:  
  Spring Data **Envers** records all entity changes, enabling audit trails and rollback capability.  

- **Transactional Business Logic**:  
  - **Atomic stock deduction** during order creation  
  - Transactions **rollback** if stock is insufficient  
  - **Optimistic locking** with `@Version` ensures safe concurrent updates  

- **Dockerized Deployment**:  
  Docker Compose provides reproducible setup for the app and MySQL.  
  Easily deploy the entire system in any environment.  

- **Unit and Integration Testing**:  
  - Unit tests cover **controllers, services, repositories**  
  - Integration tests with H2 database validate **transactional behavior** and API correctness  

---

## 🛠️ Technology Stack


| Layer / Purpose       | Technology / Library                                                     |
|-----------------------|--------------------------------------------------------------------------|
| Language              | Java 21                                                                  |
| Framework             | Spring Boot 3.5.5                                                        |
| Build Tool            | Maven                                                                    |
| Database              | MySQL (dev & prod), H2 (test)                                            |
| ORM                   | Spring Data JPA, Hibernate                                               |
| Auditing              | Spring Data JPA Auditing                                                 |
| Historical Tracking   | Spring Data JPA Envers                                                   |
| Validation            | Jakarta Bean Validation (JSR-380), Custom Validators                     |
| API Documentation     | Springdoc OpenAPI / Swagger (`@OpenAPIDefinition`, `@Operation`, `@Tag`) |
| Security              | Spring Security + JWT                                                    |
| Caching               | Caffeine                                                                 |
| Object Mapping        | ModelMapper                                                              |
| Boilerplate Reduction | Lombok                                                                   |
| Testing               | JUnit 5, Mockito, Spring Boot Test                                       |
| Containerization      | Docker, Docker Compose                                                   |

---

## ⚙️ Installation & Setup

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/mohsenahmadinejad/online-shop.git
cd online-shop
```

### 2️⃣ Configure Environment Profiles

The project uses multiple Spring profiles for environment separation:

- **Development**: `application-dev.properties`  
- **Production**: `application-prod.properties`  
- **Testing**: `application-test.properties`  

Switch profiles:

```bash
# Maven run with dev profile
mvn spring-boot:run -Dspring-boot.run.profiles=dev

# Run jar with production profile
- Setup MySql database/create online-shop database 
java -jar target/online-shop.jar --spring.profiles.active=prod

# Run jar with production profile
- Setup MySql database/create online-shop database
java -jar target/online-shop.jar --spring.profiles.active=dev --app.security.enabled=false
```

---

### 3️⃣ Run with Docker Compose

The project comes with `docker-compose.yml`:

```bash
docker-compose up --build
```

This setup:

1. Builds the Spring Boot application image  
2. Starts MySQL container  
3. Connects the app to the database automatically  

For testing:

```bash
docker-compose -f docker-compose-test.yml up --build
```

---

### 📖 API Documentation

The project includes **interactive API documentation** powered by **Swagger / OpenAPI**.  
Extensive configuration and annotations are applied to make the documentation clear and developer-friendly:
Swagger allows **interactive testing** and **endpoint exploration**.
Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

JWT token is required for secured endpoints if security is enabled. To disable it set **app.security.enabled=false** 

- **@OpenAPIDefinition**: Provides high-level metadata such as title, description, version, and server info.
- **@Tag**: Groups related endpoints for better readability.
- **@Operation**: Documents individual API operations with summaries and descriptions.
- **@Schema**: Documents entity fields and relationships for DTOs and Entities.

Swagger UI is secured but accessible with proper authentication, making it easy to explore, test, and integrate APIs.

## 💡 Example API Requests

- **List all products with pagination and sorting**:

```
GET /api/v1/products?page=0&size=10&sort=name,asc
```

- **Create an order**:

```
POST /api/v1/orders
Content-Type: application/json
```

```json
{
  "customerId": 1,
  "items": [
    {
      "productId": 1,
      "quantity": 2
    }
  ]
}
```

- **Add a product**:

```
POST /api/v1/products
Content-Type: application/json
```

```json
{
  "name": "New Product",
  "price": 49.99,
  "categoryIds": [1, 2],
  "stockQuantity": 100
}
```

- **Add a shipping address**:

```
POST /api/v1/shipping-address
Content-Type: application/json
```

```json
{
  "orderId": 1,
  "street": "123 Main St",
  "city": "Tehran",
  "state": "Tehran",
  "zipCode": "12345"
}
```

---

## ✅ Testing

- **Unit Tests**:

```bash
./mvnw test
```

- **Integration Tests**:  
  Validate **controllers, services, repositories, and transactional business logic**  
  H2 database is used in the **test** profile  

- Tests include **edge cases** like insufficient stock and invalid inputs.

---

## 📚 Notes & Best Practices

- **Layered Architecture**  
  Keep strict separation between Controller, Service, Repository, DTO, and Entity layers.  
  This makes the project easier to **maintain, test, and scale**.

- **Transactional Boundaries**  
  Use `@Transactional` wisely to ensure **data consistency**.  
  Avoid placing transactions in controllers; prefer service-level transactions.

- **Validation**
  - Use **Jakarta Bean Validation** (`@NotNull`, `@Size`, `@Email`, etc.) for field-level constraints.
  - Implement **custom validators** when business rules cannot be expressed with built-in annotations.
  - Always validate **input DTOs** rather than entities.

- **Security**  
  Protect endpoints with **JWT authentication** and apply **role-based access control**.  
  Never expose sensitive endpoints without authentication, including Swagger UI.

- **API Documentation**  
  Annotate endpoints and models using `@OpenAPIDefinition`, `@Operation`, and `@Tag`.  
  This ensures **clear, interactive API docs** and makes the project easier to understand for new developers.

- **Caching**  
  Apply **Caffeine cache** only to frequently accessed queries.  
  Define proper **cache eviction policies** to prevent stale data issues.

- **Auditing & Historical Tracking**
  - Use **Spring Data Auditing** for `createdAt`, `updatedAt`, `createdBy`, and `modifiedBy`.
  - Enable **Hibernate Envers** to maintain full entity history, which supports rollback and audit trails.

- **Object Mapping**  
  Use **ModelMapper** to convert between Entities and DTOs.  
  Keep mapping logic out of services to avoid clutter.

- **Boilerplate Reduction**  
  Apply **Lombok** annotations (`@Getter`, `@Setter`, `@Builder`, `@RequiredArgsConstructor`) to keep the code concise.  
  Be careful with `@Data` in entities to avoid issues with JPA proxies.

- **Profiles & Configurations**  
  Separate configs for `dev`, `prod`, and `test`.  
  Always run local development with a **profile close to production** (e.g., MySQL instead of only H2).

- **Testing**
  - Write **unit tests** for services and utilities.
  - Use **integration tests** with H2 to validate transactional behavior and database interactions.
  - Mock external dependencies using **Mockito** where necessary.

- **Containerization**  
  Run the project with **Docker Compose** to ensure consistency across environments.  
  Keep **application configuration externalized** for flexibility in deployments.
---

## 📌 License

MIT License © Mohsen Ahmadinejad

