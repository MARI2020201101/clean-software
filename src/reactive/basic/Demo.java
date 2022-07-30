package reactive.basic;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Demo {
    public static void main(String[] args) throws InterruptedException {
        IntObservable observable = new IntObservable();
        IntObserver observer = new IntObserver(observable);
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(observable);
    }
}
class IntObservable extends Observable implements Runnable{
    @Override
    public void run() {
        for(int i=0 ; i <10 ; i++){
            setChanged();
            notifyObservers(i);
        }
    }
}
class IntObserver implements Observer{

    Observable o ;

    public IntObserver(Observable o) {
        this.o = o;
        o.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(Thread.currentThread().getName() +" : " + arg);
    }

}