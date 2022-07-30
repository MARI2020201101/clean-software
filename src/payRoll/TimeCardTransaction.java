package payRoll;

import java.time.LocalDateTime;

public class TimeCardTransaction implements Transaction{
    private int employID;
    private LocalDateTime date;
    private double hours;

    public TimeCardTransaction(int employID, LocalDateTime date, double hours) {
        this.employID = employID;
        this.date = date;
        this.hours = hours;
    }

    @Override
    public void execute() {
        Employee employee = PayrollDatabase.database().getEmployee(employID);
        PaymentClassification classification = employee.getClassification();
        if(classification instanceof HourlyClassification){
            HourlyClassification hourlyClassification = (HourlyClassification) classification;
            hourlyClassification.addTimeCard(new TimeCard(employID, date, hours));
        }else{
            throw new IllegalArgumentException("Tried to add time card to non-hourly employee");
        }
    }
}
