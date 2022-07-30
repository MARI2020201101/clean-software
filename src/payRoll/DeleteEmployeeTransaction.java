package payRoll;

public class DeleteEmployeeTransaction implements Transaction{
    private int employID;

    public DeleteEmployeeTransaction(int employID) {
        this.employID = employID;
    }
    @Override
    public void execute() {
        PayrollDatabase.database().deleteEmployee(employID);
    }
}
