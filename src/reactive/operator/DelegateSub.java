package reactive.operator;

import java.util.concurrent.Flow;
import java.util.function.Function;

class DelegateSub implements Flow.Publisher<Integer> {

    private Flow.Publisher<Integer> source;
    private Function<Integer,Integer> function;

    public DelegateSub(Flow.Publisher<Integer> source, Function<Integer, Integer> function) {
        this.source = source;
        this.function = function;
    }

    @Override
    public void subscribe(Flow.Subscriber<? super Integer> subscriber) {
        source.subscribe(
                new Flow.Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Flow.Subscription subscription) {
                        subscriber.onSubscribe(subscription);
                    }
                    @Override
                    public void onNext(Integer item) {
                        subscriber.onNext(function.apply(item));
                    }
                    @Override
                    public void onError(Throwable throwable) {
                        subscriber.onError(throwable);
                    }

                    @Override
                    public void onComplete() {
                        subscriber.onComplete();
                    }
                });
    }

}
