package chapter8;

import java.util.Collection;
import java.util.Set;

/**
 * InstrumentedSet 类被称为包装类，因为每个 InstrumentedSet 实例都包含（“包装”）另一 个 Set 实例。
 * 这也被称为装饰器模式，因为InstrumentedSet 类通过添加计数功能来“装饰”一个集合。
 * @author karl xie
 */
public class InstrumentedSet<E> extends ForwardingSet<E> {
    private int addCount = 0;

    public InstrumentedSet(Set<E> s) {
        super(s);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}