package jingdongTest;

import java.util.Scanner;

/**https://www.nowcoder.com/profile/2475858/test/18412018/105619
 * Created by andy on 2018/9/9.
 */
public class LuckyNum {
    public static int findsum(int num, int n) {
        int sum=0;
        while (num != 0) {
            sum+=num % n;
            num /= n;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int num = 0;
        for (int i=1;i<=n;i++) {
            if (findsum(i, 10) == findsum(i, 2)) {
                num++;
            }
        }
        System.out.println(num);
    }
}
