package payRoll;

class Demo {
    public static void main(String[] args) {
        int employID = 1;
        AddEmployeeTransaction addEmployeeTransaction
                = new AddHourlyEmployeeTransaction(employID, "Bob","London", 100.00);
        addEmployeeTransaction.execute();

    }
}
