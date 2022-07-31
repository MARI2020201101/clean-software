package visitor.acyclic;

interface ModemVisitor {
}
interface ErnieModemVisitor {
    void visit(ErnieModem modem);
}
interface HayesModemVisitor {
    void visit(HayesModem modem);
}
interface ZoomModemVisitor {
    void visit(ZoomModem modem);
}
class UnixModemConfigurator implements ModemVisitor, ErnieModemVisitor,HayesModemVisitor,ZoomModemVisitor{
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
