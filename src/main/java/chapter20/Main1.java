package chapter20;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 这段程序更简短，更清晰，更安全，运行速度与原始版本相当。 没有不安全的转换; 无需手动标记输出，因为 map 键是知道如何将自己转换为可打印字符串的枚举;
 * 并且不可能在计算数组索引时出错。 EnumMap 与序数索引数组的速度相当，其原因是 EnumMap 内部使用了这样一个数组，
 * 但它对程序员的隐藏了这个实现细节，将 Map 的丰富性和类型安全性与数组的速度相结合。 请注意，EnumMap 构造方法接受键类 Class 型的 Class 对象：
 * 这是一个有限定的类型令牌（bounded typetoken），它提供运行时的泛型类型信息。
 *
 * @author karl xie
 */
public class Main1 {

    public static void main(String[] args) {
        Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);

        for (Plant.LifeCycle lc : Plant.LifeCycle.values()) {
            plantsByLifeCycle.put(lc, new HashSet<>());
        }
        List<Plant> garden = Lists.newArrayList();
        garden.add(new Plant("苹果", Plant.LifeCycle.PERENNIAL));
        garden.add(new Plant("梨", Plant.LifeCycle.PERENNIAL));
        garden.add(new Plant("香蕉", Plant.LifeCycle.ANNUAL));
        // garden.add(new Plant("xx", Plant.LifeCycle.BIENNIAL));
        Plant[] plants = garden.toArray(new Plant[0]);
        for (Plant p : garden) {
            plantsByLifeCycle.get(p.lifeCycle).add(p);
        }

        System.out.println(plantsByLifeCycle);
        //这个代码的问题在于它选择了自己的 Map 实现，实际上它不是 EnumMap ，所以它不会与显式EnumMap 的版本的空间和时间性能相匹配。
        Map<Plant.LifeCycle, List<Plant>> lifeCycleListMap = Arrays.stream(plants).collect(Collectors.groupingBy(p -> p.lifeCycle));
        System.out.println(lifeCycleListMap);


        EnumMap<Plant.LifeCycle, Set<Plant>> cycleSetEnumMap =
                Arrays.stream(plants).collect(Collectors.groupingBy(p -> p.lifeCycle,
                        () -> new EnumMap<>(Plant.LifeCycle.class), Collectors.toSet()));
        System.out.println(cycleSetEnumMap);

    }
}