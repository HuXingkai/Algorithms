package huaweiTest;

import java.util.Scanner;

/**
 * Created by andy on 2018/9/16.
 */
public class ReverseStr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(reverseString(str));
    }

    public static String reverseString(String str) {
        String[] strs = str.split(" ");
        for (int i=0;i<strs.length;i++) {
            strs[i] = new StringBuilder(strs[i]).reverse().toString();
        }
        StringBuilder result = new StringBuilder();
        for (String s : strs) {
            result.append(s+" ");
        }
        return result.toString().trim();
    }
}
