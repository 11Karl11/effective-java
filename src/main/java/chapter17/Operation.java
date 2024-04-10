package chapter17;

/**
 * 此代码有效，但不是很漂亮。 如果没有 throw 语句，就不能编译。
 * 更糟的是，代码很脆弱。 如果添加新的枚举常量，但忘记向 switch 语句添加相应的条件，枚举仍然会编译，但在尝试应用新操作时，它将在运行时失败。
 * @author karl xie
 */
public enum Operation {
    PLUS, MINUS, TIMES, DIVIDE;

    // Do the arithmetic operation represented by this constant
    public double apply(double x, double y) {
        switch (this) {
            case PLUS:
                return x + y;
            case MINUS:
                return x - y;
            case TIMES:
                return x * y;
            case DIVIDE:
                return x / y;
        }
        throw new AssertionError("Unknown op: " + this);
    }
}