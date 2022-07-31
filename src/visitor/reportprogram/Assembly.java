package visitor.reportprogram;

import java.util.LinkedList;
import java.util.List;

class Assembly implements Part{
 private List<Part> itsParts = new LinkedList<>();
 private String itsPartNumber;
 private String itsDescription;

 public Assembly(String itsPartNumber, String itsDescription) {
  this.itsPartNumber = itsPartNumber;
  this.itsDescription = itsDescription;
 }

 public List<Part> getParts() {
  return itsParts;
 }

 @Override
 public String getPartNumber() {
  return itsPartNumber;
 }

 @Override
 public String getDescription() {
  return itsDescription;
 }

 public void add(Part part){
  itsParts.add(part);
 }
 @Override
 public void accept(PartVisitor v) {
    v.visit(this);
    for(Part part:itsParts){
     part.accept(v);
    }
 }
}
