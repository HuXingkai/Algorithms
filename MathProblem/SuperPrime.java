package MathProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by andy on 2018/8/28.
 * 链接：https://www.nowcoder.com/questionTerminal/fb511c3f1ac447309368d7e5432c6c79
 来源：牛客网

 如果一个数字能表示为p^q(^表示幂运算)且p为一个素数,q为大于1的正整数就称这个数叫做超级素数幂。现在给出一个正整数n,如果n是一个超级素数幂需要找出对应的p,q。
 输入描述:
 输入一个正整数n(2 ≤ n ≤ 10^18)


 输出描述:
 如果n是一个超级素数幂则输出p,q,以空格分隔,行末无空格。 如果n不是超级素数幂，则输出No
 示例1
 输入
 27
 输出
 3 3
 */
public class SuperPrime {
    public static List<String> listAns = new ArrayList<>();
    public static void findPrime(long n) {
        List<Integer> list = new ArrayList<>();
        for (int i=3;i<Math.sqrt(n);i++) {
            if (ifPrime(i)) {
                list.add(i);
            }
        }
        for (int i=0;i<list.size();i++) {
            int mi=2;
            while (Math.pow(list.get(i),mi) <= n) {
                if (Math.pow(list.get(i), mi) == n) {
                    listAns.add(list.get(i) + " " + mi);
                    return;
                }
                mi++;
            }
        }
    }

    public static void find(long n) {
        double p;
        //幂指数从2开始增加
        for (long q=2;q*q<n;q++) {
            //1d代表double类型，这里用分数次幂，直接求底数的值，再判断是否为素数
            //(long)p == p 判断p经过 Math.pow((double) num, 1d/q)后是否为整数
            //这个方法很巧妙！！！如果是整数，那就说明p^q=n,然后再判断是否为素数
            p = Math.pow(n, 1d / q);
            if ((long) p == p && ifPrime((long) p)) {
                listAns.add((long)p + " " + q);
            }
        }
    }

    public static boolean ifPrime(long n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        findPrime(n);
        for (String str : listAns) {
            System.out.print(str);
        }
        if (listAns.size() == 0) {
            System.out.println("No");
        }
    }
}
