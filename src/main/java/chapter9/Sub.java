package chapter9;

/**
 * @author karl xie
 * Created on 2024-03-26 16:20
 */

import java.time.Instant;

public final class Sub extends Super {
    // 空白final变量，由构造函数设置
    private final Instant instant;

    Sub() {
        instant = Instant.now();
    }

    // 覆盖的方法由超类构造函数调用
    @Override
    public void overrideMe() {
        System.out.println(instant);
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe(); // 第一次调用：打印null  第二次调用：将打印instant的初始化时间
    }
}