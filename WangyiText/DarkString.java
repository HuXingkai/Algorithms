package WangyiText;

import java.util.Scanner;

/**
 * Created by andy on 2017/8/25.
 * <p>
 * 一个只包含'A'、'B'和'C'的字符串，如果存在某一段长度为3的连续子串中恰好'A'、'B'和'C'
 * 各有一个，那么这个字符串就是纯净的，否则这个字符串就是暗黑的。例如：
 * BAACAACCBAAA 连续子串"CBA"中包含了'A','B','C'各一个，所以是纯净的字符串
 * AABBCCAABB 不存在一个长度为3的连续子串包含'A','B','C',所以是暗黑的字符串
 * 你的任务就是计算出长度为n的字符串(只包含'A'、'B'和'C')，有多少个是暗黑的字符串。
 * <p>
 * 思路是直接寻找暗黑的字符串，递归每个n的条件下，'AA' 'AB'型字符串分个数，即可求出n+1 情况下
 * 的暗黑字符串的个数
 */
public class DarkString {
    public static int AAnum(int n) {
        if (n == 3) {
            return 3;
        } else return AAnum(n - 1)+ABnum(n-1);
    }

    public static int ABnum(int n) {
        if (n == 3) {
            return 6;
        }
        else return 2*AAnum(n - 1)+ABnum(n-1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 2) {
            System.out.println("9");
        } else {
            int darkNum = 3 * AAnum(n) + 2 * ABnum(n);
            System.out.println(darkNum);
        }

    }
}
