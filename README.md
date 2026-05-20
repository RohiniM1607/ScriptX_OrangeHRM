OrangeHRM Automation Testing Project

Project Overview
  This project is an automation testing framework developed for testing the OrangeHRM web application. The main objective of this project is to automate important HRM functionalities such as login, employee entitlement search, leave entitlement validation, and related workflows. The framework is built using Selenium WebDriver, Cucumber BDD, Java, Maven, TestNG/JUnit, and Jenkins for continuous integration.

Application Under Test

Application Name: OrangeHRM  
Application Type: Web Application  
Testing Type: Automation Testing  
Framework Type: BDD Framework  

Technologies Used
- Java
- Selenium WebDriver
- Cucumber BDD
- Maven
- TestNG / JUnit
- Page Object Model
- Log4j
- Jenkins
- Git and GitHub
- WebDriverManager

Project Structure

OrangeHRM_Automation_Project
│
├── src/test/java
│   │
│   ├── com.pages
│   │   └── Page classes
│   │
│   ├── com.stepdefinitions
│   │   └── Step definition classes
│   │
│   ├── com.actions
│   │   └── Action classes
│   │
│   ├── com.utilities
│   │   └── Helper classes, Config reader, Screenshot utility
│   │
│   ├── com.hooks
│   │   └── Hooks class
│   │
│   └── com.runner
│       └── Test runner class
│
├── src/test/resources
│   │
│   ├── features
│   │   └── Feature files
│   │
│   ├── config.properties
│   │
│   └── log4j2.xml
│
├── test-output
│
├── screenshots
│
├── pom.xml

Features Automated:
  The following functionalities are automated in this project:

Admin Login
Add Leave Entitlement
Approve/Reject Leave
Profile Picture
Employee Entitlement
Create Employee
Search Employee
