# API Automation Testing with Java Cucumber


![Java](https://img.shields.io/badge/Java-21-blue)
![Maven](https://img.shields.io/badge/Maven-Build-orange)
![Cucumber](https://img.shields.io/badge/Cucumber-7.34.3-brightgreen)
![JUnit](https://img.shields.io/badge/JUnit-4.13.2-red)
![Rest%20Assured](https://img.shields.io/badge/Rest%20Assured-5.5.0-purple)
![JSON%20Schema](https://img.shields.io/badge/JSON%20Schema-Validator-yellow)
![IDE](https://img.shields.io/badge/IDE-IntelliJ%20IDEA-black)
---


## Overview

This project is an API automation testing project built with Java, Cucumber, JUnit, Rest Assured, and JSON Schema Validator.
The test cases are written using Gherkin syntax in `.feature` files and executed through a Cucumber Test Runner in IntelliJ IDEA.
The API used for testing is:
```text
https://jsonplaceholder.typicode.com
```
The tested resource is:
```text
/posts
```
---
## Tech Stack
## Tech Stack

- Java JDK 21
- Maven
- Cucumber Java
- JUnit 4
- Selenium WebDriver
- Rest Assured 5.5.0
- JSON Schema Validator
- IntelliJ IDEA

## Required Tools and Applications

Before running the tests, make sure the following tools and applications are installed:
Tool / Application	Purpose
Java JDK	Required to compile and run the Java test project
IntelliJ IDEA	IDE used to open, run, and debug the automation project
Maven	Used to manage dependencies and execute the test project
Cucumber for Java Plugin	Required to support Cucumber test execution in IntelliJ IDEA
Gherkin Plugin	Required to support `.feature` file syntax in IntelliJ IDEA
Internet Connection	Required because the tests access the JSONPlaceholder public API

## How to Run Test
Open the runner file:src/test/java/runners/TestRunner.java To run a specific feature or scenario, update the tags value or run all scenario with delete syntax tags at TestRunner.Java

## Notes
If the test fails because of dependency issues, reload Maven dependencies from IntelliJ IDEA.
If `.feature` files are not detected correctly, check that the Cucumber for Java and Gherkin plugins are installed.
If only one scenario is executed, run the test from `TestRunner.java` instead of running a single scenario directly from the `.feature` file.
If JSON schema validation fails, check the JSON schema files under `src/test/resources/schemas`.
