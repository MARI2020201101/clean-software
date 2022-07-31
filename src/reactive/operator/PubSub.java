package reactive.operator;

import java.util.concurrent.Flow;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class PubSub {
    public static void main(String[] args) {
        Flow.Publisher<Integer> publisher = iterPub(Stream.iterate(1, a->a+1).limit(10).collect(Collectors.toList()));
        Flow.Publisher<Integer> mapPublisher = mapPub(publisher, s->s*10);
        Flow.Publisher<Integer> mapPublisher2 = mapPub(mapPublisher, s-> -s);
        mapPublisher2.subscribe(logSub());
    }

    //publisher 이자 subscriber 로서 중개하는 역할을 한다.
    private static Flow.Publisher<Integer> mapPub(Flow.Publisher<Integer> source, Function<Integer,Integer> function){
        return new DelegateSub(source,function);
    }

    private static Flow.Subscriber<Integer> logSub() {
        Flow.Subscriber<Integer> subscriber = new Flow.Subscriber<>() {
            private Flow.Subscription subscription;
            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription;
                System.out.println("onSubscribe");
                subscription.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer item) {
                System.out.println("item :: "+item);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError :: "+throwable.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };
        return subscriber;
    }

    private static Flow.Publisher<Integer> iterPub(Iterable<Integer> iter) {
        return new Flow.Publisher<Integer>() {
            @Override
            public void subscribe(Flow.Subscriber<? super Integer> subscriber) {
                subscriber.onSubscribe(new Flow.Subscription() {
                    @Override
                    public void request(long n) {
                        try{
                            iter.forEach(subscriber::onNext);
                            subscriber.onComplete();
                        }catch (Exception e){
                            subscriber.onError(e);
                        }
                    }
                    @Override
                    public void cancel() {
                    }
                });
            }
        };
    }
}

