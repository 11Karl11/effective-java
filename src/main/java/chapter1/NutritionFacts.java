package chapter1;

/**
 * 不可变性
 * NutritionFacts类是不可变的，意味着一旦创建了NutritionFacts对象，其状态（对象中的数据）就不能被改变。在这个类中，
 * 所有的属性都被声明为private final，这意味着这些属性只能在对象构造时被赋值一次，之后就不可更改了。不可变对象的好处包括简化并发编程、保证线程安全、减少错误等。
 *
 * 集中的默认参数值设置
 * 在Builder内部类中，除了必需的servingSize和servings参数外，其他参数如calories、fat、sodium和carbohydrate都被初始化为默认值（在这个例子中是0）。
 * 这意味着如果在构建NutritionFacts对象时没有特别指定这些参数，它们就会自动采用这些默认值。
 *
 * 这种方法的优点是：
 * 集中管理默认值：所有的默认值都在Builder类的声明处集中管理，这使得维护和查看默认值变得容易，也保证了默认值的一致性。
 * 增强可读性和易用性：通过Builder模式，创建对象时只需指定需要的参数，对于其他参数可以省略，这使得代码更加清晰和易于理解。同时，这种方式也支持链式调用，进一步提高了代码的可读性。
 * @author karl xie
 * Created on 2024-03-19 16:06
 */
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        private final int servingSize;
        private final int servings;
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }


        public NutritionFacts build() {
            return new NutritionFacts(this);
        }

    }

    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

}

