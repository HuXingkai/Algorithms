package didiTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数
 输入描述:
 输入为一行，M(32位整数)、N(2 ≤ N ≤ 16)，以空格隔开。


 输出描述:
 为每个测试实例输出转换后的数，每个输出占一行。如果N大于9，则对应的数字规则参考16进制（比如，10用A表示，等等）

 输入例子1:
 7 2

 输出例子1:
 111
 */
public class Conversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        conver(m,n);
        boolean negative=false;
        if (m<0){
            negative = true;
            m=-m;
        }


        List<String> list = new ArrayList<>();
        int result=m;
        int remainder;
        while (!(result == 0)) {
            remainder=result%n;
            result=result/n;

            if (remainder <10) {
                list.add(remainder+"");
            }
            else {
                switch (remainder) {
                    case 10:
                        list.add("A");break;
                    case 11:
                        list.add("B");break;
                    case 12:
                        list.add("C");break;
                    case 13:
                        list.add("D");break;
                    case 14:
                        list.add("E");break;
                    case 15:
                        list.add("F");break;
                }
            }
        }
        if (negative) {
            System.out.print("-");
        }
        for (int i=list.size()-1;i>=0;i--) {
            System.out.print(list.get(i));
        }
    }

    /**
     * 用栈的数据结构，实现了先入后出，复合“余数的倒序”输出
     * 另外利用字符的特点，简化了当N大于9，则对应的数字规则参考16进制（比如，10用A表示，等等）的判断
     * @param m
     * @param n
     */
    public static void conver(int m, int n) {
        Stack<String> stack = new Stack<>();
        boolean flag = false;
        if (m < 0) {
            flag = true;
        }
        m = Math.abs(m);

        while (m != 0) {
            int tem = m % n;
            String str = ""+tem;
            if (tem > 9) {
                str=(char)(tem+'A'-10)+"";
            }
            stack.push(str);
            m /= n;
        }

        if (flag) System.out.print("-");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println();
    }
}
