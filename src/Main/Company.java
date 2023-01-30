/*
* @Author: Dikshant Yadav
* Student ID: 40221623
*  
* @Author: Vinayak Sareen
* Student ID: 40186182
* */

package Main;

import Interface.CompanyInterface;
import Models.Bill;
import Models.Employee;
import Models.PermanentEmployee;
import Models.TemporaryEmployee;
import java.util.*;

// Main class for execution of application
public class Company implements CompanyInterface {

    // objects to store the bills and employee information.
    public static ArrayList<Object> objects;

    // default constructor.
    public Company() {
        objects = new ArrayList<>();
    }

    // Parametrized constructor to initialise the existing objects.
    public Company(ArrayList<Object> entity) {
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

    // checking the object belonngs to employee class.
    @Override
    public Employee findEmployee(Object obj) {
    	
    	if (obj != null && obj instanceof Employee) {
            // Type cast the object into the employee.
            Employee employee = (Employee) obj;
            return employee;
        }
        return null;
    }

    // Menu of the application
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
                	
                	// Add employee, if user option -> 1.
                    Employee employee = addEmployee(scn);
                    if (employee == null) { continue;}
                    System.out.println("Employee added successfully !!");
                    objects.add(employee);
                    
                } else if (selectedOption == 2) {

                	// add a bill, if user option -> 1
                	
                	Bill bill = addBill(scn);
                	if(bill == null) { continue;}
                	System.out.println("Bill added successfully !!");
                	objects.add(bill);                    
                	
                } else if(selectedOption == 3) {
                	// issues cheques for Company Bills and to its employees
                	issueChecques();

                } else {
                    // exit the program & close the scanner
                	System.out.println("Thanks for using, and come back soon:)");
                    scn.close();
                    System.exit(0);
                }
            }
        }

    }

    // Adding the employee either as full-time or part-time.
    @Override
    public Employee addEmployee(Scanner snc) {
        boolean isValidSelection = false;
        Employee employee = null;
        
        //Selection menu for addition of employee
        System.out.println("Please select from menu \n" +
                "1. Permanent employee \n" +
                "2. Part time employee \n" +
                "3. Main Menu \n");

        while (isValidSelection == false) {
            int selection = snc.nextInt();
            if (selection == 1) {
                try {
                	// enroll the employee as full time employee
                    employee = PermanentEmployee.registerEmployee(snc);
                    isValidSelection = true;
                } catch (InputMismatchException exception) {
                    System.out.println("Invalid input exception" +
                            "while registering the permanent employee");
                    System.out.println("Try Again");
                }
            } else if (selection == 2) {
                try {
                	// enroll the employee as part time employee
                    employee = TemporaryEmployee.registerEmployee(snc);
                    isValidSelection = true;
                } catch (InputMismatchException exception) {
                	
                	//Exception handling, user has inputed wrong information opposite of which system is expecting
                    System.out.println("Invalid input exception" +
                            "while registering the temporary employee");
                }
            } else if (selection == 3) {
            	
            	// return to previous screen of menu
                return null;
            }else {
            	
            	// ask User to provide the number selection from 1 to 3.
                System.out.println("Wrong selection try again!, Please input the number from 1 to 3 .");
                continue;
            }
        }
        
        return employee;
    }

    public static void main(String[] args) {
        Company driver = new Company();
        
        
        //Initializing the scanner object.
        Scanner snc = new Scanner(System.in);
        
        // calling the driver method of the application
        driver.displayMenu(snc);
        
        //closing the scanner class
        snc.close();
    }

	@Override
	public Bill addBill(Scanner snc) {
		// TODO Auto-generated method stub
		Bill bill = Bill.addBill(snc);
		return bill;
	}

	@Override
	public void issueChecques() {
		// TODO Auto-generated method stub
		
		int objectSize = objects.size();
    	if(objectSize == 0) {
    		System.out.println("Empty Collection, please add items for issuing cheques");
    		return;
    	}
    	System.out.println("*************** COMMENCING PAYMENTS ***************");
    	for(int i = 0; i < objectSize; i++) {
    		
    		//fetching the every object from the objects arraylist.
    		Object currObj = objects.get(i);
    		
    		//checking if object belongs to employee class or not.
    		Employee emp = findEmployee(currObj);
    		if(emp == null) {
    			/* If object is not an employee then it must be a bill and remove that bill object from the array
    			   after the cheques has been processed
    			*/
    			Bill bill = (Bill) currObj;
    			int sequentialNumber = new Random().nextInt(900000) + 100000;
    			System.out.println(bill.toString() + ", chequeNumber: " + sequentialNumber);
    			objects.remove(i);                			
    		}else {
    			// Current object is a confirmed employee object and issue his salary and print the payslip
    			System.out.println(emp.toString());
    			
    		}
    	}
    	System.out.println("*************************************************");
		
	}


}
