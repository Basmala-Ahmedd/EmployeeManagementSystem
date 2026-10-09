# EmployeeManagementSystem

**Student Name:** Basmala Ahmed Ali  
**Student ID:** 2300300.

## Description
A Java Object-Oriented Programming project based on the supplied UML class diagram. It models an abstract `Employee`, three concrete employee types (`CommissionEmployee`, `MonthlyEmployee`, and `HourlyEmployee`), a `Gender` enum, and a `Department` that manages employees and calculates payroll.

## Features
- Inheritance and method overriding for salary calculations.
- Encapsulated fields with getters and setters.
- Commission, monthly, bonus, and hourly/overtime salary calculations.
- Department manager and employee-list management.
- Add, remove, and find employees.
- Calculate total payroll and print all employees.
- Basic executable checks without external dependencies.

## Project Structure
```text
EmployeeManagementSystem/
├── src/
│   ├── Main.java
│   ├── model/
│   │   ├── Employee.java
│   │   ├── CommissionEmployee.java
│   │   ├── MonthlyEmployee.java
│   │   ├── HourlyEmployee.java
│   │   ├── Department.java
│   │   └── Gender.java
│   └── test/
│       └── MainTest.java
└── README.md
```

## Requirements
- JDK 11 or newer.
- Terminal, IntelliJ IDEA, Eclipse, NetBeans, or VS Code.

## Run the application
Open a terminal in the project root and compile the source files:

```bash
javac -d out src/model/*.java src/Main.java src/test/MainTest.java
```

Run the demo:

```bash
java -cp out Main
```

Run the checks:

```bash
java -cp out test.MainTest
```

## Assumptions
The UML diagram does not specify exact salary formulas or overtime thresholds. For this implementation:
- Commission = sales amount × commission rate / 100.
- Commission employee salary = base salary + commission.
- Monthly employee salary = monthly salary + the configured bonus percentage of monthly salary.
- Hourly employees receive the regular hourly rate for up to 160 hours per month and the overtime rate for hours above 160.
- Health-insured monthly employees receive 2 additional vacation days as a demonstration rule.

These assumptions can be adjusted if your instructor provided different formulas.

## GitHub submission
1. Replace the Student ID placeholder above with your actual ID.
2. Create a **Public** repository on GitHub (do not initialize it with a README).
3. From this project folder, run:

```bash
git init
git add .
git commit -m "Initial commit: Java diagram implementation"
git branch -M main
git remote add origin https://github.com/Basmala-Ahmedd/EmployeeManagementSystem.git
git push -u origin main
```

4. Replace the sample remote URL with your own repository URL.
5. Submit your full name, student ID, and repository link in the course Google Form.
