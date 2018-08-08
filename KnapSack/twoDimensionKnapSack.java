package KnapSack;

/**
 * Created by andy on 2018/8/8.
 * 给定n种物品和一背包。物品i的重量是wi，体积是bi，其价值为vi，背包的容量为C，容积为D。
 * 问应如何选择装入背包中的物品，使得装入背包中物品的总价值最大？在选择装入背包的物品时，
 * 对每种物品i只有两种选择，即装入背包或者不装入背包。不能将物品i装入背包多次，也不能只装入部分的物品i
 */
public class twoDimensionKnapSack {
    public int solve(int n, int weight, int volume, int[] w, int[] v, int [] value) {
        //利用降维之后的数组求解
        int[][] dp = new int[weight + 1][volume + 1];
        for (int i=1;i<=n;i++) {
            //这里注意要按照降序进行循环
            for (int j=weight;j>0;j--) {
                for (int k=volume;k>0;k--) {
                    if (j >= w[i] && k >= v[i]&&dp[j-w[i]][k-v[i]]+value[i]>dp[j][k]) {
                        dp[j][k] = dp[j - w[i]][k - v[i]] + value[i];
                    }
                }
            }
        }
        return dp[weight][volume];
    }

    public static void main(String[] args) {
        int[] w = {0,3, 4, 6, 1, 2};
        int[] v = {0,2, 1, 4, 1, 4};
        int[] value = {0,6, 5, 7, 3, 8};
        int weight=8;
        int volume=7;
        int n = v.length - 1;
        twoDimensionKnapSack s = new twoDimensionKnapSack();
        System.out.println(s.solve(n,weight,volume,w,v,value));
    }
}
