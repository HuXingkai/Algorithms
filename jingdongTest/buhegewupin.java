package jingdongTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by andy on 2018/9/9.
 * 每个物品有3个属性，分别为a,b,c
 * 如果存在一个物品，a,b,c都大于另一个物品，则另一个物品被称为不合格物品
 * 现在让你判断不合格物品的个数
 * 物品最多为500 000个
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