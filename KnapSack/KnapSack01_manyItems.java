package KnapSack;

import java.util.Arrays;

/**
 * Created by andy on 2018/8/8.
 * 多重背包问题
 * 有n 种物品和一个容量为W 的背包。第i 种物品有mi 个，每件重量为wi ，
 * 价值为vi ，求从这n 种物品中挑选重量总和不超过W 的物品的最大价值。
 */
public class KnapSack01_manyItems {
    public int solve(int n, int maxW, int[] value, int[] weight, int[] nums) {
        //同样定义最优化的数组
        int[][] dp = new int[n + 1][maxW + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxW; j++) {
                if (j >= weight[i]) {
                    //如果num >j / weight[i]代表第i个物品的数目相对于当前重量j来说过量了，变成了完全背包问题
                    int num = nums[i];
                    if (num > j / weight[i]) {
                        num = j / weight[i];
                    }
                    //每个物品可以选0, 1, … num 个。依次递推，获得最优解
                    for (int k = 0; k <= num; k++) {
                        if (dp[i - 1][j - k * weight[i]] + k * value[i] > dp[i][j]) {
                            dp[i][j] = dp[i - 1][j - k * weight[i]] + k * value[i];
                        }
                    }
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n][maxW];
    }

    /**
     * 优化时间复杂度的方法1
     * 多重背包问题，最简单的解法，就是转化成0-1背包问题。第i 个物品有 mi 个， 等价于有mi 个相同的物品。
     * 但直接拆分成 mi 件物品并不是最好的方法。我们可以利用二进制来拆分。例如 m1=13=2^0+2^1+2^2+6 ,
     * 我们将第一种物品共13件，拆分成 2^0,2^1,2^2,6 这四件， 13以内的任何数字都可以通过这四种数字组合而成。
     * 于是，13件i种物品现在拆分为四件物品，每种各一件，又转化为01背包问题。
     * @param n
     * @param maxW
     * @param value
     * @param weight
     * @param nums   记录每种物品的个数
     * @return
     */
    public int solveOptimization(int n, int maxW, int[] value, int[] weight, int[] nums) {
        int[] dp = new int[maxW + 1];
        for (int i = 1; i <= n; i++) {
            int num = nums[i];
            if (num > maxW / weight[i]) {
                num = maxW / weight[i];
            }
            //利用二进制来拆分物品数
            for (int k = 1; num > 0; k *= 2) {
                if (k > num) {
                    k = num;
                }
                num -= k;
                //拆分之后，直接用01背包的方式求解k个背包的最优值，新物品重量k * weight[i]]，价值k * value[i]
                for (int j = maxW; j >= k * weight[i]; j--) {
                    if (dp[j - k * weight[i]] + k * value[i] > dp[j]) {
                        dp[j] = dp[j - k * weight[i]] + k * value[i];
                    }
                }

            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[maxW];
    }

    public static void main(String[] args) {
        //这里面在数组最前一位补0是为了上面计算的时候方便i值可以对应起来
        int[] w = {0, 2, 2, 1};
        int[] v = {0, 20, 10, 6};
        int[] nums = {0, 2, 5, 10};
        int weight = 8;
        int num = v.length - 1;
        KnapSack01_manyItems full = new KnapSack01_manyItems();
        long startTime = System.nanoTime();
        System.out.println(full.solve(num, weight, v, w, nums));
        long endTime = System.nanoTime();
        System.out.println("求解时间：" + (endTime - startTime) + "ns");
        System.out.println("优化后求解：");
        long startTime1 = System.nanoTime();
        System.out.println(full.solveOptimization(num, weight, v, w, nums));
        long endTime1 = System.nanoTime();
        System.out.println("求解时间：" + (endTime1 - startTime1) + "ns");
    }
}
