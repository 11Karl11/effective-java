package chapter24;

/**
 * 在这个例子中,我们使用 Transportable 接口来标记哪些类可以在网络上传输。TransportService 的 sendObject 方法只接受 Transportable 对象,所以如果我们尝试传递一个没有实现 Transportable 的对象(如 User),编译器会给出错误。
 *
 * 这展示了标记接口的主要优势:它允许我们在编译时检测错误,而不是在运行时。如果我们没有使用标记接口,而是在 sendObject 方法中使用 Object 类型的参数,那么编译器就无法检测到我们传递了一个不适合传输的对象,我们可能会在运行时得到一个意外的错误。
 *
 * 这个例子虽然简单,但它说明了标记接口如何通过利用 Java 的类型系统来提供额外的安全性和错误检测。在实际应用中,标记接口可以用于各种目的,如表示可序列化的对象,表示可克隆的对象等。
 * @author karl xie
 */
public class Main {
    public static void main(String[] args) {
        TransportService transportService = new TransportService();

        Message message = new Message("Hello, world!");
        transportService.sendObject(message);  // 这是可以的,因为 Message 实现了 Transportable

        User user = new User("Alice");
       // transportService.sendObject(user);  // 这会导致编译错误,因为 User 没有实现 Transportable
    }
}