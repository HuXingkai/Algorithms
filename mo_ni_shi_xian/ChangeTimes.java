package mo_ni_shi_xian;

import java.util.Scanner;

/**
 * Created by andy on 2018/8/30.
 * 链接：https://www.nowcoder.com/questionTerminal/8c38063ca1574d93960c761f8f6efc81
 来源：牛客网

 牛牛想对一个数做若干次变换，直到这个数只剩下一位数字。
 变换的规则是：将这个数变成 所有位数上的数字的乘积。比如285经过一次变换后转化成2*8*5=80.
 问题是，要做多少次变换，使得这个数变成个位数。
 输入描述:
 输入一个整数。小于等于2,000,000,000。


 输出描述:
 输出一个整数，表示变换次数。
 示例1
 输入
 285
 输出
 2
 */
public class ChangeTimes {
    public static int nums = 0;
    public static void change(long n) {
        String str = n + "";
        int length = str.length();
        if (length == 1) {
            return;
        }
        int tep = 1;
        for (int i=0;i<length;i++) {
            tep*=(str.charAt(i)-'0');
        }
        nums++;
        change(tep);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        change(n);
        System.out.println(nums);

    }
}
