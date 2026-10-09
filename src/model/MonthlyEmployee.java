package model;

import java.time.LocalDate;

/** Employee paid a monthly salary, with optional bonus and health insurance. */
public class MonthlyEmployee extends Employee {
    private double monthlySalary;
    private int vacationDays;
    private double bonusPercentage; // Percentage of monthly salary
    private boolean hasHealthInsurance;

    public MonthlyEmployee(int id, String name, Gender gender, LocalDate hireDate,
                           double monthlySalary, int vacationDays,
                           double bonusPercentage, boolean hasHealthInsurance) {
        super(id, name, gender, hireDate);
        setMonthlySalary(monthlySalary);
        setVacationDays(vacationDays);
        setBonusPercentage(bonusPercentage);
        setHasHealthInsurance(hasHealthInsurance);
    }

    public double getMonthlySalary() { return monthlySalary; }
    public void setMonthlySalary(double monthlySalary) {
        if (monthlySalary < 0) throw new IllegalArgumentException("Monthly salary cannot be negative.");
        this.monthlySalary = monthlySalary;
    }

    public int getVacationDays() { return vacationDays; }
    public void setVacationDays(int vacationDays) {
        if (vacationDays < 0) throw new IllegalArgumentException("Vacation days cannot be negative.");
        this.vacationDays = vacationDays;
    }

    public double getBonusPercentage() { return bonusPercentage; }
    public void setBonusPercentage(double bonusPercentage) {
        if (bonusPercentage < 0 || bonusPercentage > 100)
            throw new IllegalArgumentException("Bonus percentage must be between 0 and 100.");
        this.bonusPercentage = bonusPercentage;
    }

    public boolean isHasHealthInsurance() { return hasHealthInsurance; }
    public void setHasHealthInsurance(boolean hasHealthInsurance) {
        this.hasHealthInsurance = hasHealthInsurance;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary + (monthlySalary * bonusPercentage / 100.0);
    }

    public int calculateAdditionalVacation() {
        // Example policy: insured employees receive 2 extra days.
        return hasHealthInsurance ? 2 : 0;
    }

    @Override
    public String toString() {
        return "MonthlyEmployee{ " + super.toString() + ", monthlySalary=" + monthlySalary
                + ", vacationDays=" + vacationDays + ", bonusPercentage=" + bonusPercentage
                + "%, hasHealthInsurance=" + hasHealthInsurance
                + ", additionalVacation=" + calculateAdditionalVacation() + " }";
    }
}
