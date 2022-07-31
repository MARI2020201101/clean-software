package visitor.reportprogram;

interface PartVisitor {
    void visit(Assembly assembly);
    void visit(PiecePart piecePart);
}
