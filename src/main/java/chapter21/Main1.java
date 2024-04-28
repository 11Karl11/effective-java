package chapter21;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author karl xie
 */
public class Main1 {
    public static void main(String[] args) {
        double x = 1.0;
        double y = 2.0;
        test(Arrays.asList(ExtendedOperation.values()), x, y);
    }

    private static void test(Collection<? extends Operation> opSet, double x, double y) {
        for (Operation op : opSet) {
            System.out.printf("%f %s %f = %f%n",
                    x, op, y, op.apply(x, y));
        }
    }
}