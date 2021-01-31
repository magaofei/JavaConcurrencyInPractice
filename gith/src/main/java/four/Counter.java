package four;

/**
 * 4.1
 * Java监视器模式的线程安全计数器
 */
public class Counter {

    private long value = 0;

    public synchronized long getValue() {
        return value;
    }

    public synchronized long increment() {
        if (value == Long.MAX_VALUE) {
            throw new IllegalStateException("counter overflow");
        }
        return ++value;
    }
}
