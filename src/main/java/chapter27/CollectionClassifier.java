package chapter27;

import java.math.BigInteger;
import java.util.*;

/**
 * 虽然这个程序编译没有问题,但是运行结果可能与预期不符。问题出在重载的 classify 方法上。
 *
 * 在 Java 中,重载方法的选择是在编译时根据静态类型进行的,而不是在运行时根据动态类型决定的。在这个例子中,collections
 * 数组的静态类型是 Collection<?>[],所以在编译时,对 classify 方法的调用会被解析为 classify(Collection<?>),
 * 而不管实际传入的参数是 HashSet、ArrayList 还是 HashMap.values()。
 * @author karl xie
 */
public class CollectionClassifier {
    public static String classify(Set<?> s) {
        return "Set";
    }

    public static String classify(List<?> lst) {
        return "List";
    }

    public static String classify(Collection<?> c) {
        return "Unknown Collection";
    }

    public static void main(String[] args) {
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String, String>().values()
        };

        for (Collection<?> c : collections)
            System.out.println(classify(c));
    }
}