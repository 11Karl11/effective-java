package chapter29;

import java.util.concurrent.TimeUnit;

/**
 * 你可能期待这个程序运行大约一秒钟左右，之后主线程将 stopRequested 设置为 true ，致使后台线程的循环终止。但是在我的机器上，
 * 这个程序永远不会终止：因为后台线程永远在循环！问题在于，由于没有同步，就不能保证后台线程何时‘看到’主线程对stopRequested 的值所做的改变。
 *
 * @author karl xie
 */
public class StopThread {
    private static Boolean stopRequested = false;
    // private static volatile Boolean stopRequested = false;

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested) {
                i++;
            }
        });

        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}