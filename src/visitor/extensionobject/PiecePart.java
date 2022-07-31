package visitor.extensionobject;

public class PiecePart extends Part{
    private String partNumber;
    private String description;
    private int cost;

    public PiecePart(String partNumber, String description, int cost) {
        this.partNumber = partNumber;
        this.description = description;
        this.cost = cost;
        addExtension("CSV", new CSVPiecePartExtension(this));
        addExtension("XML", new XMLPiecePartExtension(this));
    }

    @Override
    public String getPartNumber() {
        return partNumber;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public int getCost() {
        return cost;
    }
}
