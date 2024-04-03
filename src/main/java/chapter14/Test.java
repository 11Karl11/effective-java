package chapter14;

import java.util.function.UnaryOperator;

/**
 * @author karl xie
 */
public class Test {

    private static UnaryOperator<Object> IDENTITY_FN = (t) -> t;

    public static <T> UnaryOperator<T> identityFunction() {
        return (UnaryOperator<T>) IDENTITY_FN;
    }

    public static void main(String[] args) {
        String[] strings = {"jute", "hemp", "nylon"};

        UnaryOperator<String> sameString = identityFunction();

        for (String s : strings) {
            System.out.println(sameString.apply(s));
        }

        Number[] numbers = {1, 2.0, 3L};

        UnaryOperator<Number> sameNumber = identityFunction();

        for (Number n : numbers) {
            System.out.println(sameNumber.apply(n));
        }
    }

}