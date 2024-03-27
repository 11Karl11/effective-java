package chapter10.optimize;

/**
 * 这个类层次纠正了之前提到的标签类的每个缺点。 代码简单明了，不包含原文中的样板文件。 每种类型的实现都是由自己的类来分配的，而这些类都没有被无关的数据字段所占用。
 * 所有的字段是final 的。 编译器确保每个类的构造方法初始化其数据字段，并且每个类都有一个针对在根类中声明的每个抽象方法的实现。
 * 这消除了由于缺少 switch-case 语句而导致的运行时失败的可能性。 多个程序员可以独立地继承类层次，并且可以相互操作，而无需访问根类的源代码。
 * 每种类型都有一个独立的数据类型与之相关联，允许程序员指出变量的类型，并将变量和输入参数限制为特定的类型。
 * @author karl xie
 */
class Rectangle extends Figure {
    private final double length;
    private final double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }
}