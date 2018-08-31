package jianzhiOffer;

import java.util.Scanner;

/**
 * Created by andy on 2018/8/31.
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 n<=39
 */
public class Problem7 {
    public static int[][] matrixMulti(int[][] left, int[][] right) {
        int[][] tep = new int[left.length][left[0].length];
        for (int i=0;i<left.length;i++) {
            for (int j=0;j<left[0].length;j++) {
                for (int k=0;k<left[0].length;k++) {
                    tep[i][j] += left[i][k] * right[k][j];
                }
            }
        }
        return tep;
    }

    public static int quickPow(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[][] now = {{1, 1}, {1, 0}};
        int[][] ans = {{1, 0}, {0, 1}};

        while (n != 0) {
            if ((n & 1) == 1) {
                ans = matrixMulti(ans, now);
            }
            n = n >> 1;
            now = matrixMulti(now, now);
        }

        return ans[0][0];
    }

    /**
     * 线性时间求解的方法，把已经得到的中间项保存起来，避免重复的运算
     * @param n
     * @return
     */
    public static int findInN(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        for (int i=2;i<=n;i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(quickPow(n-1));
        System.out.println(findInN(n));
    }
}
