package templatemethod;

import java.util.Arrays;

class Main{
    public static void main(String[] args) {
        int[] array = new int[]{9, 4, 3, 2, 1, 0, 3, 2, 4, 8};
        IntBubbleSorter sorter = new IntBubbleSorter(array);
        sorter.doSort();
        System.out.println("연산횟수 : " + sorter.getOperations());
        System.out.println(Arrays.toString(array));
    }
}

abstract class TemplateMethodBubbleSorter {
    private int operations = 0;
    private int length = 0;

    public TemplateMethodBubbleSorter(int length) {
        this.length = length;
    }

    protected int doSort(){
        for(int i = length-2 ; i >= 0 ; i--){
            for(int j = 0; j <= i ; j++){
                if(outOfOrder(j)){
                    swap(j); operations++;
                }
            }
        }
        return operations;
    }

    public int getOperations() {
        return operations;
    }

    protected abstract void swap(int index);
    protected abstract boolean outOfOrder(int index);
}
class IntBubbleSorter extends TemplateMethodBubbleSorter{

    private int[] array;

    public IntBubbleSorter(int[] array) {
        super(array.length);
        this.array = array;
    }

    @Override
    protected void swap(int index) {
        int temp = array[index];
        array[index] = array[index+1];
        array[index+1] = temp;
    }

    @Override
    protected boolean outOfOrder(int index) {
        return array[index] > array[index+1];
    }
}
