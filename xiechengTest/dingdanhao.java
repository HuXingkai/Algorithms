package xiechengTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by andy on 2018/9/4.
 */
public class dingdanhao {
    static List<Integer> anslist = new ArrayList<>();
    public static void find(List<dingdan> list,int p,int r, int key) {
        if (p <= r) {
            int q = (r + p) / 2;
            if (list.get(q).inTime <= key&&list.get(q).outTime>=key) {
                anslist.add(list.get(q).num);
            }
            if (list.get(q).inTime > key) {
                find(list, p, q-1, key);
            }
            find(list, q+1, r, key);
        }
        return;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<dingdan> list = new ArrayList<>();
        int findnum = sc.nextInt();
        for (int i=0;i<n;i++) {
            int num = sc.nextInt();
            int in = sc.nextInt();
            int out = sc.nextInt();
            dingdan d = new dingdan(num, in, out);
            list.add(d);
        }

        Collections.sort(list);
        find(list, 0, list.size()-1,findnum);
        Collections.sort(anslist);
        if (anslist.size() == 0) {
            System.out.println("null");
        }
        else {
            for (Integer thenum : anslist) {
                System.out.println(thenum);
            }
        }
    }
}
class dingdan implements Comparable{
    int num;
    int inTime;
    int outTime;

    public dingdan(int n, int i, int o) {
        num = n;
        inTime=i;
        outTime=o;
    }

    @Override
    public int compareTo(Object o) {
        dingdan d = (dingdan) o;
        if (d.inTime < inTime) {
            return 1;
        } else if (d.inTime > inTime) {
            return -1;
        }
        return 0;
    }
}