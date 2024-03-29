package reactive.genericoperator;

import java.util.concurrent.Flow;

class DelegateSub<T,R> implements Flow.Subscriber<T> {
    private Flow.Subscriber<T> subscriber;

    public DelegateSub(Flow.Subscriber<T> subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        subscriber.onSubscribe(subscription);
    }
    @Override
    public void onNext(T item) {
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
