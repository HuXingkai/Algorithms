package KnapSack;
import java.util.Arrays;

/**
 * Created by andy on 2018/8/7.
 * 0-1背包问题描述如下：

 有一个容量为V的背包，和一些物品。这些物品分别有两个属性，体积w和价值v，每种物品只有一个。
 要求用这个背包装下价值尽可能多的物品，求该最大价值，背包可以不被装满。因为最优解中，每个物品都有两种可能的情况，
 即在背包中或者不存在（背 包中有0个该物品或者 1个），所以我们把这个问题称为0-1背包问题。
 *
 * 继续0-1背包问题，如果在上面的问题加上一个限制条件，所选择的物品必须恰好装满背包，否则输出-1。
 */
public class KnapSack01_full {
    public int solve(int n, int maxW, int[] value, int[] weight) {
        //定义最优化数组
        int[][] dp = new int[n + 1][maxW+1];
        //初始化：当背包重为零时，不装入物品，视为装满，但价值0
        //不能装满的背包重量，最优化的值初始化为-1或者负无穷
        for (int i=0;i<n+1;i++) {
            for(int j=0;j<maxW+1;j++) {
                if (j == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = -1;
                }
            }

        }

        for (int i=1;i<=n;i++) {
            for (int k=maxW;k>0;k--) {
                //dp[i - 1][k - weight[i]] != -1 代表在背包重量为k - weight[i]时，i个物品已经可以装满背包
                //此时，如果加上重量为weight[i]的物品，价值还是最大的，则同样可以在装满背包的前提下，获得最优解
                if (k>=weight[i-1]&&dp[i - 1][k - weight[i-1]] != -1 && dp[i - 1][k - weight[i-1]] + value[i-1] > dp[i - 1][k]) {
                    dp[i][k] = dp[i - 1][k - weight[i-1]] + value[i-1];
                }else{
                    dp[i][k] = dp[i - 1][k];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n][maxW];
    }

    public static void main(String[] args) {
        int[] w = {3, 4, 5};
        int[] v= {4, 5, 6};
        int weight = 10;
        KnapSack01_full full = new KnapSack01_full();
        System.out.println(full.solve(3,weight,v,w));
    }
}
