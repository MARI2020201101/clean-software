package payRoll;

public class Employee {

    public static Employee NULL = new Employee(-1,null,null);
    private int employId;
    private String name;
    private String address;
    private PaymentSchedule paymentSchedule;
    private PaymentClassification paymentClassification;
    private PaymentMethod paymentMethod;

    public Employee(int employId, String name, String address) {
        this.employId = employId;
        this.name = name;
        this.address = address;
    }

    public int getEmployId() {
        return employId;
    }

    public void setSchedule(PaymentSchedule paymentSchedule) {
        this.paymentSchedule = paymentSchedule;
    }

    public void setClassification(PaymentClassification paymentClassification) {
        this.paymentClassification = paymentClassification;
    }

    public void setMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentSchedule getSchedule() {
        return paymentSchedule;
    }

    public PaymentClassification getClassification() {
        return paymentClassification;
    }

    public PaymentMethod getMethod() {
        return paymentMethod;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employId=" + employId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", paymentSchedule=" + paymentSchedule +
                ", paymentClassification=" + paymentClassification +
                ", paymentMethod=" + paymentMethod +
                '}';
    }
}
