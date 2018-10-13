package duxiaoman;

import java.util.Scanner;

/**
 * Created by andy on 2018/9/26.
 */
public class dp {
    static int a,b, n;
    public static boolean mypow(int k, int p) {
        long ans=1;
        a=k;
        while (p!=0) {
            if ((p&1)!=0) ans*=a;
            if (ans>=n) return false;
            a *= a;
            p /= 2;
        }
        return true;
    }

    public static int dfs(int a, int b) {
        if (a == 1) {
            if (!mypow(2,b)) return -1;
            if (dfs(2,b)==0) return 1;
            return 1 - dfs(a, b + 1);
        }
        if (mypow(a, b + 1) && dfs(a, b + 1)==0) return 1;
        if (mypow(a + 1, b) && dfs(a + 1, b)==0) return 1;
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i=0;i<T;i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            n = sc.nextInt();
            int ans = dfs(a, b);
            if (ans>0) System.out.println("B");
            else if (ans==0) System.out.println("A");
            else System.out.println("A&B");
        }
    }
}
