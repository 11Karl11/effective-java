package chapter4.two;

import chapter4.one.EmailService;
import chapter4.one.MessageService;

import java.util.function.Supplier;

/**
 * 使用 Supplier<T> 来实现依赖注入可以提供额外的灵活性，特别是在需要延迟创建依赖或每次需要依赖时都创建新实例的场景中。
 * 以下是一个使用 Supplier<T> 实现依赖注入的简单例子，我们将继续使用消息服务的场景，但这次我们将允许 Application 类在需要时通过 Supplier 来获取 MessageService 的新实例。
 * @author karl xie
 *
 */
public class Main {
    public static void main(String[] args) {
        // 创建一个 Supplier<MessageService>，每次调用 get() 都会产生一个新的 EmailService 实例
        //Supplier<MessageService> emailServiceSupplier = () -> new EmailService();

        // 将 Supplier 注入到 Application 中
        // Application app = new Application(emailServiceSupplier);
        Supplier<MessageService> serviceSupplier = () -> new EmailService();
        Application app = new Application(EmailService::new);
        // 使用 Application 发送消息
        app.processMessages("Hello, Jane", "jane@example.com");
    }
}
