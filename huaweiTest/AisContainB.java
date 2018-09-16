package huaweiTest;

import java.util.Scanner;

/**判断字符串b中的字符是否都在a中
 * https://blog.csdn.net/whl_program/article/details/82431562
 * Created by andy on 2018/9/16.
 */
public class AisContainB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        System.out.println(ifContains(a, b));
    }

    public static boolean ifContains(String a, String b) {
        for (int i=0;i<b.length();i++) {
            String now = b.charAt(i)+"";
            if (!a.contains(now)) {
                return false;
            }
        }
        return true;
    }
}
