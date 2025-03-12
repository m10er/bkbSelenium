# Selenium-Cucumber Test Automation Framework

This project is a Selenium-Cucumber framework that utilizes modern test automation practices.

## Features

- Page Object Model (POM) design pattern
- SOLID principles
- Clean Code approach
- Thread-safe WebDriver management
- Cucumber BDD framework
- Ready infrastructure for Playwright integration
- Reporting capabilities

## Technologies

- Java 11
- Selenium 4.18.1
- Cucumber 7.15.0
- Playwright 1.41.2
- WebDriverManager 5.7.0
- JUnit 5.10.2
- Log4j 2.22.1
- Lombok

## Project Structure

```
src
├── main/java/com/bkb
│   ├── driver/          # WebDriver yönetimi
│   └── pages/           # Page Object sınıfları
└── test/java/com/bkb
    ├── runner/          # Cucumber test runner
    └── steps/           # Step tanımlamaları
```

## Installation

1. Install Java 11 JDK
2. Install Maven
3. Clone the project
4. Run `mvn clean install` command

## Running Tests

```bash
mvn clean test
```

## Reports

Test reports will be generated in the `target/cucumber-reports` directory. 