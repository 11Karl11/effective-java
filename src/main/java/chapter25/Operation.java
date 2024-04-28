package chapter25;

import java.util.function.DoubleBinaryOperator;

/**
 * @author karl xie
 */
public enum Operation {
    // 每个枚举实例都定义了一个操作符号和一个对应的操作（使用Lambda表达式）
    PLUS("+", (x, y) -> x + y),      // 加法操作
    MINUS("-", (x, y) -> x - y),     // 减法操作
    TIMES("*", (x, y) -> x * y),     // 乘法操作
    DIVIDE("/", (x, y) -> x / y);    // 除法操作

    // 私有字段，用于存储操作符号
    private final String symbol;
    // 私有字段，用于存储执行具体操作的函数式接口实例
    private final DoubleBinaryOperator op;

    // 构造函数，用于创建枚举实例时初始化字段
    Operation(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    // 重写 toString 方法，返回操作符号
    @Override
    public String toString() {
        return symbol;
    }

    // 提供一个公共方法，允许执行具体的运算
    public double apply(double x, double y) {
        return op.applyAsDouble(x, y);
    }
}