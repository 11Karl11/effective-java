package chapter30;

/**
 * @author karl xie
 */
public class InterruptExample implements Runnable {

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                // 执行一些任务
                System.out.println("Thread is running");
                Thread.sleep(1000); // 模拟一些工作
            }
        } catch (InterruptedException e) {
            // 重新设置中断状态
            Thread.currentThread().interrupt();
            System.out.println("Thread was interrupted, exiting...");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InterruptExample());
        thread.start();

        // 主线程等待3秒，然后中断工作线程
        Thread.sleep(3000);
        thread.interrupt();
    }
}