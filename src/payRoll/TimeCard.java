package payRoll;

import java.time.LocalDateTime;

public class TimeCard {
    private int employeeID;
    private LocalDateTime date;
    private int workedHour;

    public TimeCard(int employeeID, LocalDateTime date) {
        this.employeeID = employeeID;
        this.date = date;
    }
    public boolean overWorked(){
        return workedHour >= 8;
    }
}
