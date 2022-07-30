package observer.ch06;

import java.util.HashSet;
import java.util.Set;

class Subject {//구독등록과 갱신을 맡는다.
    private Set<Observer> itsObservers = new HashSet<>();
    protected void notifyObservers(){
        for (Observer itsObserver : itsObservers)
            itsObserver.update();
    }
    public void registerObserver(Observer observer) {
        itsObservers.add(observer);
    }
}
