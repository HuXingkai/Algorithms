package huaweiTest;

import java.util.Scanner;
import java.util.Stack;

/**有数字（0~9构成的正整数）、三种操作运算符（加法+、乘法*、自增^）、分隔符一个空格、左右括号

 表达式形式是“(运算符 参数)”形式

 比如(+ 3 4)，求值结果7；(+ (* 2 3)(^4))求值结果11

 语法树结束后，后面加任何字符都是合法的，比如(+ (* 2 3)(^4)))))))#$是合法的

 匆匆忙忙地写了一个，感觉太长了。。。应该有很大的优化空间。

 主要思路：用一个var类保存操作数，包括操作符和数字（存在联合体中，用一个枚举变量表示类型），
 然后遍历输入的字符串，将左括号、数字、操作符压入计算栈，当遇到右括号时，弹出数字和操作符进行计算，并弹出左括号，
 将结果压入。如果压入结果之后，计算栈大小为1，说明语法树结束啦，直接跳出。中间任何操作失败，都跳出输出-1，
 主要是这个的判断占了很大篇幅，得想办法优化。
 * Created by andy on 2018/9/16.
 */
public class LISPyuansuan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(solve(str));

    }

    public static int solve(String str) {
        Stack<String> stack = new Stack<>();
        for (int i=0;i<str.length();i++) {
            if (str.charAt(i) <= '9' && str.charAt(i) >= '0') {
                String tem = str.charAt(i)+"";
                int Numindex = i + 1;
                while (str.charAt(Numindex) > '9' && str.charAt(Numindex) < '0') {
                    Numindex++;
                    tem = tem + str.charAt(Numindex);
                }
                stack.add(tem);
            } else if (str.charAt(i) != ')'&&str.charAt(i) != ' ') {
                stack.add(str.charAt(i) + "");
            }
            if (str.charAt(i) == ')') {
                int a = Integer.parseInt(stack.pop());
                String b = stack.pop();
                if (b.equals("^")) {
                    a++;
                    stack.pop();
                    stack.add(a + "");
                } else {
                    int c = Integer.parseInt(b);
                    String d = stack.pop();
                    stack.pop();
                    if (d.equals("+")) {
                        a += c;
                        stack.add(a + "");
                    }
                    if (d.equals("*")) {
                        a *= c;
                        stack.add(a + "");
                    }
                }
                if (stack.size() == 1) {
                    return Integer.parseInt(stack.pop());
                }
            }
        }
        return -1;
    }
}
