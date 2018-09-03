package Mytest;

import java.util.Scanner;

public class Reverse {
    public static String rev(String str, int stat, int edn) {
        String str1 = new StringBuffer(str.substring(stat, edn)).reverse().toString();
        return str1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int k = in.nextInt();
        int step = 3 * k;
        int length = str.length();
        int lnow = 0;
        String ans = "";

        if (length < k) {
            ans += rev(str, 0, length);
        }
        for (int i=0;i<length;i=i+step) {
            lnow = i;
            int num = i + k;
            if (num >= length || i + step >= length) {
                break;
            }
            ans += rev(str, i, num) + str.substring(i + k, i + step);

        }
        if (lnow + k > length) {
            ans += rev(str, lnow, length);
        } else {
            ans += rev(str, lnow, lnow+k) + str.substring(lnow+k, length);
        }

        System.out.println(ans);
    }
}
