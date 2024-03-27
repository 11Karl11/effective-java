package chapter10;

/**
 * 这样的标签类具有许多缺点。 它们充斥着杂乱无章的样板代码，包括枚举声明，标签字段和switch 语句。 可读性更差，因为多个实现在一个类中混杂在一起。
 * 内存使用增加，因为实例负担属于其他风格不相关的领域。 字段不能成为 final，除非构造方法初始化不相关的字段，导致更多的样板代码。
 * 构造方法在编译器的帮助下，必须设置标签字段并初始化正确的数据字段：如果初始化错误的字段，程序将在运行时失败。 除非可以修改其源文件，否则不能将其添加到标记的类中。
 * 如果你添加一个风格，你必须记得给每个 switch 语句添加一个 case ，否则这个类将在运行时失败。 最后，一个实例的数据类型没有提供任何关于风格的线索。
 * 总之，标签类是冗长的，容易出错的，而且效率低下。
 * @author karl xie
 */
class Figure {
    enum Shape {RECTANGLE, CIRCLE}

    // Tag field - the shape of this figure
    final Shape shape;

    // These fields are used only if shape is RECTANGLE
    double length;
    double width;

    // This field is used only if shape is CIRCLE
    double radius;

    // Constructor for circle
    Figure(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    // Constructor for rectangle
    Figure(double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area() {
        switch (shape) {
            case RECTANGLE:
                return length * width;
            case CIRCLE:
                return Math.PI * (radius * radius);
            default:
                throw new AssertionError(shape);
        }
    }
}