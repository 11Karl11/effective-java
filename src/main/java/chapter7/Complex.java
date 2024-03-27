package chapter7;

/**
 * 这个Complex类是一个不可变类，用于表示复数。复数是一个可以表达为a + bi形式的数，其中a是实部，b是虚部，i是虚数单位。
 *
 * 不可变性：通过将字段声明为final并且只提供读取这些字段的方法（没有设置方法），这个类确保了一旦Complex对象被创建，它的状态就不能被改变。
 *
 * 操作方法：类提供了加（plus）、减（minus）、乘（times）和除（dividedBy）等方法来进行复数之间的算术运算。这些方法都返回一个新的Complex对象，而不是修改现有对象，符合不可变对象的设计原则。
 *
 * equals和hashCode方法：为了确保Complex对象可以正确地用于HashSet、HashMap等集合，重写了equals和hashCode方法。equals方法用于判断两个Complex对象是否相等，而hashCode方法返回对象的哈希码。
 *
 * toString方法：重写toString方法以提供Complex对象的字符串表示形式，便于打印和日志记录。
 *
 * 这个类是复数运算的一个良好示例，展示了如何实现一个不可变类，并提供了一组丰富的操作方法来与其他对象进行交互。
 * @author karl xie
 */
public final class Complex {
    private final double re;
    private final double im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double realPart() {
        return re;
    }

    public double imaginaryPart() {
        return im;
    }

    public Complex plus(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }

    public Complex minus(Complex c) {
        return new Complex(re - c.re, im - c.im);
    }

    public Complex times(Complex c) {
        return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
    }

    public Complex dividedBy(Complex c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new Complex((re * c.re + im * c.im) / tmp, (im * c.re - re * c.im) / tmp);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Complex)) {
            return false;
        }
        Complex c = (Complex) o;
        return Double.compare(c.re, re) == 0 && Double.compare(c.im, im) == 0;
    }

    @Override
    public int hashCode() {
        return 31 * Double.hashCode(re) + Double.hashCode(im);
    }

    @Override
    public String toString() {
        return "(" + re + " + " + im + "i)";
    }
}