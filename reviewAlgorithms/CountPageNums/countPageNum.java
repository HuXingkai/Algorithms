package reviewAlgorithms.CountPageNums;

import java.util.Scanner;

/**
 * Created by andy on 2018/8/6.
 * 牛牛新买了一本算法书，算法书一共有n页，页码从1到n。牛牛于是想了一个算法题目：在这本算法书页码中0~9每个数字分别出现了多少次？
 * 输入包括一个整数n(1 ≤ n ≤ 1,000,000,000)
 *输出包括一行10个整数，即0~9这些数字在页码中出现的次数，以空格分隔。行末无空格
 *
 *输入：999
 *输出：189 300 300 300 300 300 300 300 300 300
 */
public class countPageNum {
    public int[] theNumTimes(int n) {
        int[] ans = new int[10];
        for (int i = 1; i <= n; i++) {
            String str = "" + i;
            for(int j=0;j<str.length();j++) {
                int intTem = Integer.parseInt(str.charAt(j) + "");
                ans[intTem]++;
            }
        }
        return ans;
    }

    public static void main(String[] argv) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        countPageNum c = new countPageNum();
        int[] array = c.theNumTimes(num);
        for (int i=0;i<9;i++) {
            System.out.print(array[i]+" ");
        }
        System.out.print(array[9]);
    }
}
