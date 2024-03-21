package chapter4.one;

/**
 * @author karl xie
 */
public class EmailService implements MessageService {
    public void sendMessage(String message, String receiver) {
        // 模拟发送邮件
        System.out.println("Email sent to " + receiver + " with message: " + message);
    }
}