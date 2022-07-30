package payRoll;

import java.time.LocalDateTime;

public class SalesReceiptTransaction implements Transaction {
    private int employeeID;
    private double amount;
    private LocalDateTime date;

    public SalesReceiptTransaction(int employeeID, LocalDateTime date, double amount) {
        this.employeeID = employeeID;
        this.amount = amount;
        this.date = date;
    }

    @Override
    public void execute() {
        Employee employee = PayrollDatabase.database().getEmployee(employeeID);
        PaymentClassification classification = employee.getClassification();
        if(classification instanceof CommissionedClassification){
            CommissionedClassification commissionedClassification = (CommissionedClassification) classification;
            commissionedClassification.addSalesReceipt(new SalesReceipt(employeeID, date, amount));
        }else{
            throw new IllegalArgumentException("No commissioned employee");
        }
    }
}
