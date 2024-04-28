package chapter20.adv;

/**
 * 这段程序可以运行，甚至可能显得优雅，但外观可能是骗人的。 就像前面显示的简单的花园示例一样，编译器无法知道序数和数组索引之间的关系。
 * 如果在转换表中出错或者在修改 Phase 或Phase.Transition 枚举类型时忘记更新它，则程序在运行时将失败。
 * 失败可能是ArrayIndexOutOfBoundsException ， NullPointerException 或（更糟糕的）沉默无提示的错误行为。 即使非空条目的数量较小，表格的大小也是 phase 的个数的平方。
 * @author karl xie
 */
public enum Phase {
    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;

        // Rows indexed by from-ordinal, cols by to-ordinal
        private static final Transition[][] TRANSITIONS = {{null, MELT, SUBLIME}, {FREEZE, null, BOIL}, {DEPOSIT, CONDENSE, null}};

        // Returns the phase transition from one phase to another
        public static Transition from(Phase from, Phase to) {
            return TRANSITIONS[from.ordinal()][to.ordinal()];
        }
    }

}