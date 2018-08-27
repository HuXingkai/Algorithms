package DFS;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by andy on 2018/8/26.
 * 链接：https://www.nowcoder.com/questionTerminal/a5190a7c3ec045ce9273beebdfe029ee
 来源：牛客网

 一个袋子里面有n个球，每个球上面都有一个号码(拥有相同号码的球是无区别的)。如果一个袋子是幸运的当且仅当所有球的号码的和大于所有球的号码的积。
 例如：如果袋子里面的球的号码是{1, 1, 2, 3}，这个袋子就是幸运的，因为1 + 1 + 2 + 3 > 1 * 1 * 2 * 3
 你可以适当从袋子里移除一些球(可以移除0个,但是别移除完)，要使移除后的袋子是幸运的。现在让你编程计算一下你可以获得的多少种不同的幸运的袋子。
 输入描述:
 第一行输入一个正整数n(n ≤ 1000)
 第二行为n个数正整数xi(xi ≤ 1000)


 输出描述:
 输出可以产生的幸运的袋子数
 示例1
 输入
 3
 1 1 1
 输出
 2
 */
public class LuckyBag {
    public static int n;
    public static int m;
    public static long bagNums;
    public static void luckybags(long sum, long product, int pos, int[] nums) {
        if (pos >= n) {
            return;
        }
        //for (int i=pos;i<n;i++) {
            sum += nums[pos];
            product *= nums[pos];
            if (m + sum > product) {
                long tep = m + sum - product;
                bagNums += tep;
                luckybags(sum, product, pos + 1, nums);
            }
            else return;
        //}
    }
    public static void luckybags1(long sum, long product, int pos, int[] nums) {
        if (pos >= n) {
            return;
        }
        for (int i=pos;i<n;i++) {
        sum += nums[i];
        product *= nums[i];
        if (m + sum > product) {
            long tep = m + sum - product;
            bagNums += tep;
            luckybags(sum, product, i + 1, nums);
            sum -= nums[i];
            product /= nums[i];
        }
        else return;
        }
    }

    public static int dfs(int[]a, int curIndex, int sum, int product){
        int count=0;
        for(int i=curIndex;i<a.length;i++){
            sum+=a[i]; product*=a[i];
            if(sum>product) count+=1+dfs(a, i+1, sum, product);
            //当前数为1，后续说不定可以保证满足要求
            //只在最开始只有一个1的时候候调用了一次
            else if(a[i]==1) count+=dfs(a, i+1, sum,product);
            else break;// 当前数不满足 那么ball[i+1]
            sum-=a[i]; product/=a[i];//回溯法 遍历，移除当前位置的值，从i+1处的值继续上述过程，但注意啊下面的去重
            for(;i<a.length-1&&a[i]==a[i+1];i++) ;//对于重复数字，要去重复。
        }
        return count;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int [] nums = new int[n];
        for (int i=0;i<n;i++) {
            nums[i] = scanner.nextInt();
            if (nums[i] == 1) {
                m++;
            }
        }
        Arrays.sort(nums);
        System.out.println("正确解：" + dfs(nums, 0, 0, 1));
        bagNums = m - 1;
        if (m == n) {
            System.out.println(bagNums);

        } else {
            for (int i=m;i<n;i++) {
                if (nums[i] == nums[i - 1]) {
                    continue;
                }
                luckybags1(0, 1, i, nums);
            }
            System.out.println(bagNums);
        }
    }
}
