package reviewAlgorithms.DynamicProgramming;

import java.util.Scanner;

/**
 * Created by andy on 2018/8/6.
 * 链接：https://www.nowcoder.com/questionTerminal/b8bc8459f0d34aaa8c1af1328cab2432
 来源：牛客网

 /*
  * 二维背包问题：
  * 对于每件物品,当选择这件物品必须同时付出两种代价；
  * 对于每种代价都有一个可付出的最大值（背包容量）。
  * 问怎样选择物品可以得到最大的价值。
  * 设第i件物品所需的两种代价分别为a[i]和b[i]。两种代价可付出的最大值（两种背包容量）分别为u和v。物品的价值为w[i]。
  * 状态转移方程：dp[i][u][v] = max(dp[i-1][u][v] , w[i] + dp[i-1][u-a[i]][v-b[i]])
  *
  * 同样的进行空间压缩，我们可以得到二维数组的状态转移方程，如下：
  * dp[u][v] = max(dp[u-a[i]][v-b[i]]+w[i],dp[u][v])
  * !!!!!注：u、v在此均采用倒序！!!!! 只有倒序的时候，才能避免之前的值对后续的值不会造成影响。
  *
  * 例题说明：
  * 众所周知计算机代码底层计算都是0和1的计算，牛牛知道这点之后就想使用0和1创造一个新世界！
  * 牛牛现在手里有n个0和m个1，给出牛牛可以创造的x种物品，每种物品都由一个01串表示。
  * 牛牛想知道当前手中的0和1可以最多创造出多少种物品。
  * 等价对应：
  * n                ---------           背包容量，u
  * m                ---------           背包容量，v
  * x                ---------           物品个数
  * item[i].0的个数 ---------           物品i对应u部分的容量
  * item[i].1的个数 ---------           物品i对应v部分的容量
  * 最多创造的物品种数    ---------           可得到的最大价值（此时物品的价值w[i]=1）
 */
public class createNewWorld {
    /**
     * 最简单的二维背包问题的求解方法，只是多开了一维数组用来控制新增的限制条件
     * @param num0 表示每个串中0的个数
     * @param num1 表示每个串中1的个数
     * @param x    代表一共有多少中串
     * @param n    最大的0的个数
     * @param m    最大的1的个数
     * @return
     */
    public int solve(int[] num0, int[] num1, int x, int n, int m) {
        //开一个三维的数组来记录最优解
        int[][][] dp = new int[x+1][n+1][m+1];
        for (int i=1;i<=x;i++) {
            for (int j=1;j<=n;j++) {
                for (int k=1;k<=m;k++) {
                    if (k < num1[i - 1] || j < num0[i - 1]) {
                        dp[i][j][k]=dp[i-1][j][k];
                    } else if (dp[i - 1][j - num0[i - 1]][k - num1[i - 1]] + 1 > dp[i - 1][j][k]) {
                        dp[i][j][k] = dp[i - 1][j - num0[i - 1]][k - num1[i - 1]] + 1;
                    } else {
                        dp[i][j][k]=dp[i-1][j][k];
                    }
                }
            }
        }
        return dp[x][n][m];
    }

    /**
     *进行空间压缩，只是用二维数组的方法，参数定义与上相同
     * @param num0
     * @param num1
     * @param x
     * @param n
     * @param m
     * @return
     */
    public int reduceSpace(int[] num0, int[] num1, int x, int n, int m){
        int[][] dp = new int[n + 1][m + 1];
        for (int i=1;i<=x;i++) {
            for (int j=n;j>0;j--) {
                for (int k=m;k>0;k--) {
                    if (k >= num1[i - 1] && j >= num0[i - 1] && dp[j - num0[i - 1]][k - num1[i - 1]] + 1 > dp[j][k]) {
                        dp[j][k] = dp[j - num0[i - 1]][k - num1[i - 1]] + 1;
                    }
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] num0 = new int[x];
        int[] num1 = new int[x];
        for (int i=0;i<x;i++) {
            String str = scanner.next();
            for (int j=0;j<str.length();j++) {
                if (str.charAt(j) == '1') {
                    num1[i]++;
                } else if (str.charAt(j) == '0') {
                    num0[i]++;
                }
            }
        }
        createNewWorld c = new createNewWorld();

        System.out.println(c.solve(num0,num1,x,n,m));
        System.out.println("优化后结果：");
        System.out.println(c.reduceSpace(num0,num1,x,n,m));
    }
}
