package mo_ni_shi_xian;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by andy on 2018/8/30.
 * 链接：https://www.nowcoder.com/questionTerminal/9d5fbe7750a34d0b91c73943f93b2d7d
 来源：牛客网

 如果一个单词通过循环右移获得的单词，我们称这些单词都为一种循环单词。 例如：picture 和 turepic 就是属于同一种循环单词。 现在给出n个单词，需要统计这个n个单词中有多少种循环单词。
 输入描述:
 输入包括n+1行：

 第一行为单词个数n(1 ≤ n ≤ 50)

 接下来的n行，每行一个单词word[i]，长度length(1 ≤ length ≤ 50)。由小写字母构成


 输出描述:
 输出循环单词的种数
 示例1
 输入
 5
 picture
 turepic
 icturep
 word
 ordw
 输出
 2
 */
public class LoopWord {
    public static int find(int n, String[] words) {
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        for (int i=1;i<n;i++) {
            boolean flag = true;
            for (String s:list) {
                if (ifSame(s, words[i])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(words[i]);
            }
        }
        return list.size();
    }

    public static boolean ifSame(String a, String b) {
        for (int i=0;i<a.length();i++) {
            String tep = a.substring(i, a.length()) + a.substring(0, i);
            if (tep.equals(b)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] words = new String[n];
        for (int i=0;i<n;i++) {
            words[i] = scanner.next();
        }
        System.out.println(find(n, words));
    }
}
