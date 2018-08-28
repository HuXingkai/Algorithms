package BFS;

import java.util.*;

/**
 * Created by andy on 2018/8/28.
 * 链接：https://www.nowcoder.com/questionTerminal/4284c8f466814870bae7799a07d49ec8
 来源：牛客网

 * 题目描述
 * 小易来到了一条石板路前，每块石板上从1挨着编号为：1、2、3.......
 * 这条石板路要根据特殊的规则才能前进：对于小易当前所在的编号为K的 石板，
 * 小易单次只能往前跳K的一个约数(不含1和K)步，即跳到K+X(X为K的一个非1和本身的约数)的位置。
 * 小易当前处在编号为N的石板，他想跳到编号恰好为M的石板去，小易想知道最少需要跳跃几次可以到达。
 *
 * 例如：
 * N = 4，M = 24：
 * 4->6->8->12->18->24
 * 于是小易最少需要跳跃5次，就可以从4号石板跳到24号石板
 * 输入描述:
 * 输入为一行，有两个整数N，M，以空格隔开。 (4 ≤ N ≤ 100000) (N ≤ M ≤ 100000)

 * 输出描述:输出小易最少需要跳跃的步数,如果不能到达输出-1
 * 示例
 *      输入4 24
 *      输出5
 *
 *下面的算法是广度优先遍历，时间复杂度太高，超时
 */
public class JumpYi {
    public static Set<Integer> yueshu(int n) {
        Set<Integer> yueshu = new HashSet<>();
        for (int i=2;i<=n/2;i++) {
            if (n % i == 0&&!yueshu.contains(i)) {
                yueshu.add(i);
                if (!yueshu.contains(n / i)) {
                    yueshu.add(n / i);
                }
            }
        }
        return yueshu;
    }


    /*思路 从m 到n 至少需要多少步
    * mark[i]记录到达位置i的最少步数。初始化mark[],起始位置mark[m]为0外，其它位置都为无穷大
    * i~[m,n-2]依次更新mark[]:
    * 判断，如果mark[i]为无穷大，则说明该位置不可由m到达，那么该位置也就到不了n。跳过，不作处理。减枝。
    * 如果mark[i]不是无穷大，计算i的因子，对每一个因子求出i的下一步的位置tmp，如果mark[tmp]>mark[i]+1，更新mark[tmp]=mark[i]+1;
    * 最终结果是mark[n],如果mark[n]是无穷大，则输出-1；否则返回mark[n]。
    */
    /*
    * 比如以8开始 mark[8]=0,8的因子list={2,4},
    * factor=2,可到达10,mark[10]原本是无穷大,现在更新mark[10]=mark[8]+1;12同理。
    * 循环下一个i=9，mark[9]是无穷大，跳过，不用处理。
    * 也就是由8产生10和12，接下来就处理10,12及其产生的位置，而无需处理其他。
*/
    public static int deal(int n, int m) {
        int[] step = new int[m + 1];
        step[n] = 0;
        for (int i=n+1;i<=m;i++) {
            step[i] = Integer.MAX_VALUE;
        }

        for (int i=n;i<=m;i++) {
            if (step[i] == Integer.MAX_VALUE) {
                continue;
            }
            List<Integer> list = getAppNums(i);
            for (int a : list) {
                if (i + a <= m) {
                    step[i + a] = Math.min(step[i + a], step[i] + 1);
                }
            }
        }
        if (step[m] != Integer.MAX_VALUE) {
            return step[m];
        }
        else return -1;
    }
    public static ArrayList<Integer> getAppNums(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                list.add(i);
                if (n / i != i) {
                    list.add(n / i);
                }
            }
        }
        return list;
    }

//下面的算法是广度优先遍历，时间复杂度太高，超时
    public static int bfs(int N, int M) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        int[] visited = new int[M+1];
        visited[N] = 1;
        int count = 1;
        int length=0;
        while (!queue.isEmpty()) {
            int K = queue.poll();
            count--;
            if (K == M) {
                return length;
            }
            Set<Integer> yueshus = yueshu(K);
            for (int a : yueshus) {
                if (K + a <= M && visited[K + a] == 0) {
                    queue.add(K + a);
                }
            }

            if (count == 0) {
                length++;
                count = queue.size();
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        //System.out.println(yueshu(m).size());
        System.out.println(bfs(n,m));
        System.out.println(deal(n, m));
    }
}
