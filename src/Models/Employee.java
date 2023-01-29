/*
* @Author: Dikshant Yadav
* Student ID: 40221623
*  
* @Author: Vinayak Sareen
* Student ID: 40186182
* */

package Models;

public abstract class Employee {
	
	//Properties of employee class
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private double monthlySalary;

    //default constructor of employee 
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
    
    //Overriding the toString method from Object class
    @Override
    public String toString() {
        return "Issued Employee Salary :- " +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", monthlySalary=" + getMonthlySalary();
    }
    
    // setting the monthly-salary for an employee
    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }
    
    // return the monthly-salary for an employee
    public double getMonthlySalary() {
        return monthlySalary;
    }

}
