package payRoll;

interface Transaction {
    void execute();
}
abstract class AddEmployeeTransaction implements Transaction{
    private int employID;
    private String employName;
    private String address;

    public AddEmployeeTransaction(int employID, String employName, String address) {
        this.employID = employID;
        this.employName = employName;
        this.address = address;
    }

    @Override
    public final void execute() {
        Employee employee = new Employee(employID,employName,address);
        employee.setClassification(getPaymentClassification());
        employee.setSchedule(getPaymentSchedule());
        employee.setMethod(getPaymentMethod());
        PayrollDatabase.database().addEmployee(employee.getEmployId(), employee);
    }

    protected abstract PaymentSchedule getPaymentSchedule();
    protected abstract PaymentClassification getPaymentClassification();
    protected abstract PaymentMethod getPaymentMethod();
}
class AddHourlyEmployeeTransaction extends AddEmployeeTransaction{
    private final double hourlyPayment;

    public AddHourlyEmployeeTransaction(int employID, String employName, String address, double hourlyPayment) {
        super(employID,employName,address);
        this.hourlyPayment = hourlyPayment;
    }

    @Override
    protected PaymentSchedule getPaymentSchedule() {
        return new WeeklySchedule();
    }

    @Override
    protected HourlyClassification getPaymentClassification() {
        return new HourlyClassification(hourlyPayment);
    }
    @Override
    protected PaymentMethod getPaymentMethod() {
        return new HoldMethod();
    }
}
class AddSalariedEmployeeTransaction extends AddEmployeeTransaction{
    private final double salary;

    public AddSalariedEmployeeTransaction(int employID, String employName, String address, double salary) {
        super(employID,employName,address);
        this.salary = salary;
    }

    @Override
    protected PaymentSchedule getPaymentSchedule() {
        return new MonthlySchedule();
    }

    @Override
    protected SalariedClassification getPaymentClassification() {
        return new SalariedClassification(salary);
    }

    @Override
    protected PaymentMethod getPaymentMethod() {
        return new HoldMethod();
    }
}
class AddCommissionedEmployeeTransaction extends AddEmployeeTransaction{
    private final double salary;
    private final double commissionRate;

    public AddCommissionedEmployeeTransaction(int employID, String employName, String address, double salary, double commissionRate) {
        super(employID,employName,address);
        this.salary = salary;
        this.commissionRate = commissionRate;
    }

    @Override
    protected PaymentSchedule getPaymentSchedule() {
        return new BiWeeklySchedule();
    }

    @Override
    protected CommissionedClassification getPaymentClassification() {
        return new CommissionedClassification(salary, commissionRate);
    }

    @Override
    protected PaymentMethod getPaymentMethod() {
        return new HoldMethod();
    }
}