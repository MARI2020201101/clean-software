package payRoll;

interface Employee {
    int getEmployId();
    void setSchedule(PaymentSchedule paymentSchedule);
    void setClassification(PaymentClassification paymentClassification);
    void setMethod(PaymentMethod paymentMethod);
    PaymentSchedule getSchedule();
    PaymentClassification getClassification();
    PaymentMethod getMethod();
}
class HourlyEmployee implements Employee{
    private int employId;
    private String name;
    private String address;
    private double hourlyPayment;
    private PaymentSchedule paymentSchedule;
    private PaymentClassification paymentClassification;
    private PaymentMethod paymentMethod;

    public HourlyEmployee(int employId, String name, String address, double hourlyPayment) {
        this.employId = employId;
        this.name = name;
        this.address = address;
        this.hourlyPayment = hourlyPayment;
    }

    @Override
    public int getEmployId() {
        return employId;
    }

    @Override
    public void setSchedule(PaymentSchedule paymentSchedule) {
        this.paymentSchedule = paymentSchedule;
    }

    @Override
    public void setClassification(PaymentClassification paymentClassification) {
        this.paymentClassification = paymentClassification;
    }

    @Override
    public void setMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public PaymentSchedule getSchedule() {
        return paymentSchedule;
    }

    @Override
    public PaymentClassification getClassification() {
        return paymentClassification;
    }

    @Override
    public PaymentMethod getMethod() {
        return paymentMethod;
    }
}
class SalariedEmployee implements Employee{
    private int employId;
    private String name;
    private String address;
    private PaymentSchedule paymentSchedule;
    private PaymentClassification paymentClassification;
    private PaymentMethod paymentMethod;

    @Override
    public int getEmployId() {
        return employId;
    }

    @Override
    public void setSchedule(PaymentSchedule paymentSchedule) {
        this.paymentSchedule = paymentSchedule;
    }

    @Override
    public void setClassification(PaymentClassification paymentClassification) {
        this.paymentClassification = paymentClassification;
    }

    @Override
    public void setMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public PaymentSchedule getSchedule() {
        return paymentSchedule;
    }

    @Override
    public PaymentClassification getClassification() {
        return paymentClassification;
    }

    @Override
    public PaymentMethod getMethod() {
        return paymentMethod;
    }
}
class CommissionedEmployee implements Employee{
    private int employId;
    private String name;
    private String address;
    private PaymentSchedule paymentSchedule;
    private PaymentClassification paymentClassification;
    private PaymentMethod paymentMethod;

    @Override
    public int getEmployId() {
        return employId;
    }

    @Override
    public void setSchedule(PaymentSchedule paymentSchedule) {
        this.paymentSchedule = paymentSchedule;
    }

    @Override
    public void setClassification(PaymentClassification paymentClassification) {
        this.paymentClassification = paymentClassification;
    }

    @Override
    public void setMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public PaymentSchedule getSchedule() {
        return paymentSchedule;
    }

    @Override
    public PaymentClassification getClassification() {
        return paymentClassification;
    }

    @Override
    public PaymentMethod getMethod() {
        return paymentMethod;
    }
}