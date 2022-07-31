package javaasync;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class FutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newSingleThreadExecutor();
        System.out.println(getThreadName() + "::  start -------");
        Future<String> result
                = es.submit(() -> printHello("Hong GilDong"));
        System.out.println(getThreadName() + "::  submit ------ ");
        System.out.println(getThreadName() + ":: "+ result.get());

        System.out.println(getThreadName() + "::  end -------  ");
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
