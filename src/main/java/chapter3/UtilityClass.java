package chapter3;

/**
 * 在这个例子中，UtilityClass 被声明为 final，这阻止了类的继承。构造器是私有的，这意味着外部不能实例化这个类。
 * 即使在类的内部，尝试调用这个构造器也会抛出一个 AssertionError，这可以防止类的意外实例化，包括通过反射的方式。
 *
 * 这种模式确保了工具类的正确使用方式，即作为一个包含静态方法和静态字段的集合，而不是作为一个需要实例化的对象。
 * 这样的设计方法有助于维护代码的清晰和目的性，同时避免了滥用。
 *
 * 总结来说，通过提供一个私有的构造器，你可以确保工具类不会被错误地实例化，
 * 这是一个在设计类似 java.lang.Math 或 java.util.Arrays 这样的工具类时应该遵循的最佳实践。
 * @author karl xie
 *
 */
public final class UtilityClass {
    // Suppress default constructor
    private UtilityClass() {
        // This constructor will never be called
        throw new AssertionError("Utility class should not be instantiated");
    }

    // Static method example
    public static void utilityMethod() {
        // Implementation here
    }
}
