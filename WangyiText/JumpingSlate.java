package WangyiText;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by andy on 2017/8/22.
 * 小易来到了一条石板路前，每块石板上从1挨着编号为：1、2、3.......
 这条石板路要根据特殊的规则才能前进：对于小易当前所在的编号为K的 石板，
 小易单次只能往前跳K的一个约数(不含1和K)步，即跳到K+X(X为K的一个非1和本身的约数)的位置。
 小易当前处在编号为N的石板，他想跳到编号恰好为M的石板去，小易想知道最少需要跳跃几次可以到达。
 例如：
 N = 4，M = 24：
 4->6->8->12->18->24
 于是小易最少需要跳跃5次，就可以从4号石板跳到24号石板


 思路：将1-M个石板看做一个结果数组res，每个res[i]储存着从起点到这一步最小的步数，其中0为不能到达。
 从起点开始对res进行遍历，先求i的所有约数（即从res[i]能走的步数），然后更新那几个能到达的位置的最
 小步数（如果不能到达则更新为此时位置的最小步数+1，如果是能到达的就更新为min（已记录的最小步数，
 此处的最小步数+1）），遍历一遍后得到结果。
 */
public class JumpingSlate {
    /**
     * 利用空间换时间，思路如上所示
     */
    public static int minStep(int N, int M) {
        int[] res = new int[M+1];
        res[N]=1;
        for (int i=N;i<M;i++) {
            if (res[i] == 0) {
                //这个位置不能到达，不需要进行后面的最远位置判断
                continue;
            }

            //找到所有的约数
            List<Integer> allsteps = finddivisors(i);
            //遍历能前进的所有步数，保存最小步数。
            for (int j=0;j<allsteps.size();j++) {
                if ((allsteps.get(j) + i) <= M && res[allsteps.get(j) + i] != 0) {
                    res[allsteps.get(j) + i] = min(res[i] + 1, res[allsteps.get(j) + i]);
                } else if ((allsteps.get(j) + i) <= M) {
                    res[allsteps.get(j) + i] = res[i]+1;
                }
            }

        }
        //M位置如果没有被赋值，表明到达不了
        if (res[M] == 0) {
            return -1;
        }
        return res[M]-1;
    }

    public static int min(int n, int m) {
        if (n < m) {
            return n;
        }
        return m;
    }
    /**
  * 判断是否为整数
 * @param  double
 * @return 是整数返回true,否则返回false
*/
    public static boolean isInteger(double doubnum) {
        if ((doubnum - Math.round(doubnum)) == 0) {
            return true;
        }
        return false;
    }

    /**
    * 找到给定数的所有约数(除去1和本身)
    * 另外求一个数的所有约数，只需要检查2到其平方根之间的数就可以了，
    * 因为约数（除了平方根）都是成对的。采用这种方式算法复杂度可以由O(n)降到O(sqrt(n))。

    * */
    public static List<Integer> finddivisors(int a) {
        List<Integer> list = new ArrayList<>();

        for (int i=2;i<=Math.sqrt(a);i++) {
            if (isInteger((double) a / (double) i)) {
                list.add(i);
                if (a/i != i) {
                    list.add(a/i);
                }

            }
        }
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start=scanner.nextInt();
        int end = scanner.nextInt();
        /*int middle=start;
        int maxDivis=0;
        int min=0;
        List<Integer> divisorsList = new ArrayList<>();

        if (start != end) {
            while (end - middle > maxDivis) {

                divisorsList = finddivisors(middle);
                maxDivis = divisorsList.get(divisorsList.size() - 1);

                middle=middle+maxDivis;
                min++;
            }

            if (divisorsList.contains(end - middle)) {
                min+=1;
            }
            else min=-1;
        }*/
        int min = minStep(start, end);

        System.out.println(min);
    }
}
