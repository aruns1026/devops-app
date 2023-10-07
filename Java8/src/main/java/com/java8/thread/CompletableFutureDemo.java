package com.java8.thread;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class CompletableFutureDemo {

    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(5);
        CompletableFuture.supplyAsync(() -> {
            System.out.println("Current Thread is: " + Thread.currentThread().getName());
            return Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        }, executor).thenApplyAsync(numbers -> {
            System.out.println("Current Thread is: " + Thread.currentThread().getName());
            return numbers.stream()
                    .filter(n -> n % 2 == 0)
                    .collect(Collectors.toList());
        }, executor).thenAcceptAsync(numbers -> {
            System.out.println("Current Thread is: " + Thread.currentThread().getName());
            numbers.forEach(System.out::println);
        }, executor);
    }
}
