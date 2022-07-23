package payRoll;

interface Transaction {
    boolean validate();
    void execute();
}
abstract class AddEmployeeTransaction implements Transaction{
    private String employName;
    private String address;

    @Override
    public boolean validate() {
        if(employName.isEmpty() || address.isEmpty()) return false;
        else return true;
    }

}
class AddHourlyEmployeeTransaction extends AddEmployeeTransaction{
    private double hourlyPayment;
    private int employID;
    private String employName;
    private String address;
    private Database database;

    public AddHourlyEmployeeTransaction(int employID, String employName, String address, double hourlyPayment) {
        this.hourlyPayment = hourlyPayment;
        this.employID = employID;
        this.employName = employName;
        this.address = address;
        this.database = new PayrollDatabase();
    }


    @Override
    public void execute() {
        if(validate()){
            database.addEmployee(employID, new HourlyEmployee(employID,employName,address,hourlyPayment));
        }
    }
}