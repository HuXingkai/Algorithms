package chapter21;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by andy on 2017/5/3.
 */
public class LiftOff implements Runnable {
    protected int countDown=10;
    private static int taskCount=0;
    private final int id=taskCount++;

    ArrayList<String> textList=new ArrayList<>();
    public LiftOff() {}

    public LiftOff(int countDown) {
        this.countDown=countDown;
    }
    public String status(){
        return "#"+id+"("+(countDown>0?countDown:"LiftOff")+"),";
    }
    @Override
    public void run() {
        while (countDown-- > 0) {
            //加入一个数组越界异常
            /*if (countDown == 5) {
                int[] array=new int[2];
                array[3]=1;
            }*/
            System.out.print(status());
            try {
                TimeUnit.MICROSECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread.yield();
        }
    }
}
