package chapter2;

/**
 * 这种方法的主要优点包括： *
 * 简洁性：代码量少，意图明确。
 * 自动支持序列化机制：不需要像其他单例实现那样担心序列化和反序列化的问题。
 * 绝对防止多实例：即使在面对复杂的序列化操作或反射攻击时，也能保证单例的唯一性。
 * 线程安全：枚举类的实例创建是线程安全的。
 * 然而，这种方法也有其局限性，主要是不能从另一个类继承，因为枚举已经隐式地继承自 java.lang.Enum，而 Java 不支持多重继承。
 * 如果你的单例类需要继承某个特定的类，那么这种方法就不适用。不过，枚举仍然可以实现接口，这为其提供了一定程度的灵活性。
 *
 * 总的来说，如果你的单例类不需要继承其他类，使用枚举实现单例模式是一个非常好的选择。
 * @author karl xie
 * Created on 2024-03-20 10:32
 */
public enum Elvis1 {
    INSTANCE;

    public void leaveTheBuilding() {
        System.out.println("Elvis has left the building!");
    }
}
