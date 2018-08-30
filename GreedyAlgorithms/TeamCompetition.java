package GreedyAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by andy on 2018/8/30.
 * 链接：https://www.nowcoder.com/questionTerminal/6736cc3ffd1444a4a0057dee89be789b
 来源：牛客网

 牛牛举办了一次编程比赛,参加比赛的有3*n个选手,每个选手都有一个水平值a_i.现在要将这些选手进行组队,一共组成n个队伍,即每个队伍3人.牛牛发现队伍的水平值等于该队伍队员中第二高水平值。
 例如:
 一个队伍三个队员的水平值分别是3,3,3.那么队伍的水平值是3
 一个队伍三个队员的水平值分别是3,2,3.那么队伍的水平值是3
 一个队伍三个队员的水平值分别是1,5,2.那么队伍的水平值是2
 为了让比赛更有看点,牛牛想安排队伍使所有队伍的水平值总和最大。
 如样例所示:
 如果牛牛把6个队员划分到两个队伍
 如果方案为:
 team1:{1,2,5}, team2:{5,5,8}, 这时候水平值总和为7.
 而如果方案为:
 team1:{2,5,8}, team2:{1,5,5}, 这时候水平值总和为10.
 没有比总和为10更大的方案,所以输出10.

 输入描述:
 输入的第一行为一个正整数n(1 ≤ n ≤ 10^5)

 第二行包括3*n个整数a_i(1 ≤ a_i ≤ 10^9),表示每个参赛选手的水平值.


 输出描述:
 输出一个整数表示所有队伍的水平值总和最大值.
 示例1
 输入
 2
 5 2 8 5 1 5
 输出
 10


 链接：https://www.nowcoder.com/questionTerminal/6736cc3ffd1444a4a0057dee89be789b
 来源：牛客网

 思路是这样的 先排序
 * 比如排完序 1 2 3 4 5 6 7 8 9 这九个数
 * 组队思路是这样的 第一个最后两个 1 8 9
* 剩下 2 3 4 5 6 7
* 第一个最后两个                 2 6 7
* 剩下                           3 4 5
* 就是第一个和最后两个 再把已经组队的删掉 然后在循环 第一个最后两个
 * 那么中位数可以看到是 8 6 4
 找到中位数在整个排序后的素组和下标的规则是 data[data.length-(2*(i+1))]
* 再加在一起
 * 最重要的是 result一定要是long的 一定 一定 int会越界

 贪心的每次选区倒数第二大的作为平均水平值
 */
public class TeamCompetition {
    public static long team(int n,long [] num) {
        Arrays.sort(num);
        long averMax = 0;
        int index = n * 3 - 2;
        for (int i=0;i<n;i++) {
            averMax += num[index];
            index -= 2;
        }
        return averMax;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long [] num = new long [n * 3];
        for (int i=0;i<n*3;i++) {
            num[i] = scanner.nextLong();
        }
        System.out.println(team(n, num));
    }
}

