package jingdongTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by andy on 2018/9/9.
 * https://blog.csdn.net/wq_1995/article/details/82596235
 * 题目描述：
 现有n个物品，每个物品有三个参数 ai , bi , ci ，定义i物品不合格品的依据是 : 若存在物品 j , 且aj>ai , bj>bi , cj>ci，则称i物品为不合格品。

 现给出n个物品的a,b,c参数，请你求出不合格品的数量。

 输入
 第一行包含一个整数n(1<=n<=500000),表示物品的数量。接下来有n行，每行有三个整数，ai,bi,ci表示第i个物品的三个参数，1≤ai,bi,ci≤109。

 输出
 输出包含一个整数，表示不合格品的数量。

 样例输入
 3
 1 4 2
 4 3 2
 2 5 3
 样例输出
 1
 *
 */
public class buhegewupin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<item> list = new ArrayList<>();
        for (int i=0;i<n;i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong();
            list.add(new item(a, b, c));
        }
        //Collections.sort(list);
        long start = System.currentTimeMillis();
        int ans=0;
        for (int i=0;i<n-1;i++) {
            for (int j=i+1;j<n;j++) {
                if (list.get(i).compareTo(list.get(j)) == -1) {
                    ans++;
                    break;
                }
            }

        }
        System.out.println(ans);
        long end = System.currentTimeMillis();
        System.out.println("运行时间："+(end-start));
    }
}
class item implements Comparable{
    long a;
    long b;
    long c;

    public item(long aa, long bb, long cc) {
        a=aa;
        b=bb;
        c = cc;
    }

    @Override
    public int compareTo(Object o) {
        item it = (item) o;
        if (a < it.a && b < it.b && c < it.c) {
            return -1;
        }
        else if (a > it.a && b > it.b && c > it.c) {
            return 1;
        }
        return 0;
    }
}