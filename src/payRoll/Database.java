package payRoll;

import java.util.HashMap;
import java.util.Map;

interface Database {
    Employee getEmployee(int employID);
    Employee getUnionEmployee(int employID);
    void addEmployee(int employID, Employee employ);
    void addUnionEmployee(int employID, Employee employ);
    void deleteEmployee(int employID);
    void deleteUnionEmployee(int employID);
    void clear();
}
class PayrollDatabase implements Database{
    private static PayrollDatabase singletonDatabase = new PayrollDatabase();
    private Map<Integer, Employee> employees = new HashMap<>();
    private Map<Integer, Employee> unionEmployees = new HashMap<>();

    public static Database database(){
        return singletonDatabase;
    }

    @Override
    public Employee getEmployee(int employID) {
        if(! employees.containsKey(employID)) return Employee.NULL;
        return employees.get(employID);
    }

    @Override
    public Employee getUnionEmployee(int employID) {
        if(! unionEmployees.containsKey(employID)) return Employee.NULL;
        return unionEmployees.get(employID);
    }

    @Override
    public void addEmployee(int employID, Employee employ) {
        employees.put(employID, employ);
    }

    @Override
    public void addUnionEmployee(int employID, Employee employ) {
        unionEmployees.put(employID, employ);
    }

    @Override
    public void deleteEmployee(int employID) {
        if(employees.containsValue(employID)) employees.remove(employID);
    }

    @Override
    public void deleteUnionEmployee(int employID) {
        if(unionEmployees.containsValue(employID)) unionEmployees.remove(employID);
    }

    @Override
    public void clear() {
        employees.clear();
        unionEmployees.clear();
    }
}
