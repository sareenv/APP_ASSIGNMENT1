package Main;

import Interface.MainInterface;
import Models.Bill;
import Models.Employee;
import Models.PermanentEmployee;
import Models.TemporaryEmployee;
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

    @Override
    public Employee findEmployee(Object obj) {
    	
    	if (obj != null && obj instanceof Employee) {
            // Type cast the object into the employee.
            Employee employee = (Employee) obj;
            return employee;
        }
        return null;
    }

    public void displayMenu(Scanner scn) {
        while(true) {
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
                if (selectedOption == 1) {
                    Employee employee = addEmployee(scn);
                    if (employee == null) { continue;}
                    System.out.println("Employee added successfully !!");
                    objects.add(employee);
                } else if (selectedOption == 2) {
                	// add a bill
                	Bill bill = Bill.addBill(scn);
                	if(bill == null) { continue;}
                	System.out.println("Bill added successfully !!");
                	objects.add(bill);                    
                } else if(selectedOption == 3) {
                	// issues cheques
                	
                	int objectSize = objects.size();
                	if(objectSize == 0) {
                		System.out.println("Empty Collection, please add items for issuing cheques");
                		continue;
                	}
                	System.out.println("*************** COMMENCING PAYMENTS ***************");
                	for(int i = 0; i < objectSize; i++) {
                		Object currObj = objects.get(i);
                		Employee emp = findEmployee(currObj);
                		if(emp == null) {
                			// not an employee object, is a bill object and remove that bill object from the array
                			Bill bill = (Bill) currObj;
                			System.out.println(bill.toString());
                			objects.remove(i);                			
                		}else {
                			// is a employee object and issue his salary and print the payslip
                			System.out.println(emp.toString());
                			
                		}
                	}
                	System.out.println("*************************************************");
                	

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
                try {
                    employee = PermanentEmployee.registerEmployee(snc);
                    isValidSelection = true;
                } catch (InputMismatchException exception) {
                    System.out.println("Invalid input exception" +
                            "while registering the permanent employee");
                    System.out.println("Try Again");
                }
            } else if (selection == 2) {
                try {
                    employee = TemporaryEmployee.registerEmployee(snc);
                    isValidSelection = true;
                } catch (InputMismatchException exception) {
                    System.out.println("Invalid input exception" +
                            "while registering the temporary employee");
                }
            } else if (selection == 3) {
                return null;
            }else {
                System.out.println("Wrong selection try again! ");
                continue;
            }
        }
        
        return employee;
    }

    public static void main(String[] args) {
        Main driver = new Main();
        Scanner snc = new Scanner(System.in);
        driver.displayMenu(snc);
        snc.close();
    }


}
