package KnapSack;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 0-1背包问题
 * http://shmilyaw-hotmail-com.iteye.com/blog/2009761
 * !!!https://www.cnblogs.com/Christal-R/p/Dynamic_programming.html
 * 假设我们有n件物品，分别编号为1, 2...n。其中编号为i的物品价值为vi，它的重量为wi。为了简化问题，
 * 假定价值和重量都是整数值。现在，假设我们有一个背包，它能够承载的重量是W。现在，我们希望往包里装这些物品，
 * 使得包里装的物品价值最大化，那么我们该如何来选择装的东西呢？
 * 假定我们这里选取的物品每个都是独立的，不能选取部分。也就是说我们要么选取某个物品，要么不能选取，
 * 不能只选取一个物品的一部分。这种情况，我们称之为0-1背包问题。
 *
 * */
public class KnapSack01 {
    /**
     * 最基本的背包问题的解法
     * @param l     代表物品的数量
     * @param w     代表背包最大重量
     * @param value  物品的价值
     * @param weight 物品的重量
     * @param totalV 最优解
     * @return
     */
    public static int solve(int l,int w,int[] value, int[] weight, int[][] totalV) {
        //从第一个物品一直判断选择到最后一个物品
        for (int i=1;i<l+1;i++) {
            //背包的最大重量位w，j代表表示的是当前的重量限制，从1开始逐渐增加到最重。实际上，当前背包还能承受重量不是连续增长的
            //但这里为了简单，背包的承重从1开始递增，表示只选区i个物品，背包承重逐渐递增到最大时，所获得的利润最大值
            for (int j=1;j<=w;j++) {
                //第i个物品的重量超过了背包所允许的最大重量，不选
                if (weight[i] > j) {
                    totalV[i][j]=totalV[i-1][j];
                }
                //选第i个物品
                else if (totalV[i - 1][j] > totalV[i - 1][j-weight[i]] + value[i]) {
                    totalV[i][j]=totalV[i-1][j];

                }
                else {
                    totalV[i][j]=totalV[i - 1][j-weight[i]] + value[i];
                }
            }
        }
        System.out.println("选中的物品");
        printItems(totalV,l,w,weight);
        //System.out.println(Arrays.deepToString(totalV));
        return totalV[l][w];
    }

    /**
     * 优化降维度，压缩空间复杂度的方法
     * http://www.hawstein.com/posts/dp-knapsack.html
     * https://www.cnblogs.com/Christal-R/p/Dynamic_programming.html
     * 然而不足的是，虽然优化了动态规划的空间，但是该方法不能找到最优解的解组成，
     * 因为动态规划寻早解组成一定得在确定了最优解的前提下再往回找解的构成，而优化后的动态规划只用了一维数组，
     * 之前的数据已经被覆盖掉，所以没办法寻找，所以两种方法各有其优点。
     *
     */
    public static int reduceSpace(int n, int maxW, int[] value, int[] weight) {
        //压缩空间埃，只用一维数组保存状态值。但是需要按照k递减的顺序来避免dp[i][k]的值被更新。
        int[] dp = new int[maxW+1];
        for (int i=1;i<=n;i++) {
            for (int k=maxW;k>0;k--) {
                if (k>=weight[i]&&dp[k] < dp[k - weight[i]] + value[i]) {
                    dp[k] = dp[k - weight[i]] + value[i];
                }
            }
        }
        return dp[maxW];
    }

    /**
     * 输出装入包里的物品的方法
     * @param val 已经填好的状态数组
     */
    public static void printItems(int[][] val,int n, int maxW, int[] weight) {
        int j=maxW;
        int[] chosen = new int[n + 1];
        for (int i=n;i>0;i--) {
            if (val[i][j] > val[i - 1][j]) {
                chosen[i] = 1;
                j = j - weight[i];
            }
        }
        System.out.println(Arrays.toString(chosen));
    }

    /**
     * 还有一种方法，具体的思路大致相同，都是重新寻表
     * @param args
     */
    /*void FindWhat(int i,int j)//寻找解的组成方式
    {
        if(i>=0)
        {
            if(V[i][j]==V[i-1][j])//相等说明没装
            {
                item[i]=0;//全局变量，标记未被选中
                FindWhat(i-1,j);
            }
            else if( j-w[i]>=0 && V[i][j]==V[i-1][j-w[i]]+v[i] )
            {
                item[i]=1;//标记已被选中
                FindWhat(i-1,j-w[i]);//回到装包之前的位置
            }
        }
    }*/

    public static void main(String[] args) {
        /*int[] v = {0, 60, 100, 120};
        int[] w = {0, 10, 20, 30};
        int weight = 50;
        int[][] c = new int[v.length][weight + 1];
        int answer = solve(3, weight, v, w, c);
        System.out.println(answer);
        System.out.println("优化后的输出：");
        System.out.println(reduceSpace(3,weight,v,w));*/
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int m = sc.nextInt();
        int[] weight = new int[m + 1];
        int[] value = new int[m + 1];
        for (int i=1;i<=m;i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }
        int[][] c = new int[m + 1][w + 1];
        solve(m, w, value, weight, c);


    }
}
