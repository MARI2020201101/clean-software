package payRoll;

import java.time.LocalDateTime;
import java.util.Set;

public class ServiceChargeTransaction implements Transaction{
    private int employeeID;
    private LocalDateTime date;
    private double amount;

    public ServiceChargeTransaction(int employeeID, LocalDateTime date, double amount) {
        this.employeeID = employeeID;
        this.date = date;
        this.amount = amount;
    }

    @Override
    public void execute() {
        Employee unionEmployee = PayrollDatabase.database().getUnionEmployee(employeeID);
        Set<Affiliation> affiliations = unionEmployee.getAffiliations();

    }
}
