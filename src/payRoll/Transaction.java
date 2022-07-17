package payRoll;

interface Transaction {
    void execute();
}
abstract class AddEmployeeTransaction implements Transaction{
    private Database database = new PayrollDatabase();
    abstract protected Employee createEmployee();
    abstract protected int getEmployId();
    @Override
    public void execute() {
        database.addEmployee(getEmployId(), createEmployee());
    }
}
class AddHourlyEmployeeTransaction extends AddEmployeeTransaction{
    private double hourlyPayment;
    private int employID;
    private String employName;
    private String address;

    public AddHourlyEmployeeTransaction(int employID, String employName, String address, double hourlyPayment) {
        this.hourlyPayment = hourlyPayment;
        this.employID = employID;
        this.employName = employName;
        this.address = address;
    }

    @Override
    protected Employee createEmployee() {
        return new HourlyEmployee(employID, employName, address, hourlyPayment);
    }

    @Override
    protected int getEmployId() {
        return employID;
    }
}