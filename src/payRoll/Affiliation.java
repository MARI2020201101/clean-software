package payRoll;

import java.util.ArrayList;
import java.util.List;

interface Affiliation {
}
class NoAffiliation implements Affiliation{

}
class UnionAffiliation implements Affiliation{
    private double dues;
    private List<ServiceCharge> serviceCharges = new ArrayList<>();
}