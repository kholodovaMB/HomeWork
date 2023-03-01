package Modul12;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

public class Task2 {

    public static void main(String[] args) {


        ExecutorService service = Executors.newFixedThreadPool(5);

        FizzBuzzService fizzBuzzService = new FizzBuzzService();

        service.submit(()-> {
            fizzBuzzService.fizz();
        });
        service.submit(()-> {
            fizzBuzzService.buzz();
        });
        service.submit(()-> {
            fizzBuzzService.fizzbuzz();
        });
        service.submit(()-> {
            fizzBuzzService.number();
        });
        service.submit(()-> {
            fizzBuzzService.printQueue();
        });


    }

}
