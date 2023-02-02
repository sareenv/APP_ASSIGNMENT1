/*
*@Author: Dikshant Yadav
*Student ID: 40221623
*  
* @Author: Vinayak Sareen
* Student ID: 40186182
* */

package Tests;

import Main.Company;
import Models.Employee;
import org.junit.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ManageTests {
    private Company driver;

    @Before
    public void before() {
        driver = new Company();
    }

    @After
    public void after() {
        Company.objects = new ArrayList<>();
    }

    @Test
    public void addPermanentEmployee() {
        try {
            File file = new File("");
            String path = file.getAbsoluteFile().toString()
                    + "/src/Tests/AddPermanentEmployee.txt";
            file = new File(path);
            FileInputStream inputStream = new FileInputStream(file);
            Scanner snc = new Scanner(inputStream);
            Employee registerEmployee = driver.addEmployee(snc);
            Employee foundInRegisteredDirectory =
                    driver.findEmployeeByID(registerEmployee.getId());
            snc.close();
            inputStream.close();
            Assert.assertNotEquals(registerEmployee, null);
        } catch (Exception exception) {
            Assert.fail(exception.getMessage());
        }
    }


    @Test
    public void addTemporaryEmployee() {
        try {
            File file = new File("");
            String path = file.getAbsoluteFile().toString()
                    + "/src/Tests/AddTemporaryEmployee.txt";
            file = new File(path);
            FileInputStream inputStream = new FileInputStream(file);
            Scanner snc = new Scanner(inputStream);
            Employee registerEmployee = driver.addEmployee(snc);
            Employee foundInRegisteredDirectory =
                    driver.findEmployeeByID(registerEmployee.getId());
            snc.close();
            inputStream.close();
            Assert.assertNotEquals(registerEmployee, null);
        } catch (Exception exception) {
            Assert.fail(exception.getMessage());
        }
    }
}
