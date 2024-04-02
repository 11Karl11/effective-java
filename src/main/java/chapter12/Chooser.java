package chapter12;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 要使用这个类，每次调用方法时，都必须将 choose 方法的返回值从 Object 转换为所需的类型，如果类型错误，则转换在运行时失败.
 *
 * @author karl xie
 */

public class Chooser {

    private final Object[] choiceArray;

    public Chooser(Collection choices) {
        choiceArray = choices.toArray();
    }

    public Object choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceArray[rnd.nextInt(choiceArray.length)];
    }
}