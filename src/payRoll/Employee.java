package payRoll;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Employee {

    public static Employee NULL = new NullEmployee(-1,null,null);
    private int employId;
    private String name;
    private String address;
    private PaymentSchedule paymentSchedule;
    private PaymentClassification paymentClassification;
    private PaymentMethod paymentMethod;
    private Set<Affiliation> affiliations = new HashSet<>();

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
    public void setAffiliation(UnionAffiliation affiliation) {
        affiliations.add(affiliation);
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

    public Set<Affiliation> getAffiliations() {
        return Collections.unmodifiableSet(affiliations);
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



    private static class NullEmployee extends Employee{
        private NullEmployee(int employId, String name, String address) {
            super(employId, name, address);
        }

        @Override
        public final int getEmployId() {
            throw new IllegalArgumentException("No such Employee");
        }

        @Override
        public final void setSchedule(PaymentSchedule paymentSchedule) {
            throw new IllegalArgumentException("No such Employee");
        }

        @Override
        public final void setClassification(PaymentClassification paymentClassification) {
            throw new IllegalArgumentException("No such Employee");
        }

        @Override
        public final void setMethod(PaymentMethod paymentMethod) {
            throw new IllegalArgumentException("No such Employee");
        }

        @Override
        public final PaymentSchedule getSchedule() {
            throw new IllegalArgumentException("No such Employee");
        }

        @Override
        public final PaymentClassification getClassification() {
            throw new IllegalArgumentException("No such Employee");
        }

        @Override
        public final PaymentMethod getMethod() {
            throw new IllegalArgumentException("No such Employee");
        }
    }
}
