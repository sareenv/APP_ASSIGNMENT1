package Interface;
import Models.Bill;
import Models.Employee;
import java.util.*;

public interface MainInterface {
    public Employee findEmployeeByID(Integer employeeID);
    public void displayMenu(Scanner snc);
    public Employee addEmployee(Scanner snc);
    public Bill addEmployeeBill(Scanner scn);
}
