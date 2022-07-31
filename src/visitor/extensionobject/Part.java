package visitor.extensionobject;

import java.util.HashMap;
import java.util.Map;

abstract class Part {
    Map<String, PartExtension> itsExtensions =  new HashMap<>();
    public abstract String getPartNumber();
    public abstract String getDescription();

    public void addExtension(String exType, PartExtension extension){
        itsExtensions.put(exType, extension);
    }
    public PartExtension getExtension(String exType){
        if(itsExtensions.containsKey(exType))
            return itsExtensions.get(exType);
        else return new BadPartExtension();
    }
}
