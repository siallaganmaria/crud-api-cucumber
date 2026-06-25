API Automation Testing with Java Cucumber
![Java](https://img.shields.io/badge/Java-21-blue)
![Maven](https://img.shields.io/badge/Maven-Build-orange)
![Cucumber](https://img.shields.io/badge/Cucumber-7.34.3-brightgreen)
![JUnit](https://img.shields.io/badge/JUnit-4.13.2-red)
![Rest%20Assured](https://img.shields.io/badge/Rest%20Assured-5.5.0-purple)
![JSON%20Schema](https://img.shields.io/badge/JSON%20Schema-Validator-yellow)
![IDE](https://img.shields.io/badge/IDE-IntelliJ%20IDEA-black)
---
Overview
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
Tech Stack
Technology	Description
Java JDK 21	Used as the main programming language and runtime environment
Maven	Used for dependency management and test execution
Cucumber 7.34.3	Used to write test scenarios in BDD format
JUnit 4.13.2	Used as the test execution framework
Rest Assured 5.5.0	Used to send HTTP requests and validate API responses
JSON Schema Validator	Used to validate API response body structure
IntelliJ IDEA	Used as the main IDE for development and test execution
---
Required Tools and Applications
Before running the tests, make sure the following tools and applications are installed:
Tool / Application	Purpose
Java JDK	Required to compile and run the Java test project
IntelliJ IDEA	IDE used to open, run, and debug the automation project
Maven	Used to manage dependencies and execute the test project
Cucumber for Java Plugin	Required to support Cucumber test execution in IntelliJ IDEA
Gherkin Plugin	Required to support `.feature` file syntax in IntelliJ IDEA
Internet Connection	Required because the tests access the JSONPlaceholder public API
---
Project Structure
```text
src
└── test
    ├── java
    │   ├── runners
    │   │   └── TestRunner.java
    │   └── steps
    │       └── PostSteps.java
    └── resources
        ├── features
        │   └── posts.feature
        └── schemas
            ├── create-post-schema.json
            ├── delete-post-schema.json
            └── update-post-schema.json
```
---
Setup Instructions
1. Clone the Project
```bash
git clone <repository-url>
cd <project-folder>
```
2. Open the Project in IntelliJ IDEA
Open IntelliJ IDEA, then select:
```text
File > Open
```
Choose the project folder and wait until IntelliJ finishes indexing and Maven finishes downloading the dependencies.
3. Configure Java SDK
Go to:
```text
File > Project Structure > Project
```
Set the Project SDK to:
```text
JDK 21
```
4. Install Required Plugins
Open:
```text
File > Settings > Plugins
```
Install or enable:
```text
Cucumber for Java
Gherkin
```
Restart IntelliJ IDEA if required.
5. Reload Maven Dependencies
From IntelliJ IDEA, open the Maven panel and click:
```text
Reload All Maven Projects
```
Or run:
```bash
mvn clean install
```
---
How to Run the Tests in IntelliJ IDEA
The recommended way to run all scenarios is through the Cucumber Test Runner.
Steps:
Open the runner file:
```text
src/test/java/runners/TestRunner.java
```
Right-click inside the `TestRunner` class.
Select:
```text
Run 'TestRunner'
```
IntelliJ IDEA will execute all scenarios from:
```text
src/test/resources/features/posts.feature
```
---
Notes
If the test fails because of dependency issues, reload Maven dependencies from IntelliJ IDEA.
If `.feature` files are not detected correctly, check that the Cucumber for Java and Gherkin plugins are installed.
If only one scenario is executed, run the test from `TestRunner.java` instead of running a single scenario directly from the `.feature` file.
If JSON schema validation fails, check the JSON schema files under `src/test/resources/schemas`.
