package mo_ni_shi_xian;

import java.util.Scanner;

/**
 * Created by andy on 2018/8/30.
 * 链接：https://www.nowcoder.com/questionTerminal/41cb7d4ed0254c69a06d596d89ad12a2
 来源：牛客网

 牛牛在研究他自己独创的平衡数，平衡数的定义是：将一个数分成左右两部分，分别成为两个新的数。
 左右部分必须满足以下两点：
 1，左边和右边至少存在一位。
 2，左边的数每一位相乘如果等于右边的数每一位相乘，则这个数称为平衡数。
 例如：1221这个数，分成12和21的话，1*2=2*1，则称1221为平衡数，再例如：1236这个数，可以分成123和1*2*3=6，所以1236也是平衡数。而1234无论怎样分也不满足平衡数。
 输入描述:
 输入一个正整数（int范围内）。


 输出描述:
 如果该数是平衡数，输出 "YES", 否则输出 "NO"。
 示例1
 输入
 1221
 1234
 输出
 YES
 NO
 */
public class BalanceNUm {
    public static String find(int n) {
        String str = "" + n;
        for (int i=1;i<str.length();i++) {
            int left=1;
            for (int j=0;j<i;j++) {
                int now = str.charAt(j) - '0';
                if (now == 0) {
                    left=0;
                    break;
                }
                else left *= now;
            }

            int right=1;
            for (int j=i;j<str.length();j++) {
                int now = str.charAt(j) - '0';
                if (now == 0) {
                    right=0;
                    break;
                }
                else right *= now;
            }
            if (left == right) {
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(find(n));
        }
    }
}
