package visitor.extensionobject;




interface PartExtension {
}
interface XMLPartExtension extends PartExtension{
    Object getXMLElement();
}

class BadPartExtension implements PartExtension{
}


class CSVPiecePartExtension implements PartExtension{

    public CSVPiecePartExtension(Part part) {

    }
}
class XMLPiecePartExtension implements XMLPartExtension{

    public XMLPiecePartExtension(Part part) {


    }

    @Override
    public Object getXMLElement() {
        return null;
    }
}