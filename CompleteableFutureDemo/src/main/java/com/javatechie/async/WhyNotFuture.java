package com.javatechie.async;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class WhyNotFuture {
/*    Using Future, the computation cannot be completed manually.
It does not notify once the commutation is completed.
There is a lack of mechanism like create stages of processing
that are chained together and to run Future in parallel and combined their results.*/
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service=Executors.newFixedThreadPool(10);

        Future<List<Integer>> future = service.submit(() -> {
            //your doing api call
            System.out.println("Thread : "+Thread.currentThread().getName());
            //System.out.println(10/0);
            delay(1);
            return Arrays.asList(1, 2, 3, 4);
        });


        List<Integer> integers = future.get();
        System.out.println(integers);

        CompletableFuture<String> completableFuture=new CompletableFuture<>();
        completableFuture.get();
        completableFuture.complete("return some dummy data.....");

    }

    private static void delay(int min) {
        try {
            TimeUnit.MINUTES.sleep(min);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
