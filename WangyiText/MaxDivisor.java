package WangyiText;

import java.util.Scanner;

/**
 * Created by andy on 2017/9/2.
 * 最大奇约数的优化解法
 * 总体思路：
 因为奇数的最大奇数约数就是自己啊，对于偶数我们只能一直除2直到得到一个奇数即为最大奇数约数

 比如1 2 3 4 5 6 7 8 9 10
 即n=10 ，此时奇数有1 3 5 7 9 我们把这几个奇数相加然后n/2
 得到第二轮序列序列 1 2 3 4 5 分别对应上次的2 4 6 8 10 五个偶数，这是我们再加1 3 5
 依次类推
 */
/**
     * 奇数的最大约数就是本身。问题就是求所有f(i), i为偶数的和 因为要求的是最大奇约数，所以f(2k) = f(k)，所以f(2) + f(4)
     * + ... + f(2k) = f(1) + f(2) + ... + f(k);
     *
     * sum(n) = sum (n / 2) + 1 + 3 + ... + n - 1 = sum (n/2) + n*n/4（n 为偶数）
     *
     *        = sum (n - 1) + n （n为奇数）
     *
     *divisor 时间复杂度为 O(lgn)
     */
public class MaxDivisor {

    public static long sumOfMaxOdd(long n) {
        if (n == 1) {
            return 1;
        }
        if (n % 2 == 0) {
            return sumOfMaxOdd(n / 2) + n * n / 4;
        } else {
            return sumOfMaxOdd(n - 1) + n;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(sumOfMaxOdd(n));
        }
    }
}
