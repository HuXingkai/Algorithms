package huaweiTest;

import java.util.Scanner;

/**第一题 求26进制的和
 给出两个26进制的数，求和
 a代表0，z代表25
 https://blog.csdn.net/whl_program/article/details/82431562
 * Created by andy on 2018/9/16.
 */
public class SumOf26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        sum(a, b);
    }

    public static void sum(String a, String b) {
        int jinwei=0;
        int length = Math.max(a.length(), b.length());
        int cha = Math.abs(a.length() - b.length());
        String str = "";
        for (int i=0;i<cha;i++) {
            str += "a";
        }
        if (a.length() > b.length()) b = str + b;
        else a = str + a;

        String answer = "";
        for (int i=length-1;i>=0;i--) {
            int num = (a.charAt(i) - 'a') + (b.charAt(i) - 'a');

            char temp = (char) ('a' + (num) % 26 + jinwei);
            answer = temp + answer;

            if (num > 25) {
                jinwei=1;
            }else jinwei=0;
        }
        System.out.println(answer);
    }
}
