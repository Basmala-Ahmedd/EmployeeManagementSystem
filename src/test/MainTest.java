package test;

import model.*;
import java.time.LocalDate;

/**
 * Lightweight executable checks (no external test framework required).
 * Run this class separately to verify key calculations and department operations.
 */
public class MainTest {
    public static void main(String[] args) {
        CommissionEmployee commission = new CommissionEmployee(
                1, "Test Commission", Gender.MALE, LocalDate.of(2025, 1, 1),
                1000, 10, 5000);
        check(commission.calculateCommission() == 500.0, "Commission calculation");
        check(commission.calculateSalary() == 1500.0, "Commission employee salary");

        MonthlyEmployee monthly = new MonthlyEmployee(
                2, "Test Monthly", Gender.FEMALE, LocalDate.of(2025, 1, 1),
                2000, 20, 5, true);
        check(monthly.calculateSalary() == 2100.0, "Monthly employee salary");
        check(monthly.calculateAdditionalVacation() == 2, "Additional vacation");

        HourlyEmployee hourly = new HourlyEmployee(
                3, "Test Hourly", Gender.MALE, LocalDate.of(2025, 1, 1),
                10, 170, 15);
        check(hourly.calculateSalary() == 1750.0, "Hourly employee salary with overtime");

        Department department = new Department(10, "Testing");
        department.setManager(monthly);
        department.addEmployee(commission);
        department.addEmployee(monthly);
        department.addEmployee(hourly);
        check(department.findEmployee(2) == monthly, "Find employee");
        check(department.calculateTotalPayroll() == 5350.0, "Total payroll");

        department.removeEmployee(1);
        check(department.findEmployee(1) == null, "Remove employee");

        System.out.println("All checks passed successfully.");
    }

    private static void check(boolean condition, String testName) {
        if (!condition) throw new AssertionError("Failed: " + testName);
        System.out.println("PASS: " + testName);
    }
}
