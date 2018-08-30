package MathProblem;

import java.util.Scanner;

/**
 * Created by andy on 2018/8/30.
 * 链接：https://www.nowcoder.com/questionTerminal/6ffdd7e4197c403e88c6a8aa3e7a332a
 来源：牛客网

 输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2
 输入描述:
 输入为一行，n(1 ≤ n ≤ 1000)


 输出描述:
 输出一个整数,即题目所求
 示例1
 输入
 10
 输出
 2
 */
public class EndZeroNums {
    /**
     * 统计末尾为0，2，5的个数，2和5可以乘变为一个0
     * 此方法有误，忽略了25，它包含两个5，乘以4可以增加2个0
     * @param n
     * @return
     */
    public static int findNums(int n) {
        int Num2=0;
        int Num5=0;
        int Num0=0;
        for (int i=1;i<=n;i++) {
            if (i % 10 == 2) {
                Num2++;
            }
            if (i % 10 == 5) {
                Num5++;
            }
            if (i % 10 == 0) {
                int j = i / 10;
                Num0++;
                while (j % 10 == 0) {
                    Num0++;
                    j /= 10;
                }
            }
        }
        Num0 += Num2 > Num5 ? Num5 : Num2;
        return Num0;
    }

    /**
     * 有0 ，则是由偶数和5乘到的。考虑5/5=1,25/5=5,125/5=25.所以即，5是一个5,25是两个五。125十三个5.所以统计
     * 所有相称的数种包含5的个数即0的个数
     * @param n
     * @return
     */
    public static int find5(int n) {
        int nums = 0;
        for (int i=5;i<=n;i=i+5) {
            int j = i;
            while (j % 5 == 0) {
                nums++;
                j /= 5;
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(findNums(n));
        System.out.println(find5(n));
    }
}
