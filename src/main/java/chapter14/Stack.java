package chapter14;

import com.google.common.collect.Lists;
import com.sun.java.accessibility.util.java.awt.ListTranslator;

import java.util.*;

/**
 * 这里有一个助记符来帮助你记住使用哪种通配符类型： PECS 代表： producer-extends，consumer-super。
 * 换句话说，如果一个参数化类型代表一个 T 生产者，使用 <? extends T> ；如果它代表 T消费者，则使用 <? super T> 。
 * @author karl xie
 */
public class Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public Stack() {
        //你不能创建一个不可具体化类型的数组 错误示例：elements = new E[DEFAULT_INITIAL_CAPACITY];
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        E result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference
        return result;
    }

    public void pushAll(Iterable<? extends E> src) {
        for (E e : src) {
            push(e);
        }
    }

    public static void main(String[] args) {
        Stack<Number> numberStack = new Stack<>();
        Iterable<Integer> integers = Lists.newArrayList(1, 2, 3);
        numberStack.pushAll(integers);

        Collection<Object> objects = Lists.newArrayList();
        numberStack.popAll(objects);
    }

    public void popAll(Collection<? super E> dst) {
        while (!isEmpty()) {
            dst.add(pop());
        }
    }

    // ... no changes in isEmpty or ensureCapacity
    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }
}