package DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by andy on 2018/8/24.
 * http://www.voidcn.com/article/p-cofvtrlp-ny.html
 * 题目大意：有n种宝贝，第i种宝贝有i个，每种宝贝有一定的重量和价值，现在要拿走一些，重量不能超过m，求能拿走的宝贝的最大重量。

 题目分析：比赛的时候由于没有数据范围，所以怎么看都是背包，于是怎么提交都是悲剧。。。。看了数据范围，原来是搜索。直接爆搜。爆搜之前先贪心一下：由于总重量一定，所以每件宝贝用价值/重量得到一个参数，描述的是宝贝的单位重量的价值，简称单价。先从单价高的开始搜。由于加了贪心，所以当第一次发现恰好能组合m的重量的物品，答案一定是最优的。否则爆搜所有解求最优的。剪枝主要就4个：

 1。如果所有宝贝重量和不超过m，直接输出价值和。

 2。如果第一次搜到了恰好满足m的重量的物品，即找到最优解，不搜了。

 3。如果搜到某一种宝贝，发现剩下的总价值和当前总价值之和不大于ans，返回。

 4。如果搜到某一种宝贝，发现即使剩下的总重量都用来拿单价最高的宝贝，所获得的价值加上当前总价值不大于ans，返回。
 */
public class TheRobbery {
    public static List<Diamond> boxs = new ArrayList<>();
    public static long answer = 0;
    public static long[] sum;

    //定义一个类，用于存储每个箱子中钻石的重量、价值、以及数量信息
    //同时实现了comparable接口，以性价比来比较大小
    private static class Diamond implements Comparable{
        public long weight;
        public long value;
        public int num;

        @Override
        public int compareTo(Object o) {
            //按性价比排序,从大到小排列
            Diamond diamond = (Diamond) o;
            if (this.value / weight > diamond.value / diamond.weight) {
                return 1;
            }
            if (this.value / weight < diamond.value / diamond.weight) {
                return -1;
            }
            return 0;
        }
    }

    //剪枝方法
    public static boolean cut(int pos, long now_value, long last_weight) {
        //边界返回条件，已经到头了。
        if (pos >= boxs.size()) {
            return true;
        }
        ////如果后面所有的钻石加起来都<=ans，剪掉
        if (now_value + sum[pos] < answer) {
            return true;
        }
        //当前最大的性价比
        double best = boxs.get(pos).value*1.0 / boxs.get(pos).weight;
        //以这个性价比取剩下的所有重量，如果<=ans,剪掉
        if (now_value + best * last_weight < answer) {
            return true;
        }/**/
        return false;
    }

    //
    public static void dfs(int pos, long now_value, long last_weight) {
        answer = Math.max(answer, now_value);

        if (cut(pos, now_value, last_weight)) {
            return;
        }

        Diamond dia = boxs.get(pos);
        //(暴力搜索)枚举顺序从满到空枚举，这样才能最快找到ans，然后利用ans剪枝
        for (int i=dia.num;i>0;i--) {

            if (last_weight < dia.weight*i) {
                continue;
            }
            dfs(pos+1,now_value+i*dia.value,last_weight-dia.weight*i);
        }
        //！！！这一过程非常重要。如果上面的已经便利结束，还可以不选择这个钻石，从下一颗钻石开始继续遍历
        dfs(pos+1,now_value,last_weight);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        while (cases != 0) {
            cases--;
// 价值和重量的和；仅仅用到了一次（特殊情况才用到，能够一次全带走）
            long sumValue = 0;
            long sumWeight = 0;
            int n = scanner.nextInt();
            int weight = scanner.nextInt();
            for (int i=0;i<n;i++) {
                Diamond d = new Diamond();
                d.weight = scanner.nextInt();
                d.num = i + 1;
                sumWeight += d.weight;
                boxs.add(d);
            }
            for (int i=0;i<n;i++) {
                boxs.get(i).value = scanner.nextInt();
                sumValue += boxs.get(i).value*boxs.get(i).num;
            }
//剪枝之一，如果物品可以全部放到包里，开始就比m总重量还小，直接输出总物品的价值
            if (sumWeight < weight) {
                System.out.println(sumValue);
                continue;
            }

            Collections.sort(boxs);
            sum = new long[n+1];
            sum[n] = 0;
            //计算从当前位置开始，一直到最后的所有钻石的总价值之和
            //需要逆序计算
            for (int i=n-1;i>=0;i--) {
                sum[i] = sum[i + 1] + boxs.get(i).value * boxs.get(i).num;
            }

            dfs(0, 0, weight);
            System.out.println(answer);
        }
    }
}
