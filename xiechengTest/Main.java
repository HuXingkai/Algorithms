package xiechengTest;

import java.util.Scanner;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * https://www.nowcoder.com/questionTerminal/8ee967e43c2c4ec193b040ea7fbb10b8
 * Created by andy on 2018/9/4.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int ans=0;
        while (n!=0) {
            //n & 1，就是取n的二进制的最末尾，事实上
            if ((n&1)==1) {
                ans ++;
            }
            n=n>>1;
        }
        System.out.println(ans);
    }
}
