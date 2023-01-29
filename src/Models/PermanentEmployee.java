/*
* @Author: Dikshant Yadav
* Student ID: 40221623
*  
* @Author: Vinayak Sareen
* Student ID: 40186182
* */
package Models;

import Interface.EmployeeInterface;

import java.util.InputMismatchException;
import java.util.Scanner;

// Permanent-Employee, which is a child of Employee class and implements the Employee Interface
public class PermanentEmployee extends Employee
    implements EmployeeInterface {
    public PermanentEmployee(int id,
                             String firstName,
                             String lastName,
                             int age,
                             double monthlySalary) {
    	
    	//passing the parameters to the parent class constructor which shares same properties with permanent employee.
        super(id, firstName, lastName, age, monthlySalary);
    }
    
    // Overriding the getEmployeeMonthlySalary from employee class, to specific for permanent employee.
    @Override
    public double getEmployeeMonthlySalary(Employee employee) {
        return super.getMonthlySalary();
    }
    
    // Taking User input, which are required for creating an employee
    public static Employee registerEmployee(Scanner snc) throws InputMismatchException {
        Employee employee;
        System.out.println("Please Enter the Employee id: ");
        int employeeID = snc.nextInt();
        System.out.println("Please Enter the Employee firstName: ");
        String employeeFirstName = snc.next();
        System.out.println("Please Enter the Employee lastName: ");
        String employeeLastName = snc.next();
        System.out.println("Please Enter the Employee Age: ");
        int employeeAge = snc.nextInt();
        System.out.println("Please Enter the Employee monthly Salary: ");
        double monthlySalary = snc.nextDouble();
        
        // Creating the employee, once the user has inputed the information
        employee =
                new PermanentEmployee(employeeID, employeeFirstName,
                        employeeLastName, employeeAge, monthlySalary);
        return employee;
    }
}
