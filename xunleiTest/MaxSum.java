package xunleiTest;

import java.util.Scanner;

/**
 * Created by andy on 2018/9/12.
 */
public class MaxSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        int C = -B;
        int num = C / A >= 1 ? C / A : A / C;

        if (C > A) {
            int numofB = 7 / (num+1);
            System.out.println(2 * numofB * B + (17 - 2 * numofB) * A);
        }

        if (C < A) {
            int numofA = 7 / (num + 2);
            if (num + 2 == 3) {
                System.out.println(2 * (17 - 2 * numofA-1) * B + (2 * numofA+1) * A);
            }
            System.out.println(2 * (17 - 2 * numofA) * B + (2 * numofA) * A);
        }
    }
}
