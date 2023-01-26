package Models;
import java.util.*;

public class Bill {
    private Company company;
    private double amount;
    private Date billDueDate;
    private Date billStartDate;
    private Date billEndDate;

    // default constructor.
    public Bill(Company company, double amount, Date billDueDate, Date billStartDate, Date billEndDate) {
        this.company = company;
        this.amount = amount;
        this.billDueDate = billDueDate;
        this.billStartDate = billStartDate;
        this.billEndDate = billEndDate;
    }
    // copy constructor.
    public Bill(Bill bill) {
        this.amount = bill.amount;
        this.company = new Company(bill.company.getCompanyName());
    }

    @Override
    public String toString() {
        return "Bill{" +
                "company=" + company +
                ", amount=" + amount +
                ", billDueDate=" + billDueDate +
                ", billStartDate=" + billStartDate +
                ", billEndDate=" + billEndDate +
                '}';
    }
}
