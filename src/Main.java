import model.*;
import java.time.LocalDate;

public class Main {

    private static final String LINE =
            "============================================================";

    public static void main(String[] args) {

        CommissionEmployee commissionEmployee =
                new CommissionEmployee(
                        101, "Mona Hassan", Gender.FEMALE,
                        LocalDate.of(2023, 2, 1),
                        8000, 5, 50000
                );

        MonthlyEmployee monthlyEmployee =
                new MonthlyEmployee(
                        102, "Omar Ali", Gender.MALE,
                        LocalDate.of(2022, 7, 15),
                        12000, 21, 10, true
                );

        HourlyEmployee hourlyEmployee =
                new HourlyEmployee(
                        103, "Salma Adel", Gender.FEMALE,
                        LocalDate.of(2024, 1, 10),
                        100, 175, 150
                );

        Department department =
                new Department(1, "Information Technology");

        department.setManager(monthlyEmployee);
        department.addEmployee(commissionEmployee);
        department.addEmployee(monthlyEmployee);
        department.addEmployee(hourlyEmployee);

        // Main dashboard
        System.out.println();
        System.out.println(LINE);
        System.out.println("             EMPLOYEE MANAGEMENT SYSTEM");
        System.out.println("                  ADMIN DASHBOARD");
        System.out.println(LINE);

        System.out.printf("%-25s : %s%n",
                "Department", department.getName());

        System.out.printf("%-25s : %d%n",
                "Department ID", department.getId());

        System.out.printf("%-25s : %s%n",
                "Department Manager",
                department.getManager().getName());

        System.out.printf("%-25s : %d%n",
                "Total Employees",
                department.getEmployees().size());

        System.out.println(LINE);

        // Employees table
        System.out.println("\nEMPLOYEE DIRECTORY");
        System.out.println(LINE);

        System.out.printf("%-6s %-18s %-12s %-15s %12s%n",
                "ID", "NAME", "TYPE", "GENDER", "SALARY");

        System.out.println(
                "------------------------------------------------------------"
        );

        for (Employee employee : department.getEmployees()) {

            String employeeType;

            if (employee instanceof CommissionEmployee) {
                employeeType = "Commission";
            } else if (employee instanceof MonthlyEmployee) {
                employeeType = "Monthly";
            } else {
                employeeType = "Hourly";
            }

            System.out.printf("%-6d %-18s %-12s %-15s %,12.2f%n",
                    employee.getId(),
                    employee.getName(),
                    employeeType,
                    employee.getGender(),
                    employee.calculateSalary());
        }

        System.out.println(LINE);

        // Salary details
        System.out.println("\nSALARY DETAILS");
        System.out.println(LINE);

        System.out.printf("%-30s : %12.2f%n",
                "Mona Hassan - Base Salary",
                commissionEmployee.getBaseSalary());

        System.out.printf("%-30s : %12.2f%n",
                "Mona Hassan - Commission",
                commissionEmployee.calculateCommission());

        System.out.printf("%-30s : %12.2f%n",
                "Omar Ali - Monthly Salary",
                monthlyEmployee.getMonthlySalary());

        System.out.printf("%-30s : %12.2f%n",
                "Omar Ali - Bonus",
                monthlyEmployee.getMonthlySalary()
                        * monthlyEmployee.getBonusPercentage() / 100.0);

        System.out.printf("%-30s : %12.2f%n",
                "Salma Adel - Total Salary",
                hourlyEmployee.calculateSalary());

        System.out.println(LINE);

        // Department payroll summary
        System.out.println("\nPAYROLL SUMMARY");
        System.out.println(LINE);

        System.out.printf("%-30s : %12.2f%n",
                "Total Department Payroll",
                department.calculateTotalPayroll());

        System.out.println(LINE);

        // Search example
        System.out.println("\nEMPLOYEE SEARCH");
        System.out.println(LINE);

        int searchId = 102;
        Employee found = department.findEmployee(searchId);

        if (found != null) {
            System.out.println("Employee found successfully!");
            System.out.println("ID       : " + found.getId());
            System.out.println("Name     : " + found.getName());
            System.out.println("Gender   : " + found.getGender());
            System.out.printf("Salary   : %.2f%n",
                    found.calculateSalary());
        } else {
            System.out.println("No employee found with ID: " + searchId);
        }

        System.out.println(LINE);
        System.out.println("             END OF SYSTEM REPORT");
        System.out.println(LINE);
        System.out.println();
    }
}