package chapter19;

import java.util.EnumSet;
import java.util.Set;

/**
 * @author karl xie
 */
public class Text {
    // 定义一个枚举类型，用于表示文本的不同样式
    public enum Style {
        BOLD, ITALIC, UNDERLINE, STRIKETHROUGH
    }

    // 这个方法接受一个 Set 集合，其中包含 Style 枚举的实例
    // EnumSet 是最佳选择，因为它为枚举类型提供了高效的集合实现
    public void applyStyles(Set<Style> styles) {
        // 在这里实现应用这些样式到文本的逻辑
        // ...
    }

    public static void main(String[] args) {

    // 这里是客户端代码，演示了如何创建 EnumSet 实例并传递给 applyStyles 方法
        Text text = new Text();
        text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));

    // EnumSet.of 方法是一个静态工厂方法，用于创建包含指定枚举元素的 EnumSet
    // 你可以传递一个或多个枚举常量，来创建一个包含这些常量的 EnumSet
    }

}

