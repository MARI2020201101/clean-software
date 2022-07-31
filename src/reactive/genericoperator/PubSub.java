package reactive.genericoperator;

import java.util.concurrent.Flow;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class PubSub {
    public static void main(String[] args) {
        Flow.Publisher<Integer> publisher = iterPub(Stream.iterate(1, a->a+1).limit(10).collect(Collectors.toList()));
        Flow.Publisher<Integer> mapPublisher = mapPub(publisher, s->s*10);
//        Flow.Publisher<Integer> mapPublisher2 = sumPub(mapPublisher);
//        Flow.Publisher<Integer> mapPublisher3 = reducePub(publisher,0,(a,b)->a+b);
        mapPublisher.subscribe(logSub());

    }

//    private static Flow.Publisher<Integer> reducePub(Flow.Publisher<Integer> source, int init, BiFunction<Integer,Integer,Integer> bf) {
//
//        return new Flow.Publisher<Integer>() {
//            @Override
//            public void subscribe(Flow.Subscriber<? super Integer> subscriber) {
//                source.subscribe(new DelegateSub<Integer>((Flow.Subscriber<Integer>) subscriber){
//                    int result = init;
//                    @Override
//                    public void onNext(Integer item) {
//                        result= bf.apply(result,item);
//                    }
//                    @Override
//                    public void onComplete() {
//                        subscriber.onNext(result);
//                        subscriber.onComplete();
//                    }
//                });
//
//            }
//        };
//    }

//    private static Flow.Publisher<Integer> sumPub(Flow.Publisher<Integer> source) {
//        return new Flow.Publisher<Integer>() {
//            int sum = 0;
//            @Override
//            public void subscribe(Flow.Subscriber<? super Integer> subscriber) {
//                source.subscribe(new DelegateSub<Integer>((Flow.Subscriber<Integer>) subscriber){
//                    @Override
//                    public void onNext(Integer item) {
//                        sum+=item;
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        subscriber.onNext(sum);
//                        subscriber.onComplete();
//                    }
//                });
//            }
//        };
//    }

    private static <T> Flow.Publisher<T> mapPub(Flow.Publisher<T> pub, Function<T,T> function){
        return new Flow.Publisher<T>() {
            @Override
            public void subscribe(Flow.Subscriber<? super T> sub) {
                pub.subscribe(new DelegateSub<>((Flow.Subscriber<T>) sub){
                    @Override
                    public void onNext(T item) {
                        sub.onNext(function.apply(item));
                    }
                });
            }
        };
    }

    private static <T> Flow.Subscriber<T> logSub() {
        Flow.Subscriber<T> subscriber = new Flow.Subscriber<>() {
            private Flow.Subscription subscription;
            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription;
                System.out.println("onSubscribe");
                subscription.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(T item) {
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

