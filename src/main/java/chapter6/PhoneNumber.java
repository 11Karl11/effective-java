package chapter6;

import java.util.Comparator;


/**
 * @author karl xie
 */
public class PhoneNumber implements Comparable<PhoneNumber> {
    private int areaCode;
    private int prefix;
    private int lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public int getPrefix() {
        return prefix;
    }

    public int getLineNum() {
        return lineNum;
    }

    @Override
    public int compareTo(PhoneNumber pn) {
        return Comparator.comparingInt(PhoneNumber::getAreaCode)
                .thenComparingInt(PhoneNumber::getPrefix)
                .thenComparingInt(PhoneNumber::getLineNum)
                .compare(this, pn);
    }

    public static void main(String[] args) {
        PhoneNumber pn1 = new PhoneNumber(123, 456, 7890);
        PhoneNumber pn2 = new PhoneNumber(456, 789, 1234);

        System.out.println("Comparing pn1 and pn2: " + pn1.compareTo(pn2));
    }
}
