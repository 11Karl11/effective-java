package chapter2;

import java.util.function.Supplier;

/**
 * @author karl xie
 * Created on 2024-03-20 10:04
 */
public class Test {

    public static void main(String[] args) {
        /**
         * 这种方法引用特别有用，例如，在需要延迟对象创建或者使用依赖注入框架时，你可以将Elvis::getInstance作为一个提供者传递。
         * 这样，对象的创建被封装在Elvis类的getInstance方法内，而使用者不需要知道对象是如何被创建的，只需要知道如何获取它。
         */
        Supplier<Elvis> elvisSupplier = Elvis::getInstance;
        Elvis elvis = elvisSupplier.get();
        elvis.leaveTheBuilding();
    }
}