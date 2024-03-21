package chapter2;

/**
 * @author karl xie
 *
 */
public class Elvis {
    private static final Elvis INSTANCE = new Elvis();

    private Elvis() {}

    public static Elvis getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {
        System.out.println("Elvis leaves the building.");
    }

    // 所有实例字段都应该是 transient 的
    private transient int someState;


    /**
     * 在这个例子中，readResolve方法简单地返回了Elvis类的单例实例INSTANCE，这样无论何时反序列化，都只会使用这个已经存在的实例，
     * 而不是创建一个新的实例。这个方法是在反序列化过程中，当对象被读取出来之后、返回给调用者之前被调用的。
     * 需要注意的是，readResolve方法必须是private的，返回类型必须是Object，以确保它不会改变类的正常公共API，同时能够被JVM识别为特殊的序列化机制。
     * 通过这种方式，你可以保证即使在序列化和反序列化的环境下，单例类的唯一性和全局访问性不会被破坏
     * @return
     */
    private Object readResolve() {
        // 返回真正的Elvis实例，替代反序列化出来的新实例
        return INSTANCE;
    }
}
