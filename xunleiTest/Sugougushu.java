package xunleiTest;

import java.util.Scanner;

/**
 * Created by andy on 2018/9/12.
 */
public class Sugougushu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result=0;
        for(int i=1 ; i<=N ; i++){
            for(int j=i+1 ; j<=N ; j++){
                int sum = i*i+j*j;
                int c = (int)Math.sqrt(sum);
                if(c*c==sum && c<=N&&gcd(i,j)==1&&gcd(i,c)==1&&gcd(j,c)==1){
                    result++;
                }

            }
        }
        System.out.println(result);

    }
    public static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else return gcd(b,a % b);//这里b安放在了前面，保证是大数%小数
    }
}
