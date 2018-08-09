package reviewAlgorithms.DynamicProgramming;

import java.util.Scanner;

/**
 * Created by andy on 2018/8/9.
 * 给定一个有n个正整数的数组A和一个整数sum,求选择数组A中部分数字和为sum的方案数。
 当两种选取方案有一个数字的下标不一样,我们就认为是不同的组成方案。
 输入为两行:
 第一行为两个正整数n(1 ≤ n ≤ 1000)，sum(1 ≤ sum ≤ 1000)
 第二行为n个正整数A[i](32位整数)，以空格隔开。

 输入
 5 15 5 5 10 2 3

 输出
 4
 */
public class MethodsForSum {
    public static long numberOfMethods(int n, int sum, int[] A) {
        //用一个数组存储状态
        long [][] dp = new long [n + 1][sum + 1];

        //初始化，当和为0的时候，方案只有一个：一个数字都不选
        for (int i=0;i<=n;i++) {
            dp[i][0] = 1;
        }

        for (int i=1;i<=n;i++) {

            for (int j=1;j<=sum;j++) {
                if (j >= A[i-1]) {
                    dp[i][j] = dp[i - 1][j - A[i-1]] + dp[i - 1][j];
                } else {
                    dp[i][j]=dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        /*int[] a = {5, 5, 10, 2, 3};
        int sum = 15;
        int n = 5;*/
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = scanner.nextInt();
        int[] a = new int[n];
        for (int i=0;i<n;i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(numberOfMethods(n, sum, a));
    }
}
