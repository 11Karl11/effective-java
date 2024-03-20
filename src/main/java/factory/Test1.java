package factory;

import java.util.ArrayList;

/**
 * 静态工厂方法
 * @author karl xie
 * Created on 2024-03-19 14:49
 */
public class Test1 {

    /**
     * 1、方法见名之意，调用方便
     * 2、每次调用不需要新建对象
     * 3、与构造方法不同，它们可以返回其返回类型的任何子类型的对象
     * 4、返回对象的类可以根据输入参数的不同而不同。 声明的返回类型的任何子类都是允许的。 返回对象的类也可以随每次发布而不同。
     *
     * @param b
     * @return
     */
    public static Boolean valueOf(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(1, 2).carbohydrate(1).build();
    }

}