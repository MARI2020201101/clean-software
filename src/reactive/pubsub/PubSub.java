package reactive.pubsub;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Flow;

class PubSub {
    public static void main(String[] args) {
        List<Integer> itr = Arrays.asList(1,2,3,4,5);
        Flow.Publisher publisher = new Flow.Publisher<Integer>() {
            @Override
            public void subscribe(Flow.Subscriber<? super Integer> subscriber) {
                subscriber.onSubscribe(new Flow.Subscription() {
                    @Override
                    public void request(long n) {
                        int size = itr.size();
                        while(n-- > 0 && --size >= 0){
                            subscriber.onNext(itr.get(size));
                        }
                    }

                    @Override
                    public void cancel() {
                        System.out.println("cancel");
                    }
                });
                subscriber.onComplete();
            }
        };
        Flow.Subscriber<Integer> subscriber = new Flow.Subscriber<Integer>() {
            private Flow.Subscription subscription;
            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription;
                System.out.println("onSubscribe");
                subscription.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer item) {
                System.out.println("item -> "+item);
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

