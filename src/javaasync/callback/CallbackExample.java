package javaasync.callback;

import java.util.concurrent.*;

class CallbackExample {
    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
        System.out.println(getThreadName() + ":: start -------------");
        es.submit(
            new CallbackFutureTask(
                ()->printHello("Kim Chunbae"),
                (result)-> System.out.println("Task success :: " + result),
                (exception) -> System.out.println("Task Failed :: " + exception)
        ));
        System.out.println(getThreadName() + ":: end --------------");
        es.shutdown();
    }
    static String printHello(String str) throws InterruptedException {
        Thread.sleep(1000);
        throw new RuntimeException("Errrrrrrrrrr");
//        return getThreadName() + ":: hello " + str;
    }
    static String getThreadName(){
        return Thread.currentThread().getName();
    }

}
class CallbackFutureTask extends FutureTask<String>{
    SuccessCallback sc;
    FailCallback fc;
    public CallbackFutureTask(Callable<String> callable,SuccessCallback sc,FailCallback fc) {
        super(callable);
        this.sc = sc;
        this.fc = fc;
    }

    @Override
    protected void done() {
        try {
            sc.success(get());
        } catch (Exception e) {
            fc.fail(e.getMessage());
        }
    }
}
@FunctionalInterface
interface SuccessCallback {
    void success(String result);
}
@FunctionalInterface
interface FailCallback {
    void fail(String result);
}
