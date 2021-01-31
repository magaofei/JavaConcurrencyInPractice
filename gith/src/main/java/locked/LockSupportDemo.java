package locked;

import java.util.concurrent.locks.LockSupport;

/**
 * @author magaofei
 * @date 2021/1/30
 */
public class LockSupportDemo {

    public static void main(String[] args) throws Exception {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("beain park");
                    LockSupport.park();
                }
                System.out.println("child thread unpark");

            }
        });
        thread.start();

        Thread.sleep(1000);

//        LockSupport.unpark(thread);
        thread.interrupt();
        System.out.println("end park");


    }
}
