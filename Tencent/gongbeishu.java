package Tencent;

import java.util.Scanner;

/**
 * Created by andy on 2018/9/16.
 */
public class gongbeishu {
    public static long commonDivisor(long n,long m){
//辗转相除是用大的除以小的。如果n<m，第一次相当n与m值交换
        while(n%m!=0){
            long temp=n%m;
            n=m;
            m=temp;
        }
        return m;
    }
    //求两个数最小公倍数
    public static long commonMultiple(long n,long m){
        return n*m/commonDivisor(n,m);
    }
    //求多个数的最小公倍数
    public static long commonMultiple(long[] a){
        long value=a[0];
        for(int i=1;i<a.length;i++){
            value=commonMultiple(value,a[i]);
        }
        return value;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m=n+1;
        while (true) {

            long[] a = new long[m - n];
            for (int i=0;i<m-n;i++) {
                a[i] = n + 1 + i;
            }
            long[] a1 = new long[m];
            for (int i=0;i<m;i++) {
                a1[i] = i + 1;
            }
            if (commonMultiple(a) == commonMultiple(a1)) {
                System.out.println(m);
                break;
            }
            m++;
        }
    }
}
