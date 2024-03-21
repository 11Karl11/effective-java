package chapter5;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 这段代码实现了一个简单的栈，其中包含 push 方法来添加元素和 pop 方法来移除元素。虽然它在功能上看起来是正确的，但存在一个潜在的内存泄漏问题。
 *
 * 内存泄漏的原因
 * 内存泄漏问题出现在 pop 方法中。当从栈中弹出元素时，该元素的引用从逻辑上被移除了（即它不再是栈的一部分），但elements数组仍然持有对该对象的引用。
 * 这阻止了垃圾收集器回收这些不再需要的对象，因为它们仍然被 elements 数组所引用，即使这些对象从栈的角度来看是“不可达”的。
 *
 * 解决方法
 * 为了避免这种内存泄漏，你应该在从栈中移除元素时，显式地清除数组中对该元素的引用。这可以通过在 pop 方法中将元素引用设置为 null 来实现：
 *
 * public Object pop() {
 *     if (size == 0) {
 *         throw new EmptyStackException();
 *     }
 *     Object result = elements[--size];
 *     elements[size] = null; // 清除过期的引用
 *     return result;
 * }
 * @author karl xie
 */
public class Stack {

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object o) {
        ensureCapacity();
        elements[size++] = o;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return elements[--size];
    }


    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

}