package Tests;

import Main.Main;
import Models.Employee;
import org.junit.*;

import java.util.Scanner;

public class ManageTests {
    @Test
    public void addInValidEmployeeStream() {
        Scanner snc = new Scanner(System.in);
        Main driver = new Main();
        Employee registerEmployee = driver.addEmployee(snc);
        Employee foundInRegisteredDirectory =
                driver.findEmployeeByID(registerEmployee.getId());
        snc.close();
        Assert.assertNotEquals(registerEmployee, null);
        Assert.assertNotEquals(foundInRegisteredDirectory, null);
    }
}
