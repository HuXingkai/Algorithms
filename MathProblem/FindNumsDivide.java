package MathProblem;

import java.util.Scanner;

/**
 * Created by andy on 2018/8/28.
 * 链接：https://www.nowcoder.com/questionTerminal/f216fb2b6fa84fcbb43537e22f1aa0d2
 来源：牛客网

 牛牛想在[a, b]区间内找到一些数满足可以被一个整数c整除,现在你需要帮助牛牛统计区间内一共有多少个这样的数满足条件？
 输入描述:
 首先输入两个整数a,b,（-5*10^8 ≤ a ≤ b ≤ 5*10^8) 接着是一个正整数c（1 <= c <= 1000）


 输出描述:
 输出一个整数表示个数。
 示例1
 输入
 0 14 5
 输出
 3
 */
public class FindNumsDivide {
    public static int find(long a, long b, long c) {
        int nums=0;
        long startNum=0;
        for (long i=a;i<=b;i++) {
            if (i % c == 0) {
                nums++;
                startNum=i;
                break;
            }
        }
        //找到了第一个整除的数之后，步长直接变为c，减少时间复杂度
        startNum+=c;
        while(startNum <= b){
            nums++;
            startNum+=c;
        }
        return nums;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long c = scanner.nextLong();
        System.out.println(find(a, b, c));
    }
}
