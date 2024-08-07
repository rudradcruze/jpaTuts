# JPA Practice

## Overview

This project is a Spring Boot application that demonstrates the use of JPA for database interactions. It includes functionalities for managing products, including pagination and sorting.

## Technologies Used

- Java
- Spring Boot
- JPA (Java Persistence API)
- Maven
- SQL

## Endpoints

### Get Products

- **URL:** `/products`
- **Method:** `GET`
- **Query Parameters:**
    - `sortBy` (optional): Field to sort by (default is `id`).
- **Response:** List of products sorted by the specified field.

### Get Products with Pagination

- **URL:** `/products/pagination`
- **Method:** `GET`
- **Query Parameters:**
    - `pageNo` (optional): Page number (default is `0`).
    - `sortBy` (optional): Field to sort by (default is `id`).
- **Response:** List of products for the specified page, sorted by the specified field.

### Get Products with Pagination and Filter

- **URL:** `/products/pagination2`
- **Method:** `GET`
- **Query Parameters:**
    - `pageNo` (optional): Page number (default is `0`).
    - `title` (optional): Title filter (default is empty).
    - `sortBy` (optional): Field to sort by (default is `id`).
- **Response:** List of products for the specified page, filtered by title and sorted by the specified field.

## Entity

### Product

- **Fields:**
    - `id`: Long
    - `sku`: String
    - `title`: String
    - `price`: BigDecimal
    - `quantity`: Integer
    - `createdAt`: LocalDateTime
    - `updatedAt`: LocalDateTime

## Repository

### ProductRepository

- **Methods:**
    - `findBy(Sort sort)`: List of products sorted by the specified sort order.
    - `findByTitle(String title)`: List of products with the specified title.
    - `findByTitle(String title, Pageable pageable)`: List of products with the specified title and pagination.
    - `findByTitleContainingIgnoreCase(String title, Pageable pageable)`: List of products containing the specified title (case-insensitive) with pagination.
    - `findByCreatedAtAfter(LocalDateTime createdAt)`: List of products created after the specified date.
    - `findByQuantityAndPrice(int quantity, BigDecimal price)`: List of products with the specified quantity and price.
    - `findByQuantityGreaterThanAndPriceLessThan(int quantity, BigDecimal price)`: List of products with quantity greater than the specified quantity and price less than the specified price.
    - `findByQuantityGreaterThanOrPriceLessThan(int quantity, BigDecimal price)`: List of products with quantity greater than the specified quantity or price less than the specified price.
    - `findProductsByTitleLike(String title)`: List of products with titles like the specified title.
    - `findProductsByTitleContaining(String title)`: List of products containing the specified title.
    - `findProductsByTitleContainingIgnoreCase(String title)`: List of products containing the specified title (case-insensitive).
    - `findProductByTitleAndPrice(String title, BigDecimal price)`: Optional product with the specified title and price.
    - `findProductByTitleAndPriceJPQL(String title, BigDecimal price)`: Optional product with the specified title and price using JPQL.
    - `findProductByTitleAndPriceJPQL2(String title, BigDecimal price)`: Optional product with the specified title and price using JPQL with positional parameters.

## Configuration

### `application.properties`

Configure your database connection and other properties in this file.

## Running the Application

1. Clone the repository.
2. Configure your database settings in `application.properties`.
3. Run the application using your IDE or `mvn spring-boot:run`.

## 🚀 About Me

Tech-savvy learner/programmer pushing boundaries of online tech. Passionate about new tools, seeking challenges to advance skills.

## 🔗 Social Links

![Name](https://img.shields.io/badge/Name-Francis%20Rudra%20D%20Cruze-yellowgreen?style=for-the-badge)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/rudradcruze)
[![twitter](https://img.shields.io/badge/twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/rudradcruze)
[![Facebook](https://img.shields.io/badge/facebook-4267B2?style=for-the-badge&logo=facebook&logoColor=white)](https://facebook.com/rudradcruze)
[![francisrudra@gmail.com](https://img.shields.io/badge/gmail-4267B2?style=for-the-badge&logo=gmail&logoColor=white)](mailto:francisrudra@gmail.com)