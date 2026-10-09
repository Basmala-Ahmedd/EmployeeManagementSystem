package model;

import java.time.LocalDate;

/** Employee paid by regular hours and an overtime rate. */
public class HourlyEmployee extends Employee {
    private double hourlyRate;
    private double hoursWorked;
    private double overtimeRate;

    public HourlyEmployee(int id, String name, Gender gender, LocalDate hireDate,
                          double hourlyRate, double hoursWorked, double overtimeRate) {
        super(id, name, gender, hireDate);
        setHourlyRate(hourlyRate);
        setHoursWorked(hoursWorked);
        setOvertimeRate(overtimeRate);
    }

    public double getHourlyRate() { return hourlyRate; }
    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate < 0) throw new IllegalArgumentException("Hourly rate cannot be negative.");
        this.hourlyRate = hourlyRate;
    }

    public double getHoursWorked() { return hoursWorked; }
    public void setHoursWorked(double hoursWorked) {
        if (hoursWorked < 0) throw new IllegalArgumentException("Hours worked cannot be negative.");
        this.hoursWorked = hoursWorked;
    }

    public double getOvertimeRate() { return overtimeRate; }
    public void setOvertimeRate(double overtimeRate) {
        if (overtimeRate < 0) throw new IllegalArgumentException("Overtime rate cannot be negative.");
        this.overtimeRate = overtimeRate;
    }

    @Override
    public double calculateSalary() {
        double regularHours = Math.min(hoursWorked, 160.0);
        double overtimeHours = Math.max(0.0, hoursWorked - 160.0);
        return regularHours * hourlyRate + overtimeHours * overtimeRate;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{ " + super.toString() + ", hourlyRate=" + hourlyRate
                + ", hoursWorked=" + hoursWorked + ", overtimeRate=" + overtimeRate + " }";
    }
}
