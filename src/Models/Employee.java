/*
 * @Author: Vinayak Sareen
 * Student ID: 40186182
 * */

package Models;

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
        return "Issued Employee Salary :- " +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", monthlySalary=" + getMonthlySalary();
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

}
