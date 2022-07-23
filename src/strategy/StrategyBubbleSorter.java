package strategy;

import java.util.ArrayList;
import java.util.List;

class StrategyMain{
    public static void main(String[] args) {
        StrategyBubbleSorter<List<Integer>> sorter = new StrategyBubbleSorter<>(new IntSortHandler());
        List<Integer> intList = new ArrayList();
        intList.add(2);
        intList.add(1);
        intList.add(0);
        intList.add(4);
        intList.add(3);
        sorter.sort(intList);
        int count = sorter.sort(intList);
        System.out.println("연산 횟수 : " + count);
    }
}
class StrategyBubbleSorter<T extends List> {
    private int operations = 0;
    private int length = 0;
    private SortHandler<T> sortHandler;

    public StrategyBubbleSorter(SortHandler<T> sortHandler){
        this.sortHandler = sortHandler;
    }

    public int sort(T items){
        sortHandler.setArray(items);
        length = sortHandler.length();

        for(int i = length-2 ; i >= 0 ; i--){
            for(int j = 0; j <= i ; j++){
                if(sortHandler.outOfOrder(j)){ //흐름주도는 얘가 하고. 전략(sort) 는 갈아끼운다. . .
                    sortHandler.swap(j); operations++;
                }
            }
        }
        sortHandler.print();
        return operations;
    }
}
