package Models;

import java.util.Scanner;

public abstract class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private double monthlySalary;

    public Employee(int id,
                    String firstName,
                    String lastName,
                    int age, double monthlySalary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.monthlySalary = monthlySalary;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", monthlySalary=" + monthlySalary +
                '}';
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

}
