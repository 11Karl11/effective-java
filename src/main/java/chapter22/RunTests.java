package chapter22;

/**
 * 执行到`m5`会报空指针异常的原因在于`m5`是一个非静态方法。在Java反射中，当你使用`Method.invoke()`方法调用一个实例（非静态）方法时，
 * 需要提供一个该方法所属类的实例作为`invoke`方法的第一个参数。如果你传入`null`，就像在`m.invoke(null)`这样做，那么当尝试调用非静态方法时就会抛出`NullPointerException`。
 *
 * 在你的`RunTests`类中，对所有方法的调用都使用了`m.invoke(null)`，这对静态方法是合适的，因为静态方法不依赖于类实例。然而，对于非静态方法，
 * 如`m5`，这种方式就会引发问题，因为Java尝试在`null`引用上调用方法，导致空指针异常。
 *
 * 要解决这个问题，你需要区分对待静态和非静态方法。对于非静态方法，你需要创建一个实例，并将这个实例作为`invoke`方法的第一个参数，如下所示：
 *
 * ```java
 * if (Modifier.isStatic(m.getModifiers())) {
 *     m.invoke(null);
 * } else {
 *     m.invoke(testClass.getDeclaredConstructor().newInstance());
 * }
 * ```
 *
 * 这样，对于非静态方法，你就会创建一个类的新实例，并在这个新实例上调用方法，从而避免空指针异常。请注意，这里假设类有一个无参构造函数。
 * 如果类没有无参构造函数，或者构造函数是私有的，你可能需要采取其他措施来创建实例。
 * @author karl xie
 */

import java.lang.reflect.*;

public class RunTests {
    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName(Sample.class.getName());

        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    System.out.println(m + " failed: " + exc);
                } catch (Exception exc) {
                    System.out.println("Invalid @Test: " + m);
                    exc.printStackTrace();
                }
            }
        }

        System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
    }
}