package didiTest;
/**
 * 输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2
 输入描述:
 输入为一行，n(1 ≤ n ≤ 1000)


 输出描述:
 输出一个整数,即题目所求

 输入例子1:
 10

 输出例子1:
 2
 */

import java.util.HashMap;
import java.util.Map;
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
        System.out.println(find(n));
    }

    public static int find(int n) {
        int num=0;
        Map<Integer,Integer> map=new HashMap<>(1000);
        for(int i=1;i<=n;i++){
            int j=0;
            int now=i;
            while(now%5==0){
                j++;
                num++;
                now/=5;
                map.put(i,j);
                if(map.containsKey(now)){
                    num+=map.get(now);
                    j+=map.get(now);
                    map.put(i,j);
                    break;
                }
            }
        }
        return num;
    }
}
