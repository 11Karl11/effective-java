package chapter21;

/**
 * 尽管Java的枚举类型本身不是可扩展的（即你不能从一个枚举继承创建另一个枚举）。
 *
 * 这种方法的关键在于定义一个接口（如前面例子中的Operation接口），然后让一个或多个枚举实现这个接口。这样，你就可以在代码中使用这个接口作为参数类型、
 * 返回类型或变量类型，从而允许任何实现了该接口的枚举（或其他类型的类）被传递和使用。
 *
 * 这种设计提供了良好的灵活性和扩展性。例如，如果你有一个计算器应用程序，你可以定义一个Operation接口来表示所有可能的数学运算。
 * 然后，你可以创建一个基本操作的枚举（如BasicOperation）和一个扩展操作的枚举（如ExtendedOperation），它们都实现了Operation接口。
 * 此外，客户端代码也可以定义自己的运算和实现Operation接口的枚举或类，而无需修改原有的代码基础。
 *
 * 这种方式的另一个优点是，它允许使用Java的多态特性。因为所有的操作都是Operation接口的实现，所以你可以编写一段处理Operation类型对象的代码，
 * 它将能够透明地处理任何实现了该接口的对象，无论它是枚举实例还是其他任何类型的实例。
 *
 * 总之，通过定义接口和让枚举实现这个接口，你可以在Java中模拟可扩展的枚举，从而提供一个灵活、可扩展的解决方案，使得客户端代码能够轻松地引入新的行为，而不会破坏现有的API或需要对其进行大量修改。
 * @author karl xie
 */
public enum ExtendedOperation implements Operation {
    EXP("^") {
        public double apply(double x, double y) {
            return Math.pow(x, y);
        }
    },
    REMAINDER("%") {
        public double apply(double x, double y) {
            return x % y;
        }
    };

    private final String symbol;

    ExtendedOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}