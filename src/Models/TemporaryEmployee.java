/*
 * @Author: Vinayak Sareen
 * Student ID: 40186182
 * */

package Models;

import Interface.EmployeeInterface;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TemporaryEmployee extends Employee
        implements EmployeeInterface {

    private double workingHours;
    private static HashMap<Integer, Double> echelonHourlyRate = new HashMap<>();
    private void setupHourlyRate() {
        echelonHourlyRate.put(1, 15.0);
        echelonHourlyRate.put(2, 20.0);
        echelonHourlyRate.put(3, 25.0);
        echelonHourlyRate.put(4, 30.0);
        echelonHourlyRate.put(5, 40.0);
    }

    private double calculateMonthlySalary(double numberOfWorkingHours,
                                        int echelonCategory) throws Exception {
        if (echelonCategory < 1 || echelonCategory > 5) { throw new Exception("Invalid Echelon Category"); }
        double echelonRate = echelonHourlyRate.get(echelonCategory);
        return numberOfWorkingHours * echelonRate;
    }

    public TemporaryEmployee(int id, String firstName,
                             String lastName,
                             int age,
                             double numberOfWorkingHours,
                             int echelonCategory) throws Exception {
        super(id, firstName, lastName, age, 0);
        setupHourlyRate();
        double monthlySalary = calculateMonthlySalary(numberOfWorkingHours, echelonCategory);
        super.setMonthlySalary(monthlySalary);
        this.workingHours = numberOfWorkingHours;
    }

    @Override
    public double getEmployeeMonthlySalary(Employee employee) {
        return super.getMonthlySalary();
    }

    public static Employee registerEmployee(Scanner snc)
            throws InputMismatchException {
        Employee employee;
        System.out.println("Please Enter the Employee id: ");
        int employeeID = snc.nextInt();
        System.out.println("Please Enter the Employee firstName: ");
        String employeeFirstName = snc.next();
        System.out.println("Please Enter the Employee lastName: ");
        String employeeLastName = snc.next();
        System.out.println("Please Enter the Employee Age: ");
        int employeeAge = snc.nextInt();
        System.out.println("Please Enter the Employee monthly working hours: ");
        double monthlyWorkHours = snc.nextDouble();
        System.out.println("Please Enter the Echelon Category: ");
        int echelonCategory = snc.nextInt();
        try {
            employee =
                    new TemporaryEmployee(employeeID,
                            employeeFirstName, employeeLastName,
                            employeeAge,
                            monthlyWorkHours,
                            echelonCategory);
            return employee;
        } catch (Exception exception) {
            System.out.println("Error creating the temporary employee record " + exception.getMessage());
            return null;
        }
    }


}
