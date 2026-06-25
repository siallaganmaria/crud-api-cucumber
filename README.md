# API Automation Testing with Java Cucumber

## Overview

This project is an API automation testing project built with Java, Cucumber, JUnit, Rest Assured, and JSON Schema Validator.

The test cases are written using Gherkin syntax in `.feature` files and executed through a Cucumber Test Runner in IntelliJ IDEA.

## Required Tools and Applications

Before running the tests, make sure the following tools and applications are installed:

## Tech Stack                                                       

 Java JDK                 
 IntelliJ IDEA            
 Maven                    
 Cucumber for Java Plugin 
 
## Test Run Result in IntelliJ IDEA

The test was executed from IntelliJ IDEA using the following runner:

## Notes
If the test fails because of dependency issues, reload Maven dependencies from IntelliJ.
If `.feature` files are not detected correctly, check that the Cucumber for Java and Gherkin plugins are installed.
If only one scenario is executed, run the test from `TestRunner.java` instead of running a single scenario directly from the `.feature` file.
If schema validation fails, check the JSON schema files under `src/test/resources/schemas`.          |
