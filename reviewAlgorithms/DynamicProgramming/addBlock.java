package reviewAlgorithms.DynamicProgramming;

import java.util.Scanner;

/**
 * Created by andy on 2018/8/8.
 * 小易有n块砖块，每一块砖块有一个高度。小易希望利用这些砖块堆砌两座相同高度的塔。为了让问题简单，砖块堆砌就是简单的高度相加，
 * 某一块砖只能使用在一座塔中一次。小易现在让能够堆砌出来的两座塔的高度尽量高，小易能否完成呢。
 输入描述:

 输入包括两行：
 第一行为整数n(1 ≤ n ≤ 50)，即一共有n块砖块
 第二行为n个整数，表示每一块砖块的高度height[i] (1 ≤ height[i] ≤ 500000)

 输出描述:

 如果小易能堆砌出两座高度相同的塔，输出最高能拼凑的高度，如果不能则输出-1.
 保证答案不大于500000。
 示例1
 输入

 3
 2 3 5
 输出

 5
 *
 *解题思路

 动态规划

 假设砖块分为A，B两堆，dp[i][j]中的j表示B-A的长度。
 因为B-A有可能是负的，所以j整体偏移sum个长度，即2*sum+1。
 而dp[i][j]的值则表示当A-B的值为j时，B的最大长度是多少。
 dp[i][j] = dp[i-1][j]表示我不用第i块砖
 dp[i][j] = max(dp[i-1][j-h], dp[i-1][j])表示把砖放在A堆。
 dp[i][j] = max(dp[i-1][j+h]+h, dp[i-1][j])表示把砖放在B堆。
 因为会爆内存，所以用了滚动数组。下一次结果只依赖于前一次，因而只保存前一次状态和当前状态即可。
 */
public class addBlock {
    public static int solve(int[] data) {
        int length = data.length;
        int sum = 0;
        for (int num : data) {
            sum += num;
        }
        //dp0保存当前的值i，dp1保存的为i-1时的值，动态更新
        int[] dp0 = new int[2 * sum + 1];
        int[] dp1 = new int[2 * sum + 1];

        for (int i=0;i<dp0.length;i++) {
            dp0[i] = -1;
        }
        //由于数组整体加了sum,原来j=0(两堆高度相等)，现在j=0+sum=sum
        //也就是说，dp0[sum]代表了两堆高度相等时的最大高度
        //初始两堆高度为0时，高度相等，最大高度为0，为合法值，初始化为0/。其他的值均为无效值，初始化为-1
        dp0[sum] = 0;

        for (int i=0;i<length;i++) {
            int h = data[i];
            for (int j=0;j<2 * sum + 1;j++) {
                dp1[j] = dp0[j];

                if (j - h >= 0 && dp0[j - h] != -1) {
                    dp1[j] = Math.max(dp0[j - h], dp1[j]);
                }
                if (j + h <= 2 * sum && dp0[j + h] != -1) {
                    dp1[j] = Math.max(dp0[j + h] + h, dp1[j]);
                }
            }

            int[] temp = dp0;
            dp0 = dp1;
            dp1 = temp;
        }
        return dp0[sum] == 0 ? -1 : dp0[sum];
    }

    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] length = new int[n];

        for (int i=0;i<n;i++) {
            length[i] = scanner.nextInt();
        }*/
        int[] length={2,3,5};
        System.out.println(solve(length));
    }
}
