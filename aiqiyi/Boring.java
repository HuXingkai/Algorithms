package aiqiyi;

import java.util.Scanner;

/**
 * Created by andy on 2017/10/14.
 */
public class Boring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int min=(n+1)/2;
        int max=(m+1+n)/2;
        int time=0;
        for (int i=min;i<=max;i++) {
            time += i;
        }
        int ave = time / (max - min + 1);
        System.out.println(ave);
    }
}

