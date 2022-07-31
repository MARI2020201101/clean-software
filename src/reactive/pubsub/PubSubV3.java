package reactive.pubsub;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Flow;

class PubSubV3 {
    public static void main(String[] args) {
        Iterable<Integer> itr = Arrays.asList(1,2,3,4,5);
        Iterator<Integer> iterator = itr.iterator();
        Flow.Publisher publisher = new Flow.Publisher<Integer>() {
            @Override
            public void subscribe(Flow.Subscriber<? super Integer> subscriber) {
                subscriber.onSubscribe(new Flow.Subscription() {
                    @Override
                    public void request(long n) {
                        if(n-->0 && iterator.hasNext()){
                            subscriber.onNext(iterator.next());
                        }else{
                            subscriber.onComplete();
                        }
                    }

                    @Override
                    public void cancel() {
                        System.out.println("cancel");
                    }
                });

            }
        };
        Flow.Subscriber<Integer> subscriber = new Flow.Subscriber<Integer>() {
            private Flow.Subscription subscription;
            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription;
                System.out.println("onSubscribe");
                subscription.request(1);
            }

            @Override
            public void onNext(Integer item) {
                System.out.println("item -> "+item);
                subscription.request(1);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable.getMessage());
                subscription.cancel();
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
                subscription.cancel();
            }
        };

        publisher.subscribe(subscriber);
    }
}

