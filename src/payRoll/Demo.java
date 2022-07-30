package payRoll;

import java.time.LocalDateTime;

class Demo {
    public static void main(String[] args) {
        int employID = 1;
        AddHourlyEmployeeTransaction transaction = new AddHourlyEmployeeTransaction(
                employID
                , "Bob"
                , "London"
                , 1000.00);
        transaction.execute();
        Employee employee = PayrollDatabase.database().getEmployee(employID);
        System.out.println(employee);

        TimeCardTransaction timeCardTransaction = new TimeCardTransaction(
                employID
                , LocalDateTime.of(2022, 7, 22, 18, 0, 0)
                , 8);
        timeCardTransaction.execute();
        Employee hourlyEmployee = PayrollDatabase.database().getEmployee(employID);
        System.out.println(hourlyEmployee.getClassification());

        int employID2 = 2;
        AddHourlyEmployeeTransaction transaction2 = new AddHourlyEmployeeTransaction(
                employID2
                , "Tom"
                , "New York"
                , 1500.00);
        transaction2.execute();
        Employee unionEmployee = PayrollDatabase.database().getEmployee(employID2);
        UnionAffiliation affiliation = new UnionAffiliation(12.5);
        unionEmployee.setAffiliation(affiliation);
        PayrollDatabase.database().addUnionEmployee(employID2,unionEmployee);
        ServiceChargeTransaction serviceChargeTransaction = new ServiceChargeTransaction(
                employID2
                , LocalDateTime.of(2022, 7, 25, 18, 0, 0)
                , 12.95);

        serviceChargeTransaction.execute();
    }
}
