package Main;

import Interface.MainInterface;
import Models.Bill;
import Models.Employee;
import Models.PermanentEmployee;
import Models.TemporaryEmployee;

import javax.naming.spi.DirObjectFactory;
import java.util.*;

public class Main implements MainInterface {

    // objects to store the bills and employee information.
    public static ArrayList<Object> objects;

    // default constructor.
    public Main() {
        objects = new ArrayList<>();
    }

    // Parametrized constructor to initialise the existing objects.
    public Main(ArrayList<Object> entity) {
        objects = entity;
    }

    @Override
    public Employee findEmployeeByID(Integer employeeID) {
        for (Object obj: objects) {
            if (obj != null && obj instanceof Employee) {
                // Type cast the object into the employee.
                Employee employee = (Employee) obj;
                if (employee.getId() == employeeID) {
                    return (Employee) obj;
                }
            }
        }
        return null;
    }

    public void displayMenu(Scanner scn) {
        boolean validMenuItemSelected = false;
        while(validMenuItemSelected == false) {
            System.out.println("" +
                    "1. Add an employee \n" +
                    "2. Add a bill \n" +
                    "3. Issue cheques \n" +
                    "4. Exit \n"
            );
            int selectedOption = scn.nextInt();
            if (selectedOption > 4 || selectedOption < 1) {
                System.out.println("Invalid selection, Try again");
                continue;
            } else  {
                // valid menu item selected.
                if (selectedOption == 1 && addEmployee(scn) != null) {
                    Employee employee = addEmployee(scn);
                    if (employee == null) { validMenuItemSelected = false; continue;}
                    objects.add(employee);
                    validMenuItemSelected = true;
                } else if (selectedOption == 2) {
                    validMenuItemSelected = true;
                } else if(selectedOption == 3) {

                } else {
                    // exit the program & close the scanner
                    scn.close();
                    System.exit(0);
                }

            }
        }

    }

    @Override
    public Employee addEmployee(Scanner snc) {
        boolean isValidSelection = false;
        Employee employee = null;
        System.out.println("Please select from menu \n" +
                "1. Permanent employee \n" +
                "2. Part time employee \n" +
                "3. Main Menu \n");

        while (isValidSelection == false) {
            int selection = snc.nextInt();
            if (selection == 1) {
                employee = PermanentEmployee.registerEmployee(snc);
                isValidSelection = true;
            } else if (selection == 2) {
                employee = TemporaryEmployee.registerEmployee(snc);
                isValidSelection = true;
            } else if (selection == 3) {
                return null;
            }else {
                System.out.println("Wrong selection try again! ");
                continue;
            }
        }
        if (employee != null) { objects.add(employee); }
        return employee;
    }

    @Override
    public Bill addEmployeeBill(Scanner snc) {
        return null;
    }

    public static void main(String[] args) {
        Main driver = new Main();
        Scanner snc = new Scanner(System.in);
        driver.displayMenu(snc);
        snc.close();
    }
}
