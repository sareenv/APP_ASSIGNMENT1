package Models;

import Interface.EmployeeInterface;

import java.util.Scanner;

public class PermanentEmployee extends Employee
    implements EmployeeInterface {
    public PermanentEmployee(int id,
                             String firstName,
                             String lastName,
                             int age,
                             double monthlySalary) {
        super(id, firstName, lastName, age, monthlySalary);
    }

    @Override
    public double getEmployeeMonthlySalary(Employee employee) {
        return super.getMonthlySalary();
    }

    public static Employee registerEmployee(Scanner snc) {
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
        employee =
                new PermanentEmployee(employeeID, employeeFirstName,
                        employeeLastName, employeeAge, monthlySalary);
        return employee;
    }
}
