package javaasync.callback;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

class FutureTaskExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newSingleThreadExecutor();
        FutureTask<String> ft = new FutureTask<>(
                ()->printHello("Seoung ChunHyang")
        ){
            @Override
            protected void done() {
                System.out.println(getThreadName()+ " :: Task is Done");
            }
        };
        es.submit(ft);
        System.out.println(ft.get());
        System.out.println(getThreadName() + " :: end");
        es.shutdown();
    }
    static String printHello(String str) throws InterruptedException {
        Thread.sleep(1000);
        return getThreadName() + ":: hello " + str;
    }
    static String getThreadName(){
        return Thread.currentThread().getName();
    }

}
