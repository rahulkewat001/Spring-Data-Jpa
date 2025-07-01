# 📘 Spring Data JPA Tutorial Project

This project demonstrates how to use **Spring Data JPA** to manage entity relationships and perform CRUD operations using a relational database with minimal boilerplate code.

---

## 🚀 Tech Stack

- 🌿 **Spring Boot 3**
- 📦 **Spring Data JPA**
- 🐬 **MySQL / H2 (for development)**
- 🔗 **Hibernate (JPA Provider)**
- 🧪 **JUnit 5**
- 📚 **Lombok**

---

## 📂 Project Structure

spring-data-jpa-tutorial
├── src
│ └── main
│ ├── java
│ │ └── JPA_HIBERNATE.spring.data.jpa.tutorial
│ │ ├── entity
│ │ │ ├── Student.java
│ │ │ ├── Course.java
│ │ │ ├── Teacher.java
│ │ │ └── CourseMaterial.java
│ │ ├── repository
│ │ └── SpringDataJpaTutorialApplication.java
│ └── resources
│ ├── application.properties
│ └── data.sql / schema.sql (optional)
└── pom.xml

## 🧠 What You’ll Learn

- How to configure Spring Boot with Spring Data JPA
- Creating and managing JPA entities
- Using repositories (`JpaRepository`, `CrudRepository`)
- Entity relationships:
  - 🔁 `@OneToOne`
  - 🔁 `@OneToMany`
  - 🔁 `@ManyToOne`
  - 🔁 `@ManyToMany`
- Using custom queries with `@Query`
- Pagination and sorting with `Pageable`

- 🤝 Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.
