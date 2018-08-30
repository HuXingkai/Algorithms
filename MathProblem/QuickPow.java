package MathProblem;

import java.util.Scanner;

/**
 * Created by andy on 2018/8/28.
 * 快速幂和矩阵快速幂的求解方法
 * http://huang22.github.io/2016/04/11/%E7%9F%A9%E9%98%B5%E5%BF%AB%E9%80%9F%E5%B9%82/
 *
 */
public class QuickPow {
    public static int quickpow(int a, int b) {
        int ans=1;
        int base = a;
        while (b!=0) {
            //n & 1，就是取n的二进制的最末尾，事实上， 就是相当于n % 2
            if ((b&1)==1) {
                ans = ans * base;
            }
            base = base * base;
            //n = n >> 1 就是右移一位，就是n = n / 2.
            b=b>>1;
        }
        return ans;
    }

    private static int[][] Core(int[][] a, int[][] b) {
        int rowRes = a.length;
        int columnRes = b[0].length; //TODO:
        int columnA = a[0].length; // == b.length;

        int[][] c = new int[rowRes][columnRes];
        for (int i =0; i < rowRes; i ++) {
            for (int j = 0; j < columnRes; j ++) {

                for (int k = 0; k < columnA; k ++) {
                    if (a[i][k] == 0 || b[k][j] == 0) {
                        continue;          //剪枝
                    }

                    c[i][j] += a[i][k] * b[k][j];
                }
                //100取余运算
                if (c[i][j] >= 100) {
                    c[i][j] %= 100;
                }
            }
        }
        return c;
    }
    public static void main(String[] args) {
        System.out.println(quickpow(2,3));

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        //用一个二维数组存储
        int[][] arr= new int[1][n];
        for (int i = 0; i < n; i ++) {
            arr[0][i] = sc.nextInt();
        }
        //初始化单元矩阵
        int[][] mul = new int[n][n];
        for (int i = 0; i < n; i ++) {
            if (i < n - 1) {
                mul[i][i] = 1;
                mul[i + 1][i] = 1;
            } else {
                mul[i][i] = 1;
                mul[0][i] = 1;
            }
        }

        for (; k > 0; k >>= 1) {
            if ((k & 1) == 1) {
                arr = Core(arr, mul);
            }
            mul = Core(mul, mul);
        }
        int i;
        for (i = 0; i < n - 1; i ++) {
            System.out.print(arr[0][i] + " ");
        }
        System.out.println(arr[0][i]);
    }
}
