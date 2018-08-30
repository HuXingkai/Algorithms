package MathProblem;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by andy on 2018/8/28.
 * 链接：https://www.nowcoder.com/questionTerminal/79c639e02bc94e6b919e3372c8e1dc5e
 来源：牛客网

 小易拥有一个拥有魔力的手环上面有n个数字(构成一个环),当这个魔力手环每次使用魔力的时候就会发生一种奇特的变化：每个数字会变成自己跟后面一个数字的和(最后一个数字的后面一个数字是第一个),一旦某个位置的数字大于等于100就马上对100取模(比如某个位置变为103,就会自动变为3).现在给出这个魔力手环的构成，请你计算出使用k次魔力之后魔力手环的状态。
 输入描述:
 输入数据包括两行： 第一行为两个整数n(2 ≤ n ≤ 50)和k(1 ≤ k ≤ 2000000000),以空格分隔 第二行为魔力手环初始的n个数，以空格分隔。范围都在0至99.


 输出描述:
 输出魔力手环使用k次之后的状态，以空格分隔，行末无空格。
 示例1
 输入
 3 2 1 2 3
 输出
 8 9 7
 */
public class MagicRings {
    /**
     * 此方法应该可行，但最后的结果却有问题
     * @param n
     * @param k
     * @param num
     * @return
     */
    public static int[] find(int n, long k, int[] num) {
        int[][] matrix = new int[n][n];
        for (int i=0;i<n;i++) {
            matrix[i][i] = 1;
            if (i+1==matrix.length) {
                matrix[0][i] = 1;
            }
            else matrix[i+1][i] = 1;
        }

        int[][] cur = matrix;
        int[][] res = new int[n][n];
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }

        while (k != 0) {
            if ((k & 1) == 1) {
                res = multiplyMatrix(res, cur);
            }
            //
            cur = multiplyMatrix(cur, cur);
            k >>= 1;
        }
        return singleMatrix(num, res);
    }

    public static int[][] multiplyMatrix(int[][] a, int[][] b) {
        int[][] answer = new int[a.length][a[0].length];
        for (int i=0;i<a.length;i++) {
            for (int j=0;j<a[0].length;j++) {
               for (int k=0;k<a.length;k++) {
                   if (a[i][k] == 0 || b[k][j] == 0) {
                       continue;
                   }
                   answer[i][j] += a[i][k] * b[k][j];
                   if (answer[i][j] >= 100) {
                       answer[i][j]%=100;
                   }
               }
            }
        }
        return answer;
    }

    public static int[] singleMatrix(int[] a, int[][] b) {
        int[] answer = new int[a.length];
        for (int i=0;i<a.length;i++) {
            for (int j=0;j<b.length;j++) {
                answer[i] += a[j] * b[j][i];
                if (answer[i] >= 100) {
                    answer[i]%=100;
                }
            }
        }
        return answer;
    }
    public static void fins(int n, long k, int[] nums) {
        for (long i=0;i<k;i++) {
            int start = nums[0];
            for (int j=0;j<n-1;j++) {
                nums[j] += nums[j + 1];
                if (nums[j] >= 100) {
                    nums[j]=nums[j]%100;
                }
            }
            nums[n - 1] += start;
            if (nums[n - 1] >= 100) {
                nums[n - 1]=nums[n - 1]%100;
            }
        }
        for (int j=0;j<nums.length;j++) {
            if (j < n - 1) {
                System.out.print(nums[j] + " ");
            }
            else System.out.print(nums[j]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextLong();
        int[] nums = new int[n];
        for (int i=0;i<n;i++) {
            nums[i] = sc.nextInt();
        }
        int[] ans = find(n, k, nums);
        for (int i = 0; i < ans.length - 1; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println(ans[ans.length - 1]);

        fins(n, k, nums);
    }
}
