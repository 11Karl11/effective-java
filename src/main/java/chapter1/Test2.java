package chapter1;

import static chapter1.NyPizza.Size.SMALL;
import static chapter1.Pizza.Topping.*;

/**
 * @author karl xie
 *
 */
public class Test2 {
    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(SMALL).addTopping(SAUSAGE).addTopping(ONION).build();

        Calzone calzone = new Calzone.Builder().addTopping(HAM).sauceInside().build();



    }
}