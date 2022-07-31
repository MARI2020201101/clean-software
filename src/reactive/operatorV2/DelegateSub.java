package reactive.operatorV2;

import java.util.concurrent.Flow;
import java.util.function.Function;

class DelegateSub implements Flow.Subscriber<Integer> {
    private Flow.Subscriber subscriber;

    public DelegateSub(Flow.Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        subscriber.onSubscribe(subscription);
    }
    @Override
    public void onNext(Integer item) {
        subscriber.onNext(item);
    }
    @Override
    public void onError(Throwable throwable) {
        subscriber.onError(throwable);
    }

    @Override
    public void onComplete() {
        subscriber.onComplete();
    }


}
