package payRoll;

import java.time.LocalDateTime;

public class TimeCard {
    private int employeeID;
    private LocalDateTime date;
    private double hours;

    public TimeCard(int employeeID, LocalDateTime date, double hours) {
        this.employeeID = employeeID;
        this.date = date;
        this.hours = hours;
    }
    public LocalDateTime getDate() {
        return date;
    }

    public double getHours() {
        return hours;
    }
    public boolean overWorked(){
        return hours >= 8;
    }

    @Override
    public String toString() {
        return "TimeCard{" +
                "employeeID=" + employeeID +
                ", date=" + date +
                ", hours=" + hours +
                '}';
    }
}
