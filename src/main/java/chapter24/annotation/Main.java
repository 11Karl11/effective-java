package chapter24.annotation;

/**
 * 在这个例子中,我们使用 @Secure 注解来标记需要进行安全性检查的方法。SecurityAspect 类在调用方法之前,使用反射来检查方法是否有 @Secure 注解,如果有,就执行安全性检查。
 *
 * 这展示了标记注解的主要优势:它允许我们在运行时获取关于类、方法、字段等的额外信息。这种信息可以被框架、库或我们自己的代码使用,以实现各种功能,如安全性检查、日志记录、事务管理等。
 *
 * 与标记接口相比,标记注解更加灵活,因为它们可以应用于类、方法、字段等,而不仅仅是类。此外,标记注解可以包含属性,这使得它们能够携带更多的信息。
 *
 * 但是,标记注解也有一个缺点:它们的使用通常依赖于反射,这可能会影响代码的性能。此外,过度使用标记注解可能会使代码变得难以理解和维护。
 *
 * 尽管如此,标记注解仍然是 Java 中非常有用的特性,特别是在开发框架和库时。合理地使用标记注解可以使我们的代码更加灵活、可扩展和可维护。
 * @author karl xie
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BankService bankService = new BankService();
        SecurityAspect securityAspect = new SecurityAspect();

        securityAspect.checkSecurity(bankService, "transferMoney",1000.0);
        securityAspect.checkSecurity(bankService, "checkBalance");
    }
}