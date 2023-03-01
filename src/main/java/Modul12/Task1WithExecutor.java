package Modul12;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Task1WithExecutor extends Thread{
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
            executorService.scheduleAtFixedRate(new TaskTimeNow(),1, 1, TimeUnit.SECONDS);

            executorService.scheduleAtFixedRate(() -> System.out.println("5 seconds passed"),
                5, 5, TimeUnit.SECONDS);

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
    }


    public static class TaskTimeNow implements Runnable{
        private int t = 0;
        @Override
        public void run() {
            t++;
            System.out.println("Time passed: " + t);
        }
    }
}
