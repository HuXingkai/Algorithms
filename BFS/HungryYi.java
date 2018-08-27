package BFS;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by andy on 2018/8/27.
 * 链接：https://www.nowcoder.com/questionTerminal/5ee8df898312465a95553d82ad8898c3
 来源：牛客网

 小易总是感觉饥饿，所以作为章鱼的小易经常出去寻找贝壳吃。最开始小易在一个初始位置x_0。对于小易所处的当前位置x，他只能通过神秘的力量移动到 4 * x + 3或者8 * x + 7。因为使用神秘力量要耗费太多体力，所以它只能使用神秘力量最多100,000次。贝壳总生长在能被1,000,000,007整除的位置(比如：位置0，位置1,000,000,007，位置2,000,000,014等)。小易需要你帮忙计算最少需要使用多少次神秘力量就能吃到贝壳。
 输入描述:
 输入一个初始位置x_0,范围在1到1,000,000,006


 输出描述:
 输出小易最少需要使用神秘力量的次数，如果使用次数使用完还没找到贝壳，则输出-1
 示例1
 输入
 125000000
 输出
 1

 *可以利用广度优先遍历的方法求解，但需要注意，这里面的数值范围太大，即使是long类型，也会超出范围。因此，这里存储的时候，只存了取余后的值
 * 因为可以证明， 4 * x + 3除以p 的余数 == x除以p的余数 乘以4加3.因此每次只保留余数即可。
 */
public class HungryYi {
    /*public static long bfs1(BigInteger pos) {
        Queue<BigInteger> queue = new LinkedList<>();
        Set<BigInteger> visited = new HashSet<>();
        long num = 0;
        long count = 1;
        BigInteger p = new BigInteger("1000000007");
        BigInteger zero = new BigInteger("0");
        BigInteger four = new BigInteger("4");
        BigInteger three = new BigInteger("3");
        BigInteger seven = new BigInteger("7");
        BigInteger eight = new BigInteger("8");

        queue.add(pos);
        //visited.add(pos);
        while (!queue.isEmpty()) {
            count--;
            BigInteger posNow = queue.poll();
            visited.add(posNow);

            BigInteger step1 = posNow.multiply(four).add(three);
            BigInteger step2 = posNow.multiply(eight).add(seven);
            if (step1.mod(p).equals(zero)||step2.mod(p).equals(zero)) {
                return num+1;
            }
            if (!visited.contains(step1)&&!queue.contains(step1)) {
                queue.add(step1);
            }
            if (!visited.contains(step2)&&!queue.contains(step2)) {
                queue.add(step2);
            }

            if (count == 0) {
                num++;
                if (num > 100000) {
                    return -1;
                }
                count = queue.size();
            }
        }
        if (num == 99999) {
            System.out.println(visited.size());
        }
        return -1;
    }*/

    public static long bfs(long pos) {
        Queue<Long> queue = new LinkedList<>();
        Set<Long> visited = new HashSet<>();
        long num = 1;
        long count = 1;
        long p = 1000000007;

        queue.add(pos);
        while (!queue.isEmpty()) {
            count--;
            long posNow = queue.poll();
            //为了减小范围，这里只保存了余数
            visited.add(posNow % p);

            //long step1 = posNow * 4 + 3;
            //long step2 = posNow * 8 + 7;
            if ((posNow * 4 + 3) % p == 0||(posNow * 8 + 7) % p == 0) {
                return num;
            }
            //根据BFS的性质，之前到达的位置的步数一定比之后到达该位置的步数要小，所以相当于每个位置搜索一次就可以了
            //因此队列中已经存在的值，不用再进一步搜索了
            if (!visited.contains((posNow * 4 + 3) % p)&&!queue.contains((posNow * 4 + 3) % p)) {
                queue.add((posNow * 4 + 3) % p);
            }
            if (!visited.contains((posNow * 8 + 7) % p)&&!queue.contains((posNow * 8 + 7) % p)) {
                queue.add((posNow * 8 + 7) % p);
            }

            if (count == 0) {
                num++;
                if (num > 100000) {
                    return -1;
                }
                count = queue.size();
            }
        }
        return -1;
    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/5ee8df898312465a95553d82ad8898c3
     来源：牛客网

     设f(x)=4x+3,g(x)=8x+7。
     计算可以得到以下两个规律：
     （1）  g(f(x))=f(g(x))   即f和g的执行顺序没有影响。

     （2）  f(f(f(x)))=g(g(x))    即做3次f变换等价于做2次g变换

     由于规律（1） 对于一个可行方案，我们可以调整其变换的顺序。如ffggfggff，我们可以转化成 fffffgggg。
     由于规律（2），并且为了使执行次数最少，每3个f我们可以转化成2个g，如方案fffffgggg，可以转化成ffgggggg。
     因此一个最优的策略，f的执行次数只能为0,1,2。对于输入的x，我们只需要求x，4x+3,4（4x+3）+3的最小g执行次数就可以了。


     4x+3和8x+7的数学操作，可以用二进制的左移和补1表示

     y = 4*x+3,相当于x的二进制左移2位，然后空位补1，即原先x的二进制为#####,则y的二进制为#####11，

     y = 8*x+3,相当于y的二进制左移3位，然后空位补1，即原先x的二进制为#####,则y的二进制为#####111
     * @param x
     * @return
     */
    public static int mathMethod(long x) {
        long p = 1000000007;
        int[] answer = new int[3];
        for (int i=2;i>=0;i--) {
            int count = 0;
            long num=x;
            for (int j=i;j>0;j--) {
                num = (num * 4 + 3) % p;
                count++;
                if (num  == 0) {
                    answer[i]=count;
                    break;
                }
            }
            while (true) {
                num = (num * 8 + 7) % p;
                count++;
                if (count > 100000) {
                    answer[i]=-1;
                    break;
                }
                if (num == 0) {
                    answer[i]=count;
                    break;
                }
            }
        }

        Arrays.sort(answer);
        for (int a : answer) {
            if (a > -1) {
                return a;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long pos = scanner.nextLong();
        System.out.println(bfs(pos));
        System.out.println(mathMethod(pos));
    }
}
