package didiTest;

import java.util.Scanner;

public class NumZeroLast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int num=0;
        for (int i=n;i>=1;i--) {
            int now=i;
            while (now%5==0) {
                num++;
                now=now/5;
            }
        }
        System.out.println(num);
    }
}
