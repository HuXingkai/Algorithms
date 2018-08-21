package reviewAlgorithms.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by andy on 2018/8/9.
 * LIS（Longest Increasing Subsequence）最长上升子序列
 一个数的序列bi，当b1 < b2 < … < bS的时候，我们称这个序列是上升的。对于给定的一个序列(a1, a2, …, aN)，
 我们可以得到一些上升的子序列(ai1, ai2, …, aiK)，这里1 <= i1 < i2 < … < iK <= N。
 比如，对于序列(1, 7, 3, 5, 9, 4, 8)，有它的一些上升子序列，如(1, 7), (3, 4, 8)等等。这些子序列中最长的长度是4，
 比如子序列(1, 3, 5, 8).
 你的任务，就是对于给定的序列，求出最长上升子序列的长度。
 *
 * 链接：https://www.nowcoder.com/questionTerminal/d83721575bd4418eae76c916483493de
 来源：牛客网

 具体实例：广场上站着一支队伍，她们是来自全国各地的扭秧歌代表队，现在有她们的身高数据，请你帮忙找出身高依次递增的子序列。
 例如队伍的身高数据是（1、7、3、5、9、4、8），其中依次递增的子序列有（1、7），（1、3、5、9），（1、3、4、8）等，
 其中最长的长度为4。

 *输入
 7
 1 7 3 5 9 4 8
 6
 1 3 5 2 4 6
 输出
 4
 4

 */
public class longest_increasing_subsequence {
    public static int solve(int n, int [] arr) {
        //dp表示以arr[i]结尾的子串的LIS长度。需要注意的：必须以arr[i]结尾
        int[] dp = new int[n];
        int max=1;
        //初始化为1，长度为1的串，上升序列的长度就是1
        //因此上升序列的长度最小为1
        for (int i=0;i<n;i++) {
            dp[i] = 1;
        }
        for (int i=1;i<n;i++) {
            for (int j=0;j<i;j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }

    //这么做是错误的，因为不能确定当arr[j] < arr[i]时，最大长度为dp[j] + 1。
    // 因为dp[j]取最大时，可能并不包含arr[i]这项元素
    public static int solve1(int n, int [] arr) {
        int[] dp = new int[n];
        //初始化为1，长度为1的串，上升序列的长度就是1
        dp[0] = 1;
        for (int i=1;i<n;i++) {
            for (int j=0;j<i;j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i-1], dp[j] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n-1];
    }
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i=0;i<n;i++) {
                arr[i] = scanner.nextInt();
            }
            System.out.println(solve(arr.length,arr));
        }*/
        int[] arr = {1,7,3,5,9,4,8};
        System.out.println(solve(arr.length,arr));
        System.out.println(solve1(arr.length,arr));
    }

}
