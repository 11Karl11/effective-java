package chapter15;

import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author karl xie
 */
public class Test {

    public static void main(String[] args) {
        // String[] objects = pickTwo("1", "2", "3");
        // for (Object o : objects) {
        //     System.out.println(o);
        // }
        for (Number number : flatten(Lists.newArrayList(1, 23, 4), Lists.newArrayList(1.25))) {
            System.out.println(number);
        }

        for (Number number : flatten(Lists.newArrayList(1, 9, 4), Lists.newArrayList(1.251))) {
            System.out.println(number);
        }

        for (Integer integer : pickTwo(1, 2, 3)) {
            System.out.println(integer);
        }

    }
    //unsafe
    static void dangerous(List<String>... stringLists) {
        List<Integer> intList = Lists.newArrayList(42);
        Object[] objects = stringLists;

        objects[0] = intList; // Heap pollution

        String s = stringLists[0].get(0); // ClassCastException
    }

    //unsafe
    static <T> T[] pickTwo(T a, T b, T c) {
        switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0: return (T[]) Lists.newArrayList(a, b).toArray();
            case 1: return (T[]) Lists.newArrayList(a, c).toArray();
            case 2: return (T[]) Lists.newArrayList(b, c).toArray();
        }
        throw new AssertionError(); // Can't get here
    }

    static <T> List<T> pickTwoNew(T a, T b, T c) {
        switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0: return Lists.newArrayList(a, b);
            case 1: return Lists.newArrayList(a, c);
            case 2: return Lists.newArrayList(b, c);
        }
        throw new AssertionError();
    }

    @SafeVarargs
    static <T> List<T> flatten(List<? extends T>... lists) {
        List<T> result = new ArrayList<>();

        for (List<? extends T> list : lists) {
            result.addAll(list);
        }

        return result;
    }

    // List as a typesafe alternative to a generic varargs parameter
    static <T> List<T> flatten(List<List<? extends T>> lists) {
        List<T> result = new ArrayList<>();

        for (List<? extends T> list : lists) {
            result.addAll(list);
        }

        return result;
    }


}