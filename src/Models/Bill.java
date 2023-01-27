/*
 * @Author: Vinayak Sareen
 * Student ID: 40186182
 * */
package Models;
import java.util.*;

public class Bill {
    private String companyName;
    private double amount;
    private Date billDueDate;
    private Date billStartDate;
    private Date billEndDate;

    // default constructor.
    public Bill(String companyName, double amount,
                Date billDueDate, Date billStartDate,
                Date billEndDate) {
        this.companyName = companyName;
        this.amount = amount;
        this.billDueDate = billDueDate;
        this.billStartDate = billStartDate;
        this.billEndDate = billEndDate;
    }

    public static Bill addBill(Scanner snc) {
        System.out.println("Please enter the company name: ");
        String companyName = snc.next();
        System.out.println("Please enter the amount: Double Format");
        double amount = snc.nextDouble();
        System.out.println("Please enter the bill start date");
        return null;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "company=" + companyName +
                ", amount=" + amount +
                ", billDueDate=" + billDueDate +
                ", billStartDate=" + billStartDate +
                ", billEndDate=" + billEndDate +
                '}';
    }
}
