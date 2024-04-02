package chapter12.adv1;

import java.util.Collection;

/**
 * @author karl xie
 */
public class Chooser<T> {

    private final T[] choiceArray;

    public Chooser(Collection<T> choices) {
        choiceArray = (T[]) choices.toArray();
    }

    // choose method unchanged

}