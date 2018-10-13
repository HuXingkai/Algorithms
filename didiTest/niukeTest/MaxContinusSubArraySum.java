package didiTest.niukeTest;

        import java.util.Arrays;
        import java.util.Scanner;

/**
 * Created by andy on 2018/9/18.
 * 一个数组有 N 个元素，求连续子数组的最大和。 例如：[-1,2,1]，和最大的连续子数组为[2,1]，其和为 3
 输入描述:
 输入为两行。 第一行一个整数n(1 <= n <= 100000)，表示一共有n个元素 第二行为n个数，即每个元素,每个整数都在32位int范围内。以空格分隔。


 输出描述:
 所有连续子数组中和最大的值。

 输入例子1:
 3 -1 2 1

 输出例子1:
 3
 */
public class MaxContinusSubArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(findDP(arr));
    }

    //数组太大，超内存了
    public static int findSum(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        int max=Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++) {
            dp[i][1] = arr[i];
            if (dp[i][1]>max) max = dp[i][1];
        }
        for (int k=2;k<arr.length;k++) {
            for (int i=0;i<=arr.length-k;i++) {
                dp[i][k] = dp[i][k - 1] + arr[i+k-1];
                if (dp[i][k]>max) max = dp[i][k];
            }
        }
        return max;
    }

    //改为用一个动态数组存储，但也超时了
    public static int find1(int[] arr) {
        int[] sum = new int[arr.length];
        int max=Integer.MIN_VALUE;
        for (int k=1;k<arr.length;k++) {
            for (int i=0;i<=arr.length-k;i++) {
                sum[i] = sum[i] + arr[i + k - 1];
                if (sum[i]>max) max = sum[i];
            }
        }
        return max;
    }

    //分治算法，详见：MaxSubArrayConquer

    //真正的动态规划

    /**
     *
     该题目思路:
     dp[i]表示以元素array[i]结尾的最大连续子数组和.
     以[-2,-3,4,-1,-2,1,5,-3]为例
     可以发现,
     dp[0] = -2
     dp[1] = -3
     dp[2] = 4
     dp[3] = 3
     以此类推,会发现
     dp[i] = max{dp[i-1]+array[i],array[i]}.
     * @param arr
     * @return
     */
    public static int findDP(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for (int i=1;i<arr.length;i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
        }
        Arrays.sort(dp);
        return dp[arr.length - 1];
    }
}
