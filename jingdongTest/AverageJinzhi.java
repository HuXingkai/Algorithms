package jingdongTest;

import java.util.Scanner;

/**https://www.nowcoder.com/profile/2475858/test/18412018/105619
 * Created by andy on 2018/9/9.
 */
public class AverageJinzhi {
    public static int findsum(int num, int n) {
        int sum=0;
        while (num != 0) {
            sum+=num % n;
            num /= n;
        }
        return sum;
    }

    /**
     * 欧几里得的辗转相除法计算的是两个自然数a和b的最大公约数g
     * 原理：两个整数的最大公约数等于其中较小的数和两数的差的最大公约数
     * 在欧几里得最初的描述中，商和余数是通过连续的减法来计算的，即从rk−2中不断减去rk−1直到小于rk−1。
     * 一个更高效的做法是使用整数除法和模除来计算商和余数：
     * @param a
     * @param b
     * @return
     */
    public static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else return gcd(b,a % b);//这里b安放在了前面，保证是大数%小数
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int A = sc.nextInt();
            int sum=0;
            for (int i=2;i<=A-1;i++) {
                sum += findsum(A, i);
            }
            System.out.println(sum/gcd(sum,A-2)+"/"+(A-2)/gcd(sum,A-2));
        }

    }
}
