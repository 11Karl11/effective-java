package chapter19;

import java.util.Set;

/**
 * @author karl xie
 */
class Worker {
    String name;
    Set<Day> availableDays;

    public Worker(String name, Set<Day> availableDays) {
        this.name = name;
        this.availableDays = availableDays;
    }

    public String getName() {
        return name;
    }

    public Set<Day> getAvailableDays() {
        return availableDays;
    }
}