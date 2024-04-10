package chapter17.adv;

/**
 * 如果向第二个版本的操作添加新的常量，则不太可能会忘记提供 apply 方法，因为该方法紧跟在每个常量声明之后。
 * 万一忘记了，编译器会提醒你，因为枚举类型中的抽象方法必须被所有常量中的具体方法重写。
 *
 * @author karl xie
 */
public enum Operation {
    PLUS {
        public double apply(double x, double y) {
            return x + y;
        }
    }, MINUS {
        public double apply(double x, double y) {
            return x - y;
        }
    }, TIMES {
        public double apply(double x, double y) {
            return x * y;
        }
    }, DIVIDE {
        public double apply(double x, double y) {
            return x / y;
        }
    };


    public abstract double apply(double x, double y);
}