package chapter17.other;

/**
 * @author karl xie
 */
public class Main {
    public static void main(String[] args) {
        double x = 2.0;
        double y = 4.0;

        for (Operation op : Operation.values()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }

}