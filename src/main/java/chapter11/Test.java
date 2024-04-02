package chapter11;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author karl xie
 */
public class Test {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        List<Object>  objects = Arrays.asList();
        List<Object>  objects1 = Arrays.asList();
        List<String> strings = Arrays.asList();
        objects=objects1;

        List<?> a = Arrays.asList();

        boolean b = a instanceof List;
        System.out.println(b);
        Set<Test> sets = new HashSet();
        String[] strings1 = new String[3];

    }
}