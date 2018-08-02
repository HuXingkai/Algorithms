package didiTest.NumOfSumMethod;

import java.util.Scanner;

/**
 * http://blog.csdn.net/zhengjihao/article/details/77921617
* */
public class KnapsackSolution {
    public static long dp(int[] array, int n, int sum) {
        long[][] dp = new long[n+1][sum+1];
        dp[0][0]=1;
        for (int i=1;i<=n;i++) {
            dp[i][0]=1;
            for (int j=sum;j>=0;j--) {
                if (j < array[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else dp[i][j] = dp[i - 1][j] + dp[i - 1][j - array[i]];
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = scanner.nextInt();
        int[] array = new int[n+1];
        array[0]=0;
        for (int i=1;i<n+1;i++) {
            array[i]=scanner.nextInt();
        }
        long answer = dp(array, n, sum);
        System.out.println(answer);
    }
}
