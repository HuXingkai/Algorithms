package jingdongTest;

import java.util.Scanner;

/**
 * Created by andy on 2018/9/13.
 * 题目描述：https://blog.csdn.net/wq_1995/article/details/82596235
 给定一张包含N个点、M条边的无向图，每条边连接两个不同的点，且任意两点间最多只有一条边。对于这样的简单无向图，如果能将所有点划分成若干个集合，使得任意两个同一集合内的点之间没有边相连，任意两个不同集合内的点之间有边相连，则称该图为完全多部图。现在你需要判断给定的图是否为完全多部图。

 输入
 第一行输入一个整数T表示数据组数，1≤T≤10。

 每组数据格式为：

 第一行包含两个整数N和M，1≤N≤1000，0≤M≤N(N-1)/2；

 接下来M行，每行包含两个整数X和Y，表示第X个点和第Y个点之间有一条边，1≤X，Y≤N。

 输出
 每组输出占一行，如果给定的图为完全多部图，输出Yes，否则输出No。

 样例输入
 2
 5 7
 1 3
 1 5
 2 3
 2 5
 3 4
 4 5
 3 5
 4 3
 1 2
 2 3
 3 4
 样例输出
 Yes
 No
 */
public class WanQuanDuoBuTu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //代表数据组数
        int a = sc.nextInt();
        while (a-- != 0) {
            //代表节点个数
            int b = sc.nextInt();
            //代表边的条数
            int c = sc.nextInt();
            int row = 0;
            int wid = 0;
            //用数组存储每个节点对应的度
            int[] sum = new int[b + 1];
            for (int i = 0; i < c; i++)
            {
                row = sc.nextInt();
                wid = sc.nextInt();
                sum[row]++;
                sum[wid]++;
            }
            int t = 0;
            //循环遍历节点可能的度的值，从0~n-1
            for (int i = 0; i < b - 1; i++)
            {
                //用来存储度位i的节点的个数
                int key = 0;
                //循环遍历每个节点，判断节点的度位i的共有几个，用key值存储
                for (int j = 1; j < b + 1; j++)
                    if (sum[j] == i)
                        key++;
                //如果节点的度的值+度位i的节点的个数<节点总数
                //则一定不是完全多部图
                //例如，假设一共有5个节点，其中一个节点度位1，这个的点作为一个集合，只能和其他一个集合相连，那么总体的集合数
                //只能是2个，因此另一个集合中的节点度位5-1=4；只有一个节点，而另一个集合中包含着4个度位1的节点，相互没有连接
                //只和度为4的节点相连。
                //综上所述，如果成为完全多部图，那么度为i的节点数key和i值有一定的约束:key >= b-i,（不能使集合数超过i+1）
                if (key + i < b && key != 0)
                {
                    t++;
                    break;
                }
            }
            if (t == 0)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
}
