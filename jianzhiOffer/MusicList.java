package jianzhiOffer;

import java.util.Scanner;

/**
 * Created by andy on 2018/8/31.
 */
public class MusicList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int A = sc.nextInt();
        int x = sc.nextInt();
        int B = sc.nextInt();
        int y = sc.nextInt();
        int numA = 0;
        int numB = 0;
        if (A == B) {
            numA = K / A;
            long n1 = 1;
            long n2 = 1;
            long sum = x + y;
            for (int i = 0; i < numA; i++) {
                n1 *= sum;
                sum--;
                n2 *= (i + 1);
            }
            System.out.println(n1 / n2 % 1000000007);
        } else {
            long ans=0;
            int maxnumA = K > A * x ? x : K / A;
            for (int i=0;i<=maxnumA;i++) {
                if ((K - (i * A))% B == 0) {
                    numB = (K - (i * A)) / B;
                    if (i <= x && numB <= y) {
                        ans += findC(i, x) * findC(numB, y);
                    }

                }
            }
            System.out.println(ans);
        }
    }

    public static long findC(int a, int x) {
        long n1 = 1;
        long n2 = 1;
        for (int i = 0; i < a; i++) {
            n1 *= x;
            x--;
            n2 *= (i + 1);
        }
        return (n1 / n2) % 1000000007;
    }
}
