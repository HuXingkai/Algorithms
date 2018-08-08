package KnapSack;

import java.util.Arrays;

/**
 * Created by andy on 2018/8/8.
 * 完全背包问题
 * 同01背包问题，现在的限制是每种物品有无数多个，求该背包装物品的价值的最优解
 * 在完全背包问题中，每个物品可以选0, 1, … ⌊W/wi⌋ 个。
 */
public class KnapSack01_countlessItems {
    public int solve(int n, int maxW, int[] value, int[] weight) {
        //同样定义最优化的数组
        int[][] dp = new int[n+1][maxW+1];
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=maxW;j++) {
                if (j >= weight[i]) {
                    //每个物品可以选0, 1, … ⌊W/wi⌋ 个。依次递推，获得最优解
                    for (int k = 0; k <= j / weight[i]; k++) {
                        if (dp[i - 1][j - k * weight[i]] + k * value[i] > dp[i][j]) {
                            dp[i][j] = dp[i - 1][j - k * weight[i]] + k * value[i];
                        }
                    }
                } else {
                    dp[i][j] =dp[i-1][j] ;
                }
            }
        }
        //System.out.println(Arrays.deepToString(dp));
        return dp[n][maxW];
    }

    /**
     * 优化时间复杂度的方法
     * @param n
     * @param maxW
     * @param value
     * @param weight
     * @return
     */
    public int solveOptimization(int n, int maxW, int[] value, int[] weight) {
        int[][] dp = new int[n + 1][maxW + 1];
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=maxW;j++) {
                if (j >= weight[i]) {
                    if (dp[i - 1][j] < dp[i][j - weight[i]] + value[i]) {
                        dp[i][j] = dp[i][j - weight[i]] + value[i];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][maxW];
    }

    /**
     * 减小空间复杂度的算法
     * @param n
     * @param maxW
     * @param value
     * @param weight
     * @return
     */
    public int solveReduceSpace(int n, int maxW, int[] value, int[] weight) {
        int[] dp = new int[maxW + 1];
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=maxW;j++) {

                if (j >= weight[i] && dp[j] < dp[j - weight[i]] + value[i]) {
                    dp[j] = dp[j - weight[i]] + value[i];
                }
            }
        }
        return dp[maxW];
    }
    public static void main(String[] args) {
        int[] w = {0, 2, 3, 4, 7};
        int[] v = {0, 1, 3, 5, 9};
        int weight = 10;
        int num=4;
        KnapSack01_countlessItems full = new KnapSack01_countlessItems();
        long startTime = System.nanoTime();
        System.out.println(full.solve(num,weight,v,w));
        long endTime = System.nanoTime();
        System.out.println("求解时间："+(endTime-startTime)+"ns");
        System.out.println("优化时间复杂度后求解：");
        long startTime1 = System.nanoTime();
        System.out.println(full.solveOptimization(num,weight,v,w));
        long endTime1 = System.nanoTime();
        System.out.println("求解时间："+(endTime1-startTime1)+"ns");

        System.out.println("优化空间复杂度后求解：");
        long startTime2 = System.nanoTime();
        System.out.println(full.solveReduceSpace(num,weight,v,w));
        long endTime2 = System.nanoTime();
        System.out.println("求解时间："+(endTime2-startTime2)+"ns");
    }
}
