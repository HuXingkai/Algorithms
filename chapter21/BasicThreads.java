package chapter21;

/**
 * Created by andy on 2017/5/3.
 */
public class BasicThreads {
    public static void main(String args[]) {
//        Thread thread = new Thread(new LiftOff());
//        thread.start();
//        System.out.print("Waiting for LiftOff!");
        for (int i=0;i<5;i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff!");
    }
}
