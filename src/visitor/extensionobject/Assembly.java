package visitor.extensionobject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Assembly extends Part{
    private List<Part> itsParts = new ArrayList<>();
    private String partNumber;
    private String description;

    public Assembly(String partNumber, String description) {
        this.partNumber = partNumber;
        this.description = description;
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
    public Iterator<Part> getParts(){
        return itsParts.iterator();
    }
}
