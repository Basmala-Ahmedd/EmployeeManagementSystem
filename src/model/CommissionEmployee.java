package model;

import java.time.LocalDate;

/** Employee paid a base salary plus commission on sales. */
public class CommissionEmployee extends Employee {
    private double baseSalary;
    private double commissionRate; // Percentage, e.g. 5 means 5%
    private double salesAmount;

    public CommissionEmployee(int id, String name, Gender gender, LocalDate hireDate,
                              double baseSalary, double commissionRate, double salesAmount) {
        super(id, name, gender, hireDate);
        setBaseSalary(baseSalary);
        setCommissionRate(commissionRate);
        setSalesAmount(salesAmount);
    }

    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0) throw new IllegalArgumentException("Base salary cannot be negative.");
        this.baseSalary = baseSalary;
    }

    public double getCommissionRate() { return commissionRate; }
    public void setCommissionRate(double commissionRate) {
        if (commissionRate < 0 || commissionRate > 100)
            throw new IllegalArgumentException("Commission rate must be between 0 and 100.");
        this.commissionRate = commissionRate;
    }

    public double getSalesAmount() { return salesAmount; }
    public void setSalesAmount(double salesAmount) {
        if (salesAmount < 0) throw new IllegalArgumentException("Sales amount cannot be negative.");
        this.salesAmount = salesAmount;
    }

    public double calculateCommission() {
        return salesAmount * commissionRate / 100.0;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + calculateCommission();
    }

    @Override
    public String toString() {
        return "CommissionEmployee{ " + super.toString() + ", baseSalary=" + baseSalary
                + ", commissionRate=" + commissionRate + "%, salesAmount=" + salesAmount
                + ", commission=" + String.format("%.2f", calculateCommission()) + " }";
    }
}
