package GreedyAlgorithms;

import java.util.Scanner;

/**
 * Created by andy on 2018/8/30.
 * 链接：https://www.nowcoder.com/questionTerminal/2d3f6ddd82da445d804c95db22dcc471
 来源：牛客网

 牛牛定义排序子序列为一个数组中一段连续的子序列,并且这段子序列是非递增或者非递减排序的。牛牛有一个长度为n的整数数组A,他现在有一个任务是把数组A分为若干段排序子序列,牛牛想知道他最少可以把这个数组分为几段排序子序列.
 如样例所示,牛牛可以把数组A划分为[1,2,3]和[2,2,1]两个排序子序列,至少需要划分为2个排序子序列,所以输出2
 输入描述:
 输入的第一行为一个正整数n(1 ≤ n ≤ 10^5)

 第二行包括n个整数A_i(1 ≤ A_i ≤ 10^9),表示数组A的每个数字。


 输出描述:
 输出一个整数表示牛牛可以将A最少划分为多少段排序子序列
 示例1
 输入
 6
 1 2 3 2 2 1
 输出
 2
 */
public class SortedSubsquence {
    //通过率为90%
    public static int find(int n, int[] nums) {
        int ans=1;
        int flag[] = new int[n];
        for (int i=1;i<n;i++) {
            if (nums[i] > nums[i - 1]) {
                flag[i] = 2;
            } else if (nums[i] < nums[i - 1]) {
                flag[i] = 1;
            }
            else flag[i] = 0;
        }
        for (int i=1;i<n-1;i++) {
            if (flag[i] == 0) {
                int left=0;
                int j=i;j--;
                while (j > 0&&flag[j] == 0) {
                    j--;
                }
                left = flag[j];

                int right=0;
                j=i;j++;
                while (j < n &&flag[j] == 0) {
                    j++;
                }
                right = flag[j];
                i=j;

                if (left !=0&&right !=0&&left != right) {
                    ans++;
                }

            }
            else if (flag[i] !=0&&flag[i + 1] !=0&&flag[i] != flag[i + 1]) {
                i++;
                ans++;
            }
        }
        return ans;
    }

    /*
 * flag = 0 开始
 * flag = 1 严格递增（即不包含相等的情况）
 * flag = 2 严格递减（即不包含相等的情况）
 * 相等的时候我们什么也不做，最后对于我们结果加1即可
 */
    public static int solve(int n, int[] nums) {
        int flag = 0;
        int res = 0;
        int last = nums[0];

        for (int i=1;i<n;i++) {
            int now = nums[i];
            if (flag == 0) {
                if (now > last) {
                    flag = 1;
                } else if (now < last) {
                    flag = 2;
                }
            } else if (flag == 1) {
                //只要当前的数>=之前的数，就可以继续保持非递减数列的形式，就不需要任何操作
                //而当 now < last时，开始递减了，因此应该将数组划分，并重置为初始状态
                if (now < last) {
                    res++;
                    flag = 0;
                }
            } else {
                if (now > last) {
                    res++;
                    flag = 0;
                }
            }
            last = now;
        }
        return res+1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i=0;i<n;i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(find(n, nums));
        System.out.println(solve(n, nums));
    }
}
