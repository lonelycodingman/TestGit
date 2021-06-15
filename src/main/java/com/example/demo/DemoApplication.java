package com.example.demo;

import com.example.demo.pojos.Apple;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        });

        Thread thread1 = new Thread(() -> System.out.printf("Hello World!"));

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                return Thread.currentThread().getName();
            }
        });

        Future<String> future1 = executorService.submit(() -> Thread.currentThread().getName());

        Comparator<Apple> appleComparator = new Comparator<Apple>() {

            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        };

        Comparator<Apple> appleComparator1 = (o1,o2) -> o1.getWeight().compareTo(o2.getWeight());

        List<String> str = Arrays.asList("1","2","3");
        str.stream().filter(s -> s.equals("1"))
                .collect(Collectors.toList());
        str.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });

        str.sort((o1,o2) ->o1.compareToIgnoreCase(o2));

        str.sort(String::compareTo);


    }

}
