package payRoll;

class Demo {
    public static void main(String[] args) {
        int employID = 1;
        AddHourlyEmployeeTransaction transaction = new AddHourlyEmployeeTransaction(employID, "Bob", "London", 1000.00);
        transaction.execute();
        Employee employee = PayrollDatabase.database().getEmployee(1);
        System.out.println(employee);
    }
}
