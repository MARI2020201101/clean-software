package visitor.reportprogram;

interface Part {
    String getPartNumber();
    String getDescription();
    void accept(PartVisitor v);
}
