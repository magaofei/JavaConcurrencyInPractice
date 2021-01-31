package self;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class ThreadPool {

    private static final Logger logger = Logger.getLogger(ThreadPool.class.getName());

    private static final ThreadPoolExecutor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(
            10, 10, 0, TimeUnit.MINUTES, new LinkedBlockingQueue<>()
    );


    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(1);
        
        for (int i = 0; i < 10; i++) {
            THREAD_POOL_EXECUTOR.execute(()-> {
                synchronized (atomicInteger) {
                    atomicInteger.incrementAndGet();
                    logger.info("atomic = " + atomicInteger.get());
                }


            });
        }

    }
}
