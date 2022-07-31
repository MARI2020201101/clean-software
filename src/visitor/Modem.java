package visitor;

interface Modem {
    void dial(String pno);
    void hangup();
    void send(char c);
    char recv();
    void accept(ModemVisitor v);
}
class HayesModem implements Modem{
    String configurationString = null;
    @Override
    public void dial(String pno) {
    }
    @Override
    public void hangup() {
    }

    @Override
    public void send(char c) {
    }
    @Override
    public char recv() {
        return 0;
    }
    @Override
    public void accept(ModemVisitor v) {
        v.visit(this);
    }
}
class ZoomModem implements Modem{
    int configurationValue = 0;
    @Override
    public void dial(String pno) {
    }
    @Override
    public void hangup() {
    }
    @Override
    public void send(char c) {
    }
    @Override
    public char recv() {
        return 0;
    }
    @Override
    public void accept(ModemVisitor v) {
        v.visit(this);
    }
}
class ErnieModem implements Modem{
    String internalPattern = null;
    @Override
    public void dial(String pno) {
    }
    @Override
    public void hangup() {
    }
    @Override
    public void send(char c) {
    }
    @Override
    public char recv() {
        return 0;
    }
    @Override
    public void accept(ModemVisitor v) {
        v.visit(this);
    }
}