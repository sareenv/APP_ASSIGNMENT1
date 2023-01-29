/*
* @Author: Dikshant Yadav
* Student ID: 40221623
*  
* @Author: Vinayak Sareen
* Student ID: 40186182
* */

package Interface;
import Models.Employee;

// Employee Interface, helps in calculating the salary for employees and aims in providing the decoupled dependencies for further development
public interface EmployeeInterface {
	
	
    public double getEmployeeMonthlySalary(Employee employee);
}
