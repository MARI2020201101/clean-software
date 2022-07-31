package visitor;

interface ModemVisitor {
    void visit(HayesModem modem);
    void visit(ZoomModem modem);
    void visit(ErnieModem modem);
}
class UnixModemConfigurator implements ModemVisitor{
    @Override
    public void visit(HayesModem modem) {
        modem.configurationString = "Hello world";
    }
    @Override
    public void visit(ZoomModem modem) {
        modem.configurationValue = 12345;
    }
    @Override
    public void visit(ErnieModem modem) {
        modem.internalPattern = "Hello kitty";
    }
}
