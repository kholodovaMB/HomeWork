package Modul12;

public class Task1 {
    public static void main(String[] args)  {

        TimeNow thread = new TimeNow();
        thread.start();

        FiveSecond fiveSecond = new FiveSecond();
        fiveSecond.start();
        try {
            Thread.currentThread().sleep(25000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread.setLive(false);
        fiveSecond.setStopped(false);

    }

    public static class FiveSecond extends Thread{

        private boolean stopped = true;
        public void setStopped(boolean stopped) {
            this.stopped = stopped;
        }

        @Override
        public void run() {
            while (stopped){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("5 seconds passed");
            }
        }
    }

    public static class TimeNow extends Thread{
        private static int time = 0;

        public void setLive(boolean live) {
            isLive = live;
        }

        private boolean isLive = true;
        @Override
        public void run() {
            while (isLive){
                time ++;
                System.out.println("Time:" + time);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
