package chapter20.adv1;


import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 个阶段转换都由一对阶段枚举来索引，所以最好将关系表示为从一个枚举（from 阶段）到第二个枚举（to 阶段）到结果（阶段转换）的 map 。
 * 与阶段转换相关的两个阶段最好通过将它们与阶段转换枚举相关联来捕获，然后可以用它来初始化嵌套的EnumMap
 * @author karl xie
 */
public enum Phase {
    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID), BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID), SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);

        private final Phase from;
        private final Phase to;

        Transition(Phase from, Phase to) {
            this.from = from;
            this.to = to;
        }

        // Initialize the phase transition map
        private static final Map<Phase, Map<Phase, Transition>> m =
                Stream.of(values()).collect(Collectors.groupingBy(t -> t.from,() -> new EnumMap<>(Phase.class),
                        Collectors.toMap(t -> t.to, t -> t, (x, y) -> y, () -> new EnumMap<>(Phase.class))));

        public static Transition from(Phase from, Phase to) {
            return m.get(from).get(to);
        }
    }

    public static void main(String[] args) {
        System.out.println(Transition.from(SOLID, GAS));
    }
}