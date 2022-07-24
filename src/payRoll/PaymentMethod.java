package payRoll;

public interface PaymentMethod {
}
class HoldMethod implements PaymentMethod{
}
class DirectMethod implements PaymentMethod{
    private String bank;
    private String account;

    public DirectMethod(String bank, String account) {
        this.bank = bank;
        this.account = account;
    }
}
class MailMethod implements PaymentMethod{
    private String address;

    public MailMethod(String address) {
        this.address = address;
    }
}