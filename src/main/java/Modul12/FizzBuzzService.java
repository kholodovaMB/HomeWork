package Modul12;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

public class FizzBuzzService {

    private final int num = 20;
    public BlockingDeque<String> queue = new LinkedBlockingDeque<>();
    public static volatile AtomicInteger n = new AtomicInteger(1);

    public synchronized void addQueue(String element){
        queue.add(element);
    }
      public synchronized void fizz(){
        while (n.get() < num) {
            if (n.get() % 3 == 0 && n.get() % 5 != 0) {
                addQueue("fizz");
                n.incrementAndGet();
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void buzz(){
        while (n.get() < num) {
            if (n.get() % 5 == 0 && n.get() % 3 != 0) {
                addQueue("buzz");
                n.incrementAndGet();
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void fizzbuzz(){
        while (n.get() < num) {
            if (n.get() % 3 == 0 && n.get() % 5 == 0) {
                addQueue("fizzbuzz");
                n.incrementAndGet();
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void number(){
        while (n.get() < num) {
            if (n.get() % 3 != 0 && n.get() % 5 != 0) {
                addQueue(String.valueOf(n.get()));
                n.incrementAndGet();
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

        public void printQueue(){
        while (true){
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            while (!queue.isEmpty()){
                System.out.println(queue.poll());
            }
        }
    }

}
