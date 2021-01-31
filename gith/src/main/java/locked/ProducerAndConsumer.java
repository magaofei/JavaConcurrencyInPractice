package locked;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;

/**
 * @author magaofei
 * @date 2021/1/30
 */
public class ProducerAndConsumer {
    static final NonReentrantLockDemo.NonReentrantLock lock = new NonReentrantLockDemo.NonReentrantLock();
    static final Condition notFull = lock.newCondition();
    static final Condition notEmpty = lock.newCondition();
    static final Queue<String> queue = new LinkedBlockingQueue<String>();
    static final int queueSize = 10;

    public static void main(String[] args) throws Exception {
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    while (queue.size() == queueSize) {
                        notEmpty.await();
                    }
                    queue.add("ele");
                    notFull.signalAll();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    while (0 == queue.size()) {
                        notFull.await();
                    }
                    String ele = queue.poll();
                    System.out.println("consumer " + ele);
                    notEmpty.signalAll();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        producer.start();
        consumer.start();

        Thread.sleep(10000);

    }
}
