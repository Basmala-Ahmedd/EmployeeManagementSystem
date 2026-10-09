package model;

import java.time.LocalDate;

/**
 * Base class for all employee types.
 * Salary calculation is specialized by each concrete employee class.
 */
public abstract class Employee {
    private int id;
    private String name;
    private Gender gender;
    private LocalDate hireDate;
    private Department department;

    public Employee(int id, String name, Gender gender, LocalDate hireDate) {
        this(id, name, gender, hireDate, null);
    }

    public Employee(int id, String name, Gender gender, LocalDate hireDate, Department department) {
        setId(id);
        setName(name);
        setGender(gender);
        setHireDate(hireDate);
        this.department = department;
    }

    public int getId() { return id; }
    public void setId(int id) {
        if (id <= 0) throw new IllegalArgumentException("Employee ID must be positive.");
        this.id = id;
    }

    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Employee name cannot be blank.");
        this.name = name;
    }

    public Gender getGender() { return gender; }
    public void setGender(Gender gender) {
        if (gender == null) throw new IllegalArgumentException("Gender is required.");
        this.gender = gender;
    }

    public LocalDate getHireDate() { return hireDate; }
    public void setHireDate(LocalDate hireDate) {
        if (hireDate == null) throw new IllegalArgumentException("Hire date is required.");
        this.hireDate = hireDate;
    }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', gender=" + gender
                + ", hireDate=" + hireDate
                + ", department=" + (department == null ? "Unassigned" : department.getName())
                + ", salary=" + String.format("%.2f", calculateSalary()) + "}";
    }
}
