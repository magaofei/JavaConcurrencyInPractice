package four;

import apple.laf.JRSUIConstants;

/**
 * 4.3
 * 通过一个私有锁来保护状态
 */
public class PrivateLock {
    private final Object myLock = new Object();
    Widget widget;

    private class Widget {
    }

    void someMethod() {
        synchronized (myLock) {
            //
        }
    }
}
