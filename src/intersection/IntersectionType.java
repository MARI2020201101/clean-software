package intersection;

import java.util.function.Consumer;
import java.util.function.Function;

class IntersectionType {
    public static void main(String[] args) {
//       hello((Function & Hello & Hi) s->s);
       run(( Function & Hello & Hi & Printer) s->s
               , o-> {
                        o.hello();
                        o.hi();
                        o.print("Lambda");
               });
    }
    static <T extends Function & Hello & Hi> void hello(T function){
        function.hello();
        function.hi();
    }
    static <T extends Function & Hello & Hi & Printer> void run(T t, Consumer<T> consumer){
        consumer.accept(t);
    }
}

interface Hello{
    default void hello(){
        System.out.println("hello");
    }
}
interface Hi{
    default void hi(){
        System.out.println("hi");
    }
}
interface Printer{
    default void print(String str){
        System.out.println(str);
    }
}