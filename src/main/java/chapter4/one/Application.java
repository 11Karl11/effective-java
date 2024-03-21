package chapter4.one;

/**
 * 在这个例子中，Application 类不需要知道 MessageService 是如何实现的，也不需要知道它是如何被创建的。
 * 它只需要知道 MessageService 提供了 sendMessage 方法。这就是依赖注入的核心思想：
 * 依赖项（在这个例子中是 MessageService）被注入到使用它的类（Application）中，而不是由使用它的类自己创建。
 * 这样做的好处是提高了代码的可测试性和可重用性，并降低了耦合度。
 *
 * 这个例子展示了构造器注入的方式，但依赖注入还可以通过设置方法（setter 方法）或者接口实现来完成。选择哪种方式取决于具体的应用场景和个人偏好。
 * @author karl xie
 *
 */
public class Application {
    private MessageService messageService;

    // 通过构造器注入依赖
    public Application(MessageService service) {
        this.messageService = service;
    }

    public void processMessages(String message, String receiver) {
        // 使用 messageService 发送消息
        this.messageService.sendMessage(message, receiver);
    }
}
