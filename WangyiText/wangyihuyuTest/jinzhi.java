package WangyiText.wangyihuyuTest;

import java.util.Scanner;

/**
 * Created by andy on 2018/9/8.
 * 测试用例
 3
 5 2 113221101000101
 13 7 1016
 4 12 2222248A

 一个整数分别用两种进制表示，但中间忘记加空格，整个连在一起形成一个非法字符串。
 现在给出表示的两种进制，和非法字符串，还原出初始的整数
 输入：5 2 113221101000101
 5进制和2进制 连在一起的字符串为113221101000101，求原来的整数
 */
public class jinzhi {
    public static int solve(int X, int Y, String num) {
        int min=0;
        if (X > Y) {
            min = Y;
            Y = X;
            X = min;
        }
        int indexleft=0;
        for (int i=0;i<num.length();i++) {
            if (num.charAt(i)-'0' >= X) {
                indexleft = i;
            }
        }
        int indexright=0;
        for (int i=num.length()-1;i>=0;i--) {
            if (num.charAt(i)-'0' >= X) {
                indexright = i;
            }
        }
        if (indexleft == 0) {
            indexright = num.length() - 1;
        }
        for (int i=1;i<=indexright;i++) {
            try {
                if (Integer.parseInt(num.substring(0, i), X) == Integer.parseInt(num.substring(i), Y)) {
                    return Integer.parseInt(num.substring(0, i), X);
                }
            } catch (Exception e) {
                continue;
            }
        }
        for (int i=indexleft+1;i<num.length();i++) {
            try {
                if (Integer.parseInt(num.substring(0, i), Y) == Integer.parseInt(num.substring(i), X)) {
                    return Integer.parseInt(num.substring(0, i), Y);
                }
            } catch (Exception e) {
                continue;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i=0;i<T;i++) {
            int X=sc.nextInt();
            int Y = sc.nextInt();
            String num = sc.next();
            System.out.println(solve(X,Y,num));
        }
    }
}
