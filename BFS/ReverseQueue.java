package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by andy on 2018/8/22.
 * 给定序列1 2 3 4 5 6，再给定一个k，我们给出这样的操作：对于序列，我们可以将其中k个连续的数全部反转过来，
 * 例如k = 3的时候，上述序列经过1步操作后可以变成：3 2 1 4 5 6 ，如果再对序列 3 2 1 4 5 6进行一步操作，
 * 可以变成3 4 1 2 5 6.
 */
public class ReverseQueue {
    public static int findsteps(String start, String end, int k) {
        //存储将要访问的节点
        Queue<String> queue = new LinkedList<>();
        //HashSet的作用是在O(1)的时间复杂度内取出某个值，判断某个值是否存在
        Set<String> visited = new HashSet<>();
        int num=0;
        int count = 1;
        queue.add(start);
        while (!queue.isEmpty()) {
            String now = queue.poll();
            count--;
            visited.add(now);
            if (now.equals(end)) {
                return num;
            }
            for (int i=0;i<=now.length()-k;i++) {
                String strTem = reverse(now,i,k);
                if (!visited.contains(strTem)) {
                    queue.add(strTem);
                }
            }
            //每当count=0的时候，表明当前步数图的所有分支已经走完。搜索层数（num）加一，
            // 然后记录当前的queue的长度，代表当前图的分支数
            //这步操作很巧妙!!!
            if (count == 0) {
                num++;
                count = queue.size();
            }
        }
        return 0;
    }

    /**
     * 字符串部分反转的方法
     * 用到 StringBuffer类
     * @param str
     * @param i 开始反转的位置
     * @param k 反转字符串的长度
     * @return
     */
    public static String reverse(String str, int i, int k) {
        String str0 = str.substring(0, i);
        String str1 = str.substring(i, i + k);
        String str2 = str.substring(i + k);
        String reverseStr1 = new StringBuffer(str1).reverse().toString();
        return str0 + reverseStr1 + str2;
    }

    public static void main(String[] args) {
        String start = "123456";
        String end = "341652";
        int k = 3;
        System.out.println(findsteps(start, end, k));
    }
}
