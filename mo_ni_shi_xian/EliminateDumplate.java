package mo_ni_shi_xian;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by andy on 2018/8/30.
 * 链接：https://www.nowcoder.com/questionTerminal/0d241147265d4f64aacd1e2d3e46abc6
 来源：牛客网

 小易有一个长度为n序列，小易想移除掉里面的重复元素，但是小易想是对于每种元素保留最后出现的那个。小易遇到了困难,希望你来帮助他。
 输入描述:
 输入包括两行： 第一行为序列长度n(1 ≤ n ≤ 50) 第二行为n个数sequence[i](1 ≤ sequence[i] ≤ 1000)，以空格分隔


 输出描述:
 输出消除重复元素之后的序列，以空格分隔，行末无空格
 示例1
 输入
 9 100 100 100 99 99 99 100 100 100
 输出
 99 100
 */
public class EliminateDumplate {
    public static void elimamte(int n, int[] sequence) {
        Stack<Integer> stack = new Stack<>();
        for (int i=n-1;i>=0;i--) {
            if (!stack.contains(sequence[i])) {
                stack.push(sequence[i]);
            }
        }
        int count = stack.size();
        while (!stack.isEmpty()) {

            if (count != 1) {
                System.out.print(stack.pop()+" ");
            }
            else System.out.print(stack.pop());
            count--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ss = new int[n];
        for (int i=0;i<n;i++) {
            ss[i]=sc.nextInt();
        }
        elimamte(n, ss);
    }
}
