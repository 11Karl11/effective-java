package chapter14;

import java.util.List;

/**
 * public static <E> void swap(List<E> list, int i, int j);public static void swap(List<?> list, int i, int j);
 * 这两个声明中的哪一个更可取，为什么？ 在公共 API 中，第二个更好，因为它更简单。 你传入一个列表（任何列表），该方法交换索引的元素。
 * 没有类型参数需要担心。 通常， 如果类型参数在方法声明中只出现一次，请将其替换为通配符。如果它是一个无限制的类型参数，请将其替换为无限制的通配符;
 * 如果它是一个限定类型参数，则用限定通配符替换它。
 * @author karl xie
 */
public class Test2 {

    public static void main(String[] args) {
    }

    public static void swap(List<?> list, int i, int j) {
        // list.set(i, list.set(j, list.get(i)));
        swapHelper(list, i, j);
    }

    // Private helper method for wildcard capture
    private static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }

}