package reviewAlgorithms.DynamicProgramming;

import java.util.Scanner;

/**
 * Created by andy on 2018/8/4.
 * 暗黑字符串组合数
 * 一个字符串仅由’A’,’B’,’C’三个字符组成，若字符串中不存在’A’,’B’,’C’三个字符相邻的子串(比如ABC，BAC等)，则该字符串称为暗黑字符串，否则称为单纯字符串。
 * 求长度为L的此种字符串中有多少种是暗黑字符串？
 *长度为1的字符串中，暗黑字符串总共有3种(即”A”,”B”,”C”)，
 长度为2的字符串中，暗黑字符串总共有9种(两个位置，每个位置有三张可能，3*3=9)，
 长度为3的字符串中，暗黑字符串总共有21种(三个位置，每个位置有三种可能，总共有3*3*3=27种，去除纯净字符串3!=6，结果为27-6=21种)。
 *
 *
 */
public class blackString {
    //the number would be very large !!! we use long type
    public long findNumOfBlackString(int n) {
        //define a array to store the num of black string of n
        long [] p = new long [n+1];
        //init the p
        p[0] = 0;
        p[1] = 3;
        p[2] = 9;
        if (n < 3) {
            return p[n];
        }
        for(int i=3;i<=n;i++) {
            p[i] = 2 * p[i - 1] + p[i - 2];
        }
        return p[n];
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(new blackString().findNumOfBlackString(n));
    }
}
