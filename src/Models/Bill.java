/*
* @Author: Dikshant Yadav
* Student ID: 40221623
*  
* @Author: Vinayak Sareen
* Student ID: 40186182
* */
package Models;
import java.text.SimpleDateFormat;
import java.util.*;

public class Bill {
    private String companyName;
    private double amount;
    private Date billDueDate;

    // default constructor.
    public Bill(String companyName, double amount,
                Date billDueDate) {
        this.companyName = companyName;
        this.amount = amount;
        this.billDueDate = billDueDate;
    }

    // Adding the bill of the employee on the basis of user input
    public static Bill addBill(Scanner snc) {
        System.out.println("Please enter the company name: ");
        String companyName = snc.next();
        System.out.println("Please enter the amount: Double Format");
        double amount = snc.nextDouble();
        System.out.println("Please enter the bill due date(MM/dd/yyyy)");
        String date = snc.next();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        
        Bill bill = null;
        try {
        	bill = new Bill(companyName,amount,dateFormat.parse(date));
        }catch(Exception ex) {
        	System.out.println("Invalid Date !!, Please enter date in (MM/dd/yyyy)");
        }
        //Returning the bill object after successful creation
        return bill;
    }
    
    
    // Overriding the toString method from Object class to customized printing of object properties.
    @Override
    public String toString() {
        return "Issued Bill cheque to " +
                "company=" + companyName +
                ", amount=" + amount +
                ", billDueDate=" + billDueDate;
    }
}
