package visitor.acyclic;

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
        HayesModemVisitor hayesModemVisitor = (HayesModemVisitor)v;
        hayesModemVisitor.visit(this);
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
        ZoomModemVisitor zoomModemVisitor = (ZoomModemVisitor)v;
        zoomModemVisitor.visit(this);
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
        ErnieModemVisitor ernieModemVisitor = (ErnieModemVisitor) v;
        ernieModemVisitor.visit(this);
    }
}