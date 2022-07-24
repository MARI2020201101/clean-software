package payRoll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface PaymentClassification {
}
class SalariedClassification implements PaymentClassification{
    private double salary;

    public SalariedClassification(double salary) {
        this.salary = salary;
    }
}
class HourlyClassification implements PaymentClassification{
    private double hourlyRate;
    private List<TimeCard> timeCards = new ArrayList<>();

    public HourlyClassification(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    public void addTimeCard(TimeCard timeCard){
        timeCards.add(timeCard);
    }

}
class CommissionedClassification implements PaymentClassification{
    private double salary;
    private double commissionRate;
    private List<SalesReceipt> salesReceipts = new ArrayList<>();

    public CommissionedClassification(double salary, double commissionRate) {
        this.salary = salary;
        this.commissionRate = commissionRate;
    }
    public void addSalesReceipt(SalesReceipt salesReceipt){
        salesReceipts.add(salesReceipt);
    }
}