package payRoll;

import java.util.HashMap;
import java.util.Map;

interface Database {
    Employee getEmployee(int employID);
    void addEmployee(int employID, Employee employ);
    void clear();
}
class PayrollDatabase implements Database{
    private Map<Integer, Employee> employees = new HashMap<>();

    @Override
    public Employee getEmployee(int employID) {
        return employees.get(employID);
    }
    @Override
    public void addEmployee(int employID, Employee employ) {
        employees.put(employID, employ);
    }
    @Override
    public void clear() {
        employees.clear();
    }
}
