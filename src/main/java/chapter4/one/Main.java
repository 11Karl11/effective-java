package chapter4.one;

/**
 * @author karl xie
 *
 */
public class Main {
    public static void main(String[] args) {
        // 创建 EmailService 实例
        MessageService emailService = new EmailService();

        // 将 EmailService 实例注入到 Application 中
        Application app = new Application(emailService);

        // 使用 Application 发送消息
        app.processMessages("Hi, John", "john@example.com");
    }
}
