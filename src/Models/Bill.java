/*
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
        	//System.out.println("Hello " + bill.toString());
        }catch(Exception ex) {
        	System.out.println("Invalid Date !! ");
        	//02 Jan 2018
        }
        return bill;
    }
    

    @Override
    public String toString() {
        return "Issued Bill cheque to " +
                "company=" + companyName +
                ", amount=" + amount +
                ", billDueDate=" + billDueDate;
    }
}
