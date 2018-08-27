package backtracking;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by andy on 2018/8/27.
 * 一个袋子里面有n个球，每个球上面都有一个号码(拥有相同号码的球是无区别的)。如果一个袋子是幸运的当且仅当所有球的号码的和大于所有球的号码的积。
 例如：如果袋子里面的球的号码是{1, 1, 2, 3}，这个袋子就是幸运的，因为1 + 1 + 2 + 3 > 1 * 1 * 2 * 3
 你可以适当从袋子里移除一些球(可以移除0个,但是别移除完)，要使移除后的袋子是幸运的。现在让你编程计算一下你可以获得的多少种不同的幸运的袋子。

 对于任意两个正整数a,b如果满足 a+b>a*b，则必有一个数为1.可用数论证明：
 设a=1+x,b=1+y，则1+x+1+y>(1+x)*(1+y)，--->  1>x*y，则x，y必有一个为0，即a,b有一个为1.
 推广到任意k个正整数，假设a1,a2,...ak，如果不满足给定条件，即和sum小于等于积pi，
 如果此时再选择一个数b,能使其满足sum+b > pi*b，则，b必然为1，且为必要非充分条件。
 反之，如果选择的b>1，则sum+b <=pi*b，即a1,a2,...,ak,b不满足给定条件。（搜索剪枝的重要依据）

 */
public class LuckyBall {
    public static int dfs(int index, int sum, int multi, int[] balls) {
        int count = 0;
        for (int i=index;i<balls.length; i++) {
            sum += balls[i];
            multi *= balls[i];

            if (sum > multi) {
                count += 1 + dfs(i + 1, sum, multi, balls);
            } else if (balls[i] == 1) {
                count += dfs(i + 1, sum, multi, balls);
            } else break;

            sum -= balls[i];
            multi /= balls[i];

            while (i < balls.length - 1 && balls[i] == balls[i + 1]) {
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] balls = new int[n];
        for (int i=0;i<n;i++) {
            balls[i] = sc.nextInt();
        }

        Arrays.sort(balls);
        System.out.println(dfs(0, 0, 1, balls));
    }
}
