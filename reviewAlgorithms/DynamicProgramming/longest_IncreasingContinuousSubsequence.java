package reviewAlgorithms.DynamicProgramming;

/**
 * Created by andy on 2018/8/9.
 * 序列必须是连续的，不能间断
 * Description
 Give an integer array，find the longest increasing continuous subsequence in this array.
 An increasing continuous subsequence:
 Can be from right to left or from left to right.
 Indices of the integers in the subsequence should be continuous.
 Notice
 O(n) time and O(1) extra space.
 Have you met this question in a real interview? Yes
 Example
 For [5, 4, 2, 1, 3], the LICS is [5, 4, 2, 1], return 4.
 For [5, 1, 2, 3, 4], the LICS is [1, 2, 3, 4], return 4.
 Tags
 Array Dynamic Programming Enumeration
 */
public class longest_IncreasingContinuousSubsequence {
    public static int longestSub(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int n = A.length;
        int answer = 1;

        // from left to right
        int length = 1;
        for (int i = 1; i < n; i++) {
            if (A[i] > A[i - 1]) {
                length++;
            } else {
                length = 1;
            }
            answer = Math.max(answer, length);
        }

        // from right to left
        length = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                length++;
            } else {
                length = 1;
            }
            answer = Math.max(answer, length);
        }

        return answer;
    }

    /**
     * 上述最长连续子序列的变形题：
     *
     * 牛牛现在有一个n个数组成的数列,牛牛现在想取一个连续的子序列,并且这个子序列还必须得满足:
     最多只改变一个数,就可以使得这个连续的子序列是一个严格上升的子序列,牛牛想知道这个连续子序列最长的长度是多少。
     输入描述:
     输入包括两行,第一行包括一个整数n(1 ≤ n ≤ 10^5),即数列的长度;
     第二行n个整数a_i, 表示数列中的每个数(1 ≤ a_i ≤ 10^9),以空格分割。
     输出描述:
     输出一个整数,表示最长的长度。
     示例1
     输入
     6
     7 2 3 1 5 6
     输出
     5 （2 3 1 5 6 其中1可以变为4）

     该题是在 Longest Increasing Continuous Subsequence 的基础上改编过来的。
     * https://github.com/cherryljr/LintCode/blob/master/Longest%20Increasing%20Continuous%20Subsequence.java
     * 因此题目的主要核心是相同的，我们只需要加入一些条件判断便能够 AC 这道题目。
     *
     * 首先我们需要有两个 DP 数组分别用于储存 从左往右 和 从右往左 的 LICS.
     * 它们分别为:
     * dpLeft[i], 它表示以 nums[i] 作为结尾的最长递增子串的长度;
     * dpRight[i], 它表示以 nums[i] 作为起始的最长递增子串的长度.
     * 因为我们可以修改一个位置的值，因此：
     *  当 num[i - 1] 与 nums[i + 1] 之间至少相差 2 时，我们可以通过修改 nums[i] 使得 nums[i-1] 和 nums[i+1] 也组成连续递增序列。
     *  值为: dpLeft[i - 1] + dpRight[i + 1] + 1
     *  若不成立，我们取 dpLeft[i - 1] 和 dpRight[i + 1] 中的较大值，然后修改 nums[i]. 组成一个 LICS.
     *  值为: Math.max(dpLeft[i - 1], dpRight[i + 1]) + 1
     * @param arr
     * @return
     */
    public static int niuniuSubsequence(int[] arr,int n) {
        // 记录正序遍历得到的各个递增子序列长度
        int[] dpL = new int[n];
        // 记录逆序遍历得到的各个递增子序列长度
        int[] dpR = new int[n];


        // 正向统计连续递增序列的长度（以第i位数结尾的递增子序列）
        dpL[0] = 1;//初始化第一个序列，长度为1
        for (int i=1;i<n;i++) {
            if (arr[i] > arr[i - 1]) {
                dpL[i] = dpL[i - 1] + 1;
            } else {
                dpL[i] = 1;
            }
        }

        // 逆向统计连续递增序列的长度（以第i位数开始的递增子序列,必须是以i作为序列的第一个元素）
        //注意这里的逆序，寻找的同样是递增的序列
        dpR[n - 1] = 1;
        for (int j=n-2;j>=0;j--) {
            if (arr[j] < arr[j + 1]) {
                dpR[j] = dpR[j + 1] + 1;
            } else {
                dpR[j] = 1;
            }
        }

        //最小的序列长度为1，将rst初始化为1
        int rst = 1;
        for (int i=1;i<n-1;i++) {
            // 对于每一位置i有左侧到它的最长连续递增序列dpLeft[i], 右侧有连续递增子序列长度dpRight[i]
            // 加1是因为 nums[i] 可进行修改从而组成 LICS 的一部分, 因此长度要算上第i位数。
            //即在Math.max(dpL[i-1], dpR[i+1])较大者的值的基础上加一。
            //由于nums[i]是可以变化的，因此在寻找左边或者右边最大的连续序列长度时，可以从i-1,i+1开始寻找，最后在加上
            //第i位的数，同样保证此最大值是以i开始或者结束的最长子序列

            rst = Math.max(rst, Math.max(dpL[i-1], dpR[i+1])+1);
            if (arr[i + 1] - arr[i - 1] >= 2) {
                // 第i+1位 与 第i-1位 至少相差2，则可以修改第i位数，使第i-1、i、i+1也可以组成连续递增序列。
                rst = Math.max(rst, dpL[i - 1] + dpR[i + 1] + 1);
            }
        }
        return rst;
    }
    public static void main(String[] args) {
        int[] arr = {7,2,3,1,5,6};
        System.out.println(niuniuSubsequence(arr,arr.length));
    }
}

