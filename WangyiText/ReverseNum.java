package WangyiText;

import java.util.Scanner;

/**
 * Created by andy on 2017/9/2.
 *
 * 对于一个整数X，定义操作rev(X)为将X按数位翻转过来，并且去除掉前导0。例如:
 如果 X = 123，则rev(X) = 321;
 如果 X = 100，则rev(X) = 1.
 现在给出整数x和y,要求rev(rev(x) + rev(y))为多少？
 */
public class ReverseNum {
    public static int rev(int num) {
        String strnum=""+num;
        int length=strnum.length();
        String revStr = "";
        for (int i=0;i<length;i++) {
            revStr += strnum.charAt(length - i - 1);
        }
        while (revStr.charAt(0) == '0') {
            revStr = revStr.substring(1);
        }
        return Integer.parseInt(revStr);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int str1=scanner.nextInt();
        int str2 = scanner.nextInt();
        System.out.println(rev(rev(str1)+rev(str2)));
    }
}
