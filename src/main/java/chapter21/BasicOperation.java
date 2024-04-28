package chapter21;

/**
 * 在Java中，当一个枚举实现了一个接口，该接口中声明的所有抽象方法都必须被枚举的每个实例所实现。在BasicOperation枚举的场景中，
 * 由于它实现了Operation接口，所以枚举的每个实例（即PLUS, MINUS, TIMES, DIVIDE）都必须提供apply方法的具体实现。
 *
 * 这种设计方式提供了极高的灵活性。首先，它允许Operation接口的任何使用者不必关心具体的实现类是什么，只需要知道它可以调用apply方法。
 * 这是一种典型的面向接口编程，而不是面向实现编程的设计原则，有助于降低代码间的耦合度。
 *
 * 其次，由于Operation是一个接口，因此你可以轻松地添加更多实现该接口的类或枚举，而不仅限于BasicOperation。这为将来扩展功能提供了便利，
 * 只要新的操作实现了Operation接口，就可以被接受为一个有效的操作，无需修改现有的接口或其他实现类。
 *
 * 最后，由于apply是Operation接口的一部分，因此在BasicOperation枚举中不需要显式声明它为抽象方法。每个枚举实例都提供了apply方法的具体实现，
 * 满足了接口契约的要求。这样的设计使得代码更加简洁，并且直接强调了枚举实例的行为差异，即不同的数学运算。
 *
 * 总之，通过接口来定义API，并让枚举或类实现这个接口，是一种非常灵活且强大的设计模式。它不仅促进了接口和实现的分离，还提供了扩展性和灵活性，使得未来添加新的操作或实现变得更加容易。
 * @author karl xie
 */
public enum BasicOperation implements Operation {

    PLUS("+") {
        public double apply(double x, double y) {
            return x + y;
        }
    }, MINUS("-") {
        public double apply(double x, double y) {
            return x - y;
        }
    }, TIMES("*") {
        public double apply(double x, double y) {
            return x * y;
        }
    }, DIVIDE("/") {
        public double apply(double x, double y) {
            return x / y;
        }
    };

    private final String symbol;

    BasicOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}