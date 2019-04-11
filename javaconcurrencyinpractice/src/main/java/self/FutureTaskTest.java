package self;

import java.util.concurrent.*;

public class FutureTaskTest {

    public static void main(String[] args) {

//        CompletionService completionService = new ExecutorCompletionService();
        Exchanger exchanger = new Exchanger();
        FutureTask futureTask = new FutureTask( ()-> {
            return 1;
        });
    }
}
