package chapter14;

import java.util.HashSet;
import java.util.Set;

/**
 * @author karl xie
 */
public class Demo {

    public static Set union(Set set1, Set set2) {
        HashSet result = new HashSet(set1);
        result.addAll(set2);
        return result;
    }


    public static <E> Set<E> union1(Set<E> s1, Set<E> s2) {
        HashSet<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }
}