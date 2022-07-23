package strategy;

import java.util.Arrays;
import java.util.List;

interface SortHandler<T> {
    void swap(int index);
    boolean outOfOrder(int index);
    void setArray(T array);
    int length();
    void print();
}
class IntSortHandler implements SortHandler<List<Integer>> {

    private int[] array;

    @Override
    public void swap(int index) {
        int temp = array[index];
        array[index] = array[index+1];
        array[index+1] = temp;
    }

    @Override
    public boolean outOfOrder(int index) {
        return array[index] > array[index+1];
    }

    @Override
    public void setArray(List<Integer> array) {
        this.array = new int[array.size()];
        int index = 0;
        for(int i : array){
            this.array[index++] = i;
        }
    }


    @Override
    public int length() {
        return array.length;
    }

    @Override
    public void print() {
        System.out.println(Arrays.toString(array));
    }
}