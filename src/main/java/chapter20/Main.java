package chapter20;

import com.google.common.collect.Lists;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 这种方法是有效的，但充满了问题。 因为数组不兼容泛型，程序需要一个未经检查的转换，并且不会干净地编译。
 * 由于该数组不知道索引代表什么，因此必须手动标记索引输出。 但是这种技术最严重的问题是，当你访问一个由枚举序数索引的数组时，
 * 你有责任使用正确的 int 值;int 不提供枚举的类型安全性。 如果你使用了错误的值，程序会默默地做错误的事情，如果你幸运的话，
 * 抛出一个 ArrayIndexOutOfBoundsException 异常。
 * @author karl xie
 */
public class Main {

    public static void main(String[] args) {
        Set<Plant>[] plantsByLifeCycle = (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];

        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            plantsByLifeCycle[i] = new HashSet<>();
        }

        List<Plant> garden = Lists.newArrayList();
        garden.add(new Plant("苹果", Plant.LifeCycle.PERENNIAL));
        garden.add(new Plant("梨", Plant.LifeCycle.PERENNIAL));
        garden.add(new Plant("香蕉", Plant.LifeCycle.ANNUAL));
        garden.add(new Plant("xx", Plant.LifeCycle.BIENNIAL));
        for (Plant p : garden) {
            int ordinal = p.lifeCycle.ordinal();
            System.out.println(ordinal);
            Set<Plant> plants = plantsByLifeCycle[ordinal];
            plants.add(p);
        }

        // Print the results
        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            System.out.printf("%s: %s%n", Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
        }
    }

}