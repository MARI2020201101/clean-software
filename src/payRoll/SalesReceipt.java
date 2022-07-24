package payRoll;

import java.time.LocalDateTime;

public class SalesReceipt {
    private int employeeID;
    private LocalDateTime date;
    private double amount;

    public SalesReceipt(int employeeID, LocalDateTime date, double amount) {
        this.employeeID = employeeID;
        this.date = date;
        this.amount = amount;
    }
}
