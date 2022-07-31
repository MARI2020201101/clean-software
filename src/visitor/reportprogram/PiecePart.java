package visitor.reportprogram;

class PiecePart implements Part{
    private String itsPartNumber;
    private String itsDescription;
    private double itsCost;

    public PiecePart(String itsPartNumber, String itsDescription, double itsCost) {
        this.itsPartNumber = itsPartNumber;
        this.itsDescription = itsDescription;
        this.itsCost = itsCost;
    }

    @Override
    public String getPartNumber() {
        return itsPartNumber;
    }

    @Override
    public String getDescription() {
        return itsDescription;
    }

    public double getItsCost() {
        return itsCost;
    }

    @Override
    public void accept(PartVisitor v) {
        v.visit(this);
    }
}
