package chapter4.two;

/**
 * @author karl xie
 */

import chapter4.one.EmailService;
import chapter4.one.MessageService;

import java.util.function.Supplier;

public class Application {
    private Supplier<MessageService> messageServiceSupplier;

    // 通过构造器注入依赖的 Supplier
    public Application(Supplier<MessageService> serviceSupplier) {
        this.messageServiceSupplier = serviceSupplier;
    }

    public void processMessages(String message, String receiver) {
        // 从 Supplier 获取 MessageService 的新实例并使用它
        MessageService messageService = messageServiceSupplier.get();
        messageService.sendMessage(message, receiver);
    }
}
