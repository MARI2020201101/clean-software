package generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GenericTest {
    public static void main(String[] args) {
        MyGenericClass<List<Integer>> myGenericClass = new MyGenericClass<>();
        myGenericClass.setArrayList(Arrays.asList(1,2,3));
        myGenericClass.printArrayList();
        MyGenericArray<String> myGenericArray = new MyGenericArray<>();
        myGenericArray.setArrays(List.of("가","나","다"));
        myGenericArray.printArrays();
    }
}
@SuppressWarnings("ALL")
class MyGenericClass<T extends List>{
    List<T> arrayList = new ArrayList<>();
    T[] arrays;
    public void setArrayList(T array){
        arrayList.addAll(array);
    }
    public void setArrays(T array){
        arrays =(T[]) array.toArray();
    }
    public void printArrayList(){
        for (Object item: arrayList) {
            System.out.println(item);
        }
    }
    public void printArrays(){
        System.out.println(Arrays.toString(arrays));
    }
}
class MyGenericArray<T> {
    T[] arrays;

    @SuppressWarnings("ALL")
    public void setArrays(List<T> array){
//        arrays = (T[]) new Object[array.size()];
//        int index = 0;
//        for(T item: array ){
//            arrays[index++] = item;
//        }
        arrays = (T[]) array.toArray();

    }
    public void printArrays(){
        System.out.println(Arrays.toString(arrays));
    }
}
