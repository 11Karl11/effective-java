package chapter11;

import java.util.ArrayList;
import java.util.List;

/**
 * 实际上，如果运行该程序，则当程序尝试调用 strings.get(0) 的结果（一个Integer ）转换为一个 String 时，会得到 ClassCastException 异常。
 * @author karl xie
 */
public class Main {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf(42));
        String s = strings.get(0);
    }

    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }
}