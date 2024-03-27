package chapter7;

/**
 * 这种设计允许Person对象在创建后的任何时候被“重新初始化”，这破坏了封装性，并且使得对象的状态管理变得复杂和易错。
 *
 * @author karl xie
 */
public class Person {
    private String name;
    private int age;

    // 构造方法仅初始化为默认值
    public Person() {
        this.name = "";
        this.age = 0;
    }

    // 独立的公共初始化方法
    public void initialize(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter方法
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public static void main(String[] args) {
        Person person = new Person();
        person.initialize("op", 11);
        Person1 jo = new Person1("jo", 9);

    }


}

/**
 * 在这个改进的设计中，Person类没有提供独立的公共初始化方法。相反，所有的初始化逻辑都被封装在构造方法中，
 * 这确保了对象的不变性和封装性。如果需要修改Person对象的状态，应该创建一个新的实例。
 *
 * 结论
 * 通过比较这两个例子，我们可以看到避免使用独立的公共初始化方法的重要性。这种做法有助于确保对象的不变性，简化对象的状态管理，并提高代码的整体质量和可维护性。
 */
class Person1 {
    private final String name;
    private final int age;

    // 构造方法直接初始化所有属性
    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter方法
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


}




