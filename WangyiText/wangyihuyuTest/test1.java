package WangyiText.wangyihuyuTest;

import java.util.Scanner;

/**
 * Created by andy on 2018/9/8.
 * 已知字符串全由大写字母组成，如果一个字符串中包含按递增顺序的连续的m个字母（m>=4）,可以把这m个字符简写成初始字符—结束字符形式
 * 如XYZABCDMM可以简写成XYZA-DMM
 * 现在输入一个字符串，输出简写后的形式
 */
public class test1 {
    public static String findstr(String str) {
        String ans = "";
        for (int i=0;i<str.length();i++) {
            if (str.charAt(i) == 'X' || str.charAt(i) == 'Y' || str.charAt(i) == 'Z') {
                ans += str.charAt(i);
                continue;
            }
            int j = i;
            while (j+1<=str.length()-1&&str.charAt(j + 1) == str.charAt(j) + 1) {
                j++;
            }
            if (j - i + 1 >= 4) {
                ans += str.charAt(i) + "-" + str.charAt(j);
            } else ans += str.substring(i, j + 1);
            i = j;
        }

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i=0;i<T;i++) {
            String str = sc.next();
            System.out.println(findstr(str));
        }
    }
}
