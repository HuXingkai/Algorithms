package WangyiText;

import java.util.*;

/**
 * Created by andy on 2017/9/2.
 *
 * 小易是一个数论爱好者，并且对于一个数的奇数约数十分感兴趣。一天小易遇到这样一个问题： 定义函数f(x)为x最大的奇数约数，x为正整数。 例如:f(44) = 11.
 现在给出一个N，需要求出 f(1) + f(2) + f(3).......f(N)
 例如： N = 7
 f(1) + f(2) + f(3) + f(4) + f(5) + f(6) + f(7) = 1 + 1 + 3 + 1 + 5 + 3 + 7 = 21
 小易计算这个问题遇到了困难，需要你来设计一个算法帮助他。
 时间复杂度为 O（n）
 */
public class Maxjiyueshu {
    //找到一个数的最大奇约数
    public static int f(int n) {


        //时间复杂度过大

        /*int maxDivor=1;
        for (int i=1;i<=Math.sqrt(n);i++) {
            if (n % i == 0) {
                if (i % 2 != 0 && i > maxDivor) {
                    maxDivor=i;
                }
                if (i != n / i) {
                    if (n / i % 2 != 0 && n / i > maxDivor) {
                        maxDivor=n/i;
                    }
                }
            }
        }*/
        /*if (n % 2 != 0) {
            return n;
        } else if ((n / 2 )% 2 != 0) {
            return n / 2;
        }
        else return 1;*/
        Map<Integer, Integer> map = new HashMap<>();
        int key=n;
        while (n % 2 == 0) {
            n=n/2;
            if (map.containsKey(n)) {
                return map.get(n);
            }
        }

        map.put(key, n);


        return n;
}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int answer=0;
        for (int i=1;i<=N;i++) {
            answer += f(i);
        }
        System.out.println(answer);
    }
}
