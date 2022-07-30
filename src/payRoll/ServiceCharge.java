package payRoll;

import java.time.LocalDateTime;

public class ServiceCharge {
    private int employeeID;
    private LocalDateTime date;

    public ServiceCharge(int employeeID, LocalDateTime date) {
        this.employeeID = employeeID;
        this.date = date;
    }
}
