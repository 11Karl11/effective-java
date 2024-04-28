package chapter24;

/**
 * @author karl xie
 */
public class TransportService {
    public void sendObject(Transportable object) {
        // 在这里,我们可以安全地传输对象,因为我们知道它是 Transportable 的
        System.out.println("Transporting object: " + object);
    }
}