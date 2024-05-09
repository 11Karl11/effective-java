package chapter27;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * name 方法在 Wine 类中声明，并在子类 SparklingWine 和 Champagne 中重写。正如你所 料，此程序打印出 wine，sparkling wine 和 champagne，
 * 即使实例的编译时类型在循环的每次迭代中都是 Wine 。 当调用重写方法时，对象的编译时类型对执行哪个方法没有影响;
 * 总是会执行“最具体 (mostspecific)”的重写方法。 将此与重载进行比较，其中对象的运行时类型对执行的重载没有影响; 选择是在编译时完成的，完全基于参数的编译时类型。
 * @author karl xie
 */
class Wine {
    String name() {
        return "wine";
    }
}

class SparklingWine extends Wine {
    @Override
    String name() {
        return "sparkling wine";
    }
}

class Champagne extends SparklingWine {
    @Override
    String name() {
        return "champagne";
    }
}

class Overriding {
    public static void main(String[] args) {
        List<Wine> wineList = Lists.newArrayList(
                new Wine(), new SparklingWine(), new Champagne()
        );

        for (Wine wine : wineList)
            System.out.println(wine.name());


        /**
         * 虽然 Thread 构造方法调用和 submit 方法调用看起来很相似，但是前者编译而后者不编译。参数是相同的 ( System.out::println )，
         * 两者都有一个带有 Runnable 的重载。这里发生了什么?令人惊讶的答案是， submit 方法有一个带有 Callable <T> 参数的重载，而 Thread 构造方法却没有。
         * 你可能认为这不会有什么区别，因为 println 方法的所有重载都会返回 void ，因此方法引用不可能是 Callable 。这很有道理，但重载解析算法不是这样工作的。
         * 也许同样令人惊讶的是，如果println 方法没有被重载，那么 submit 方法调用是合法的。正是被引用的方法（println）的重载和被调用的方法（submit）相结合，阻止了重载解析算法按照你所期望的方式运行。
         */
        new Thread(System.out::println).start();

        ExecutorService exec = Executors.newCachedThreadPool();
        // exec.submit(System.out::println);
    }


}