# E-Commerce Automation Framework – Selenium Java

This project is a real-time Selenium automation framework built using Java, Selenium WebDriver, TestNG, and Maven. The framework is designed to create stable, maintainable, and reusable automated test cases for web applications.

## Tech Stack
- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- Data Driven Testing (Excel)
- Log4j Logging
- TestNG Listeners
- Parallel Execution (ThreadLocal WebDriver)
- Jenkins (basic CI understanding via personal setup)

## Framework Design
- Hybrid Automation Framework (POM + Data Driven)
- Clear separation of test logic and page elements
- Reusable utility methods for common actions

## Project Structure
- base → WebDriver setup and test initialization
- pages → Page Object classes
- tests → Test classes
- utils → Excel handling, waits, screenshots
- listeners → Screenshot capture on test failure
- resources → Configuration files and test data

## Automated Test Scenarios
- Login functionality
- Add multiple products to cart
- Cart validation
- Checkout navigation

## Key Features
- Page Object Model for maintainability
- Data-driven execution using Excel
- Explicit and Fluent waits for synchronization
- Screenshot capture on test failure
- Logging using Log4j
- Parallel execution using TestNG and ThreadLocal WebDriver

## Execution
- Run tests using TestNG XML file
- Run using Maven command:
  mvn clean test

## CI/CD
- Jenkins used on personal setup to understand CI execution flow
- Framework supports Maven-based CI execution

## Author
Sanjana SK  
Automation QA Engineer  
LinkedIn: https://www.linkedin.com/in/sanjnask
