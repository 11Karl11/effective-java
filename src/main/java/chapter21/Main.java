package chapter21;

/**
 * - `T`必须是一个枚举（`Enum`），即`T`继承自`Enum<T>`。这是通过`T extends Enum<T>`来指定的，意味着`T`必须是枚举类型的一个实例。
 * - 同时，`T`必须实现了`Operation`接口。这是通过`& Operation`来指定的，表明`T`不仅需要是一个枚举，还需要实现特定的接口。
 *
 * 这种类型约束的语法`<T extends B1 & B2 & B3...>`允许你指定`T`必须是继承自`B1`的类型，并且实现了`B2`、`B3`等接口。
 * 这里的`B1`必须是类或枚举类型（在这个案例中是`Enum`），而`B2`、`B3`等必须是接口。如果有多个界限，类或枚举类型只能有一个，并且必须放在第一位，接口类型可以有多个。
 *
 * 在这个特定的例子中，`<T extends Enum<T> & Operation>`的意思是：
 *
 * - 你可以将任何继承自`Enum`的枚举类型`T`传递给这个泛型方法，但这个枚举`T`还必须实现`Operation`接口。
 * - 这样做的好处是提高了泛型方法的灵活性和类型安全。你可以确保传递给方法的类型既有枚举的特性（比如可以使用`values()`方法遍历所有枚举常量），又能作为`Operation`使用（即可以调用`apply`方法）。
 *
 * 这种泛型约束在设计需要类型安全且具有特定行为的代码时非常有用，特别是在你希望方法或类能够接受多种类型的参数，但这些类型之间存在一些共同的行为或特性时。
 * @author karl xie
 */
public class Main {
    public static void main(String[] args) {
        double x = 1.0;
        double y = 2.0;
        test(BasicOperation.class, x, y);
    }

    private static <T extends Enum<T> & Operation> void test(Class<T> opEnumType, double x, double y) {
        for (Operation op : opEnumType.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n",
                    x, op, y, op.apply(x, y));
        }
    }
}