package alibabaTextOnline;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by andy on 2017/7/7.
 * 按照预先配置的百分比将内存分配给相应的任务，具体实现为模拟一个队列，按比例实现出队操作。
 */
public class ManagedQueue {
    private List<UserTask> taskList = new ArrayList<>();
    //定义一个数组，用于记录入队的任务userid
    private int[] array = new int[3];

    public void Enqueue(UserTask userTask) {
        taskList.add(userTask);
        array[(int) userTask.getUserId()-1]+=1;

    }
    public UserTask Dequeue() {

        long userid=realDistri();
        if (userid == -1) {
            return null;
        }
        for (UserTask u : taskList) {
            if (u.getUserId() == userid) {
                taskList.remove(u);
                array[(int) u.getUserId()-1]-=1;
                return u;
            }
        }
        return null;
    }

    //按照用户实际的访问情况，分配资源
    public long realDistri() {
        if (array[0] != 0 && (array[1] != 0 && (array[2] != 0))) {
            return distribution();
        } else if (array[0] == 0 && (array[1] != 0 && (array[2] != 0))) {
            return user23();
        } else if (array[0] != 0 && (array[1] == 0 && (array[2] != 0))) {
            return user13();
        } else if (array[0] != 0 && (array[1] != 0 && (array[2] == 0))) {
            return user12();
        } else if (array[0] == 0 && (array[1] == 0 && (array[2] != 0)   )) {
            return 3;
        } else if (array[0] == 0 && (array[1] != 0 && (array[2] == 0))) {
            return 2;
        } else if (array[0] != 0 && (array[1] == 0 && (array[2] == 0))) {
            return 1;
        }else return -1;
    }
    //按照对应的分配比，分配任务出队的概率
    public long distribution() {
        int num = new Random().nextInt(10);
        if (num < 2) {
            return 1;
        } else if (num < 5) {
            return 2;
        } else return 3;
    }
    public long user12() {
        int num = new Random().nextInt(5);
        if (num < 2) {
            return 1;
        }else return 2;
    }
    public long user13() {
        int num = new Random().nextInt(7);
        if (num < 2) {
            return 1;
        }else return 3;
    }
    public long user23() {
        int num = new Random().nextInt(8);
        if (num < 3) {
            return 2;
        }else return 3;
    }


    public static void main(String[] args) {
        List<UserTask> list=new ArrayList<>();
        ManagedQueue managedQueue=new ManagedQueue();
        for (int i=0;i<1000;i++) {
            UserTask userTask=new UserTask();
            userTask.setUserId(1);
            userTask.setTask("user1task" + i);
            managedQueue.Enqueue(userTask);
        }
        for (int i=0;i<1000;i++) {
            UserTask userTask=new UserTask();
            userTask.setUserId(2);
            userTask.setTask("user2task" + i);
            managedQueue.Enqueue(userTask);
        }
        for (int i=0;i<1000;i++) {
            UserTask userTask=new UserTask();
            userTask.setUserId(3);
            userTask.setTask("user3task" + i);
            managedQueue.Enqueue(userTask);
        }
        int user1=0,user2=0,user3=0;
        for (int i=0;i<1000;i++) {
            long id=managedQueue.Dequeue().getUserId();
            if (id == 1) {
                user1+=1;
            }
            if (id == 2) {
                user2+=1;
            }
            if (id == 3) {
                user3+=1;
            }
        }
        System.out.println(""+user1+"-"+user2+"-"+user3);

    }
}
