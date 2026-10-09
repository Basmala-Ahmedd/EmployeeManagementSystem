package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** A department manages its employees and has one manager. */
public class Department {
    private int id;
    private String name;
    private Employee manager;
    private List<Employee> employees;

    public Department(int id, String name, Employee manager, List<Employee> employees) {
        setId(id);
        setName(name);
        this.employees = new ArrayList<>();
        if (employees != null) {
            for (Employee employee : employees) addEmployee(employee);
        }
        setManager(manager);
    }

    public Department(int id, String name) {
        this(id, name, null, new ArrayList<>());
    }

    public int getId() { return id; }
    public void setId(int id) {
        if (id <= 0) throw new IllegalArgumentException("Department ID must be positive.");
        this.id = id;
    }

    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Department name cannot be blank.");
        this.name = name;
    }

    public Employee getManager() { return manager; }
    public void setManager(Employee manager) {
        this.manager = manager;
        if (manager != null && manager.getDepartment() != this) manager.setDepartment(this);
    }

    /** Returns a read-only view to protect the department's employee list. */
    public List<Employee> getEmployees() { return Collections.unmodifiableList(employees); }

    public void setEmployees(List<Employee> employees) {
        this.employees.clear();
        if (employees != null) {
            for (Employee employee : employees) addEmployee(employee);
        }
    }

    public void addEmployee(Employee employee) {
        if (employee == null) throw new IllegalArgumentException("Employee cannot be null.");
        boolean exists = employees.stream().anyMatch(e -> e.getId() == employee.getId());
        if (!exists) employees.add(employee);
        if (employee.getDepartment() != this) employee.setDepartment(this);
    }

    public void removeEmployee(int employeeId) {
        employees.removeIf(employee -> employee.getId() == employeeId);
        if (manager != null && manager.getId() == employeeId) manager = null;
    }

    public Employee findEmployee(int employeeId) {
        return employees.stream()
                .filter(employee -> employee.getId() == employeeId)
                .findFirst()
                .orElse(null);
    }

    public double calculateTotalPayroll() {
        return employees.stream().mapToDouble(Employee::calculateSalary).sum();
    }

    public void printAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees in " + name + " department.");
            return;
        }
        employees.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Department{id=" + id + ", name='" + name + "', manager="
                + (manager == null ? "None" : manager.getName())
                + ", employeeCount=" + employees.size()
                + ", totalPayroll=" + String.format("%.2f", calculateTotalPayroll()) + "}";
    }
}
