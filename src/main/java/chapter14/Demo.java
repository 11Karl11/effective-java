package chapter14;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

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


    public static <E> Set<E> union1(Set<? extends E> s1, Set<? extends E> s2) {
        HashSet<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    public static void main(String[] args) {
        Set<Number> numbers = Demo.<Number>union1(Sets.newHashSet(1, 2), Sets.newHashSet(2.3, 3.9));
        System.out.println(numbers);
    }
}