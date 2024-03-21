package chapter5;

import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * 监听器和回调确实是内存泄漏的一个常见来源，特别是在事件驱动的编程或者使用观察者模式的场合。当一个对象注册为另一个对象的监听器或回调时，
 * 如果不正确地管理生命周期，就可能会导致内存泄漏。这是因为即使客户端不再需要监听事件，但只要回调注册存在，垃圾收集器就无法回收这个回调对象，因为它仍然被事件源所引用。
 *
 * 使用弱引用防止内存泄漏
 * 使用弱引用（WeakReference）来引用回调或监听器是一种避免内存泄漏的有效方法。这样，即使回调或监听器仍然被事件源引用，垃圾收集器也可以回收这些对象，
 * 只要没有其他强引用指向它们。WeakHashMap 是实现这一点的一个好工具，它可以用来存储回调或监听器的弱引用，如此一来，一旦回调或监听器不再被其他对象引用，它们就可以被自动清理。
 * 在这个示例中，EventListener 的实例作为 WeakHashMap 的键存储。这意味着，如果外部对 EventListener 的唯一引用消失了，
 * 垃圾收集器可以自由地回收这个监听器对象，即使它仍然注册在EventBroadcaster中。
 *
 * 注意事项
 * 使用弱引用时，需要注意确保你的应用逻辑不会意外地使监听器过早地被垃圾回收。例如，如果客户端只持有监听器的弱引用，那么监听器可能在它还应该接收事件的时候就被回收了。
 * 对于需要长时间存活的监听器，或者其生命周期应该与另一个对象（如用户界面组件）紧密绑定的监听器，可能需要采取其他策略来管理它们的注册和注销。
 * @author karl xie
 */
public class EventBroadcaster {
    private final Map<EventListener, Boolean> listeners = new WeakHashMap<>();

    public void addListener(EventListener listener) {
        listeners.put(listener, Boolean.TRUE);
    }

    public void broadcastEvent(Event event) {
        for (EventListener listener : listeners.keySet()) {
            listener.handleEvent(event);
        }
    }
}
