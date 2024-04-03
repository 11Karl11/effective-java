package chapter14;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ScheduledFuture;

/**
 * @author karl xie
 */
public class Main {


    public static void main(String[] args) {
        List<ScheduledFuture<?>> scheduledFutures = new ArrayList<>();
        max(scheduledFutures);
    }

    public static <E extends Comparable<? super E>> E max(Collection<? extends E> c) {
        if (c.isEmpty()) {
            throw new IllegalArgumentException("Empty collection");
        }

        E result = null;

        for (E e : c) {
            if (result == null || e.compareTo(result) > 0) {
                result = Objects.requireNonNull(e);
            }
        }

        return result;
    }


}