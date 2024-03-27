package chapter6;

import chapter4.one.EmailService;

import java.util.*;

import static java.util.Comparator.comparingInt;

/**
 * 在这个示例中，首先使用 HashSet 来去除重复的字符串。然后，将 Set 转换回数组，以便使用 Arrays.sort() 方法对其进行排序。
 * 由于 String 类实现了 Comparable 接口，所以可以直接对字符串数组进行排序。最后，打印排序后的字符串数组。
 * <p>
 * 这个过程演示了 Comparable 接口的强大功能，它使得对一组对象进行排序和管理变得非常简单和直接。通过实现 Comparable 接口，开发者可以为自定义
 * 类提供自然排序的能力，进一步增强了Java集合框架的灵活性和强大功能。
 *
 * @author karl xie
 */
public class SortUniqueStrings {
    public static void main(String[] args) {
        // 使用HashSet去除重复的字符串
        Set<String> uniqueStrings = new HashSet<>(Arrays.asList("c", "b", "e", "a"));
        System.out.println(uniqueStrings);
        // 将Set转换回数组
        String[] uniqueArray = uniqueStrings.toArray(new String[0]);

        // 对数组排序
        Arrays.sort(uniqueArray);

        // 打印排序后的结果
        for (String str : uniqueArray) {
            System.out.println(str);
        }
    }


}
