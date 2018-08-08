package KnapSack;

import java.util.Scanner;

/**
 * 01背包问题的变形
 * Created by andy on 2018/8/8.
 * 链接：https://www.nowcoder.com/questionTerminal/9ba85699e2824bc29166c92561da77fa
 来源：牛客网

 一种双核CPU的两个核能够同时的处理任务，现在有n个已知数据量的任务需要交给CPU处理，假设已知CPU的每个核1秒可以处理1kb，
 每个核同时只能处理一项任务。n个任务可以按照任意顺序放入CPU进行处理，现在需要设计一个方案让CPU处理完这批任务所需的时间最少，
 求这个最小的时间。

 思路：共有两个cpu，如果想让时间最少，即要使得max(cpu_time1, cpu_time2)最小，设所有任务的时间和为sum，
 那么至少需要sum/2的时间处理所有任务。因此如果能让两个cpu处理时间都接近于sum/2就能的到最优解。此时就转化为体积为sum/2，
 共有n个物体，代价为t[i]，价值也是t[i]，尽量多的装即可。

 此处需要提一下，由于可能sum很大，需要利用题目给出的“每个数都是1024的倍数”，将数字全部除以1024.

 */
public class twoCPU_01Knap {
    public int process(int n, int[] length,int sum) {
        int[] dp = new int[sum/2+1];
        for (int i=1;i<=n;i++) {
            for (int j=sum/2;j>0;j--) {
                if (j >= length[i-1] && dp[j - length[i-1]] + length[i-1] > dp[j]) {
                    dp[j] = dp[j - length[i-1]] + length[i-1];
                }
            }
        }
        //由于sum/2之后，小数部分被自动截掉，因此dp[sum / 2]不一定是最大值，需要判断一下
        return (dp[sum / 2]>sum-dp[sum / 2]?dp[sum / 2]:sum-dp[sum / 2])*1024;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] length = new int[n];
        int sum=0;
        for (int i=0;i<n;i++) {
            //这里很关键，大大降低了时间复杂度。
            length[i] = scanner.nextInt()/1024;
            sum += length[i];
        }
        twoCPU_01Knap t = new twoCPU_01Knap();
        System.out.println(t.process(n, length,sum));
    }
}
