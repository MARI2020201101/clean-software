package intersection.ch02;

import java.util.function.Consumer;

class DelegateTest {
    public static void main(String[] args) {
        run((DelegateTo<String> & Hello)()->"HongGilDong" ,
                o -> {
                    o.delegate();
                    o.hello();
        });
    }

    private static <T extends DelegateTo<S> , S> void run(T t, Consumer<T> consumer) {
        consumer.accept(t);//콜백
    }
}
interface DelegateTo<T>{
    T delegate();
}
interface Hello extends DelegateTo<String>{
    default void hello(){
        String delegate = delegate();
        System.out.println("hello " + delegate);
    }
}