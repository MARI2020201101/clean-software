package templatemethod;

import java.util.Arrays;

class BubbleSorter {
     static int operations = 0;

    public static void main(String[] args) {
        int[] array = new int[]{9, 4, 3, 2, 1, 0, 3, 2, 4, 8};
        int operation = sort(array);
        System.out.println("연산횟수 : " + operation);
        System.out.println(Arrays.toString(array));
    }
     public static int sort(int[] array){
         for(int i = array.length-2 ; i >= 0 ; i--){
             for(int j = 0; j <= i ; j++){
                 compareAndSwap(array, j);
             }
         }
         return operations;
     }

    private static void compareAndSwap(int[] array, int index) {
        if(array[index] > array[index+1] ){
            swap(array,index);
            operations++;
        }
    }
    private static void swap(int[] array, int index) {
        int temp = array[index];
        array[index] = array[index+1];
        array[index+1] = temp;
    }

}
