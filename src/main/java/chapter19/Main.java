package chapter19;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

/**
 * @author karl xie
 */
public class Main {

    public static void main(String[] args) {
        Worker[] workers = new Worker[]{
                new Worker("张三", EnumSet.of(
                        Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY, Day.FRIDAY)),
                new Worker("李四", EnumSet.of(
                        Day.TUESDAY, Day.THURSDAY, Day.SATURDAY)),
                new Worker("王五", EnumSet.of(
                        Day.TUESDAY, Day.THURSDAY)),
        };


        //哪些天一个人都不会来？
        Set<Day> days = EnumSet.allOf(Day.class);
        for(Worker w : workers){
            days.removeAll(w.getAvailableDays());
        }
        System.out.println(days);

        //有哪些天所有人都会来？就是求worker时间的交集，
        Set<Day> days1 = EnumSet.allOf(Day.class);
        for(Worker w : workers){
            days1.retainAll(w.getAvailableDays());
        }
        System.out.println(days1);

        //哪些天至少会有两个人来？
        Map<Day, Integer> countMap = new EnumMap<>(Day.class);
        for(Worker w : workers){
            for(Day d : w.getAvailableDays()){
                Integer count = countMap.get(d);
                countMap.put(d, count==null?1:count+1);
            }
        }
        Set<Day> days2 = EnumSet.noneOf(Day.class);
        for(Map.Entry<Day, Integer> entry : countMap.entrySet()){
            if(entry.getValue()>=2){
                days2.add(entry.getKey());
            }
        }
        System.out.println(days2);


    }
}