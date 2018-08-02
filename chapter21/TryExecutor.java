package chapter21;

import java.util.concurrent.*;

/**
 * Created by andy on 2017/5/3.
 */
public class TryExecutor {
    public static void main(String args[]) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0;i<5;i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }
}
