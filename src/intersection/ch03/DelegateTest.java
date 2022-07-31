package intersection.ch03;

import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;

class DelegateTest {
    public static void main(String[] args) {
        Pair<String> name = new Name("Park", "ChunBae");
        run((ForwardingPair<String> & Convertable<String> & Printable<String>)
                ()-> name
                , o->{
                        o.convert(s-> "****\n"+s+"\n****");
                        o.print();
                        o.convert(s->s.toUpperCase(Locale.ROOT));
                        o.print();
                });
//        print(name);
    }

    private static <T> void print(Pair<T> t){
        System.out.println(t.getFirst());
        System.out.println(t.getSecond());
    }
    private static <T extends DelegateTo<S> , S> void run(T t, Consumer<T> consumer) {
        consumer.accept(t);
    }
}
interface Printable<T> extends DelegateTo<Pair<T>> {
    default void print(){
        System.out.println(delegate().getFirst());
        System.out.println(delegate().getSecond());
    }
}
interface Convertable<T> extends DelegateTo<Pair<T>> {
    default void convert(Function<T,T> mapper){
        Pair<T> pair = delegate();
        pair.setFirst(mapper.apply(pair.getFirst()));
        pair.setSecond(mapper.apply(pair.getSecond()));
    }
}
interface ForwardingPair<T> extends DelegateTo<Pair<T>>, Pair<T>{
    default T getFirst() {
        return delegate().getFirst();
    }
    default T getSecond(){
        return delegate().getSecond();
    }
    default void setFirst(T first) {
        delegate().setFirst(first);
    }
    default void setSecond(T second) {
        delegate().setSecond(second);
    }
}
class Name implements Pair<String>{
    private String firstName;
    private String secondName;

    public Name(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    @Override
    public String getFirst() {
        return firstName;
    }

    @Override
    public String getSecond() {
        return secondName;
    }

    @Override
    public void setFirst(String first) {
        this.firstName = first;
    }

    @Override
    public void setSecond(String second) {
        this.secondName = second;
    }
}
interface Pair<T>{
    T getFirst();
    T getSecond();
    void setFirst(T first);
    void setSecond(T second);
}
interface DelegateTo<T>{
    T delegate();
}