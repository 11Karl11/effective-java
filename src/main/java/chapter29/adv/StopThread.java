package chapter29.adv;

/**
 * @author karl xie
 */
import java.util.concurrent.TimeUnit;

public class StopThread {
    private static Boolean stopRequested = false;

    private static synchronized void requestStop() {
        stopRequested = true;
    }

    private static synchronized Boolean stopRequested() {
        return stopRequested;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested()) {
                i++;
            }
        });

        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        requestStop();
    }
}