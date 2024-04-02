package chapter11;

import java.util.Arrays;
import java.util.List;

/**
 * 请注意，虽然这种做法是合法的，但它绕过了泛型系统的类型检查，因此应该谨慎使用，以避免潜在的运行时类型错误。
 * ，尽管在日常开发中很少有这种做法的需求，但在Java中创建一个无限定通配符类型（Unbounded Wildcard Type）的数组是合法的。
 * 无限定通配符类型使用 ? 表示，它代表任意类型。但请注意，直接创建这种数组的尝试会遇到编译时错误，因为Java泛型和数组在某些方面有不兼容的地方，
 * 主要是因为类型擦除和泛型在编译后的处理方式。但是，你可以通过创建一个非泛型的数组，然后将其转换为通配符类型的数组来间接实现这一点。
 *
 * @author karl xie
 */
public class Demo {

    public static void main(String[] args) {
        // 创建一个原始类型的List数组
        List[] listArray = new List[2];

        // 将其转换为无限定通配符类型的数组
        List<?>[] wildcardArray = listArray;

        // 使用无限定通配符类型的数组
        wildcardArray[0] = Arrays.asList("Hello", "World");
        wildcardArray[1] = Arrays.asList(1, 2, 3);

        // 打印数组内容
        for (List<?> list : wildcardArray) {
            System.out.println(list);
        }
    }
}