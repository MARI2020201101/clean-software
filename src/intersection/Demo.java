package intersection;

import java.util.function.Function;

class Demo {
    public static void main(String[] args) {
        hello(s -> s);
        hello(s -> s);
    }

    private static void hello(Function<String,String> function) {
        System.out.println(function.apply("hello"));
    }
    private static <T extends Function>void helloV2(T function) {
        System.out.println(function.apply("hello"));
    }
}
