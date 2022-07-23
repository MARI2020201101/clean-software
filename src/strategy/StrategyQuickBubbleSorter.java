package strategy;

import java.util.ArrayList;
import java.util.List;

class StrategyQuickMain{
    public static void main(String[] args) {
        StrategyQuickBubbleSorter<List<Integer>> sorter = new StrategyQuickBubbleSorter<>(new IntSortHandler());
        List<Integer> intList = new ArrayList();
        intList.add(2);
        intList.add(1);
        intList.add(0);
        intList.add(4);
        intList.add(3);
        int count = sorter.sort(intList);
        System.out.println("연산 횟수 : " + count);
    }
}

class StrategyQuickBubbleSorter<T extends List> {
    private int operations = 0;
    private int length = 0;
    private SortHandler<T> sortHandler;

    public StrategyQuickBubbleSorter(SortHandler<T> sortHandler){
        this.sortHandler = sortHandler;
    }

    public int sort(T items){
        sortHandler.setArray(items);
        length = sortHandler.length();

        boolean isSwapped = true;
        for(int i = length-2 ;i >= 0 && isSwapped; i--){
            for(int j = 0; j <= i; j++){
                isSwapped = false;
                if(sortHandler.outOfOrder(j)){
                    sortHandler.swap(j);
                    operations++;
                    isSwapped = true;
                }
            }
        }
        sortHandler.print();
        return operations;
    }
}
