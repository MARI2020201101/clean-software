package payRoll;

public class DeleteEmployeeTransaction implements Transaction{
    private int employID;

    public DeleteEmployeeTransaction(int employID) {
        this.employID = employID;
    }

    @Override
    public boolean validate() {
        return PayrollDatabase.database().getEmployee(employID) != Employee.NULL;
    }

    @Override
    public void execute() {
        PayrollDatabase.database().deleteEmployee(employID);
    }
}
