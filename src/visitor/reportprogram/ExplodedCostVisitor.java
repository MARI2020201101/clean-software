package visitor.reportprogram;

import java.util.HashMap;

class ExplodedCostVisitor implements PartVisitor{
    private double cost = 0;
    public double cost(){
        return cost;
    }
    @Override
    public void visit(Assembly assembly) {
    }

    @Override
    public void visit(PiecePart piecePart) {
        cost += piecePart.getItsCost();
    }
}
class PartCountVisitor implements PartVisitor{
    private int itsPieceCount = 0;
    private HashMap<String,Integer> itsPieceMap = new HashMap();
    @Override
    public void visit(Assembly assembly) {
    }
    @Override
    public void visit(PiecePart piecePart) {
        itsPieceCount++;
        String partNumber = piecePart.getPartNumber();
        int partNumberCount = 0;
        if(itsPieceMap.containsKey(partNumber)){
            partNumberCount = itsPieceMap.get(partNumber);
        }
        partNumberCount++;
        itsPieceMap.put(partNumber,partNumberCount);
    }

    public int getItsPieceCount() {
        return itsPieceCount;
    }
    public int getPartNumberCount(){
        return itsPieceMap.size();
    }
    public int getCountForPart(String partNumber){
        int partNumberCount = 0;
        if(itsPieceMap.containsKey(partNumber)){
            Integer carrier = itsPieceMap.get(partNumber);
            partNumberCount = carrier;
        }
        return partNumberCount;
    }
}
