package payRoll;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

interface Affiliation {
}
class NoAffiliation implements Affiliation{

}
class UnionAffiliation implements Affiliation{
    private double dues;
    private Set<ServiceCharge> serviceCharges = new HashSet<>();

    public UnionAffiliation(double dues) {
        this.dues = dues;
    }

    public void addServiceCharge(ServiceCharge serviceCharge){
        serviceCharges.add(serviceCharge);
    }

    public Set<ServiceCharge> getServiceCharges() {
        return serviceCharges;
    }
}