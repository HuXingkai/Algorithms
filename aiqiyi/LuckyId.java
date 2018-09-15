package aiqiyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by andy on 2018/9/15.
 */
public class LuckyId {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.next();
        System.out.println(luckystep(num));
    }

    public static int luckystep(String num) {
        int before=0;
        int after=0;
        for (int i=0;i<num.length();i++) {
            if (i < 3) {
                before+=num.charAt(i)-'0';
            }else after+=num.charAt(i)-'0';
        }
        if (before==after) return 0;

        int cha=Math.abs(before-after);

        String str = before > after ? num.substring(3) : num.substring(0, 3);
        String str1 = before < after ? num.substring(3) : num.substring(0, 3);
        int[] arr = new int[3];
        int[] arr1 = new int[3];
        for (int i=0;i<3;i++) {
            arr[i] = str.charAt(i) - '0';
            arr1[i] = str1.charAt(i) - '0';
        }
        Arrays.sort(arr);
        Arrays.sort(arr1);
        int a = minus(arr, cha);
        int b = max(arr1, cha);
        return a > b ? b : a;

    }

    public static int minus(int[] arr, int cha) {
        int count=1;
        int index=0;
        while (true) {
            for (int i=0;i<3;i++) {
                if (arr[i] + cha < 10) {
                    return count;
                }
            }

            cha=cha-(9-arr[index]);
            arr[index]=9;
            index++;
            count++;
        }
    }
    public static int max(int[] arr1, int cha) {
        int[] arr = new int[3];
        for (int i=0;i<3;i++) {
            arr[i] = arr1[2 - i];
        }
        int count=1;
        int index=0;
        while (true) {
            for (int i=0;i<3;i++) {
                if (arr[i] - cha >=0) {
                    return count;
                }
            }

            cha=cha-arr[index];
            arr[index]=0;
            index++;
            count++;
        }
    }
}
