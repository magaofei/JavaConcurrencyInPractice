package locked;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author magaofei
 * @date 2021/1/30
 */
public class NonReentrantLockDemo {

    static class NonReentrantLock implements Lock, Serializable {



        private static class Sync extends AbstractQueuedSynchronizer {
            protected boolean isHeldExclusively() {
                return getState() == 1;
            }
            protected boolean tryAcquire(int acquires) {
                assert acquires == 1;
                if (compareAndSetState(0, 1)) {
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
                return false;
            }

            protected boolean tryRelease(int releases) {
                assert releases == 1;
                if (getState() == 0) {
                    throw new IllegalMonitorStateException();
                }
                setExclusiveOwnerThread(null);
                setState(0);
                return true;
            }

            Condition newCondition() {
                return new ConditionObject();
            }

        }

        private final Sync sync = new Sync();

        @Override
        public void lock() {
            sync.acquire(1);
        }

        @Override
        public boolean tryLock() {
            return sync.tryAcquire(1);
        }

        @Override
        public void unlock() {
            sync.release(1);
        }

        @Override
        public Condition newCondition() {
            return sync.newCondition();
        }
        public boolean isLocked() {
            return sync.isHeldExclusively();
        }


        @Override
        public void lockInterruptibly() throws InterruptedException {
            sync.acquireSharedInterruptibly(1);
        }
        @Override
        public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
            return sync.tryAcquireSharedNanos(1, unit.toNanos(time));
        }


    }
    public static void main(String[] args) {

    }
}
