/*
* @Author: Dikshant Yadav
* Student ID: 40221623
*  
* @Author: Vinayak Sareen
* Student ID: 40186182
* */

package Interface;
import Models.Bill;
import Models.Employee;
import java.util.*;

// Main Interface and Required functionalities
public interface MainInterface {
	public Employee findEmployeeByID(Integer employeeID);
    public Employee findEmployee(Object object);
    public void displayMenu(Scanner snc);
    public Employee addEmployee(Scanner snc);
    
}
