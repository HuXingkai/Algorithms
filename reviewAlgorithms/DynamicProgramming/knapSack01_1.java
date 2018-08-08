package reviewAlgorithms.DynamicProgramming;

import java.util.Arrays;

/**
 * Created by andy on 2018/8/7.
 */
public class knapSack01_1 {
    public int findValue(int[] weight, int[] value, int maxWeight, int n) {
        //建立一个二维的数组，表示在选取/不选区第i件物品时，在不超过当前重量限制的条件下，获得的最优解
        int[][] dp = new int[n + 1][maxWeight + 1];
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=maxWeight;j++){
                //这里从1开始递增背包的重量限制
                if (j < weight[i-1]) {
                    dp[i][j]=dp[i-1][j];
                } else if (dp[i - 1][j - weight[i-1]] + value[i-1] > dp[i - 1][j]) {
                    dp[i][j] = dp[i - 1][j - weight[i-1]] + value[i-1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][maxWeight];

    }

    public static void main(String[] args) {
        int[] v = {60, 100, 120};
        int[] w = {10, 20, 30};
        int weight = 50;
        knapSack01_1 k = new knapSack01_1();
        System.out.println(k.findValue(w,v,weight,3));
    }
}
