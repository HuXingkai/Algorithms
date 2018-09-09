package jingdongTest;

import java.util.Collections;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**https://www.nowcoder.com/profile/2475858/test/18412018/105619
 * Created by andy on 2018/9/9.
 */
public class SumSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> set = new TreeSet<>();
        int a = sc.nextInt();
        int b = sc.nextInt();
        for (int i=0;i<a;i++) {
            set.add(sc.nextInt());
        }
        for (int i=0;i<b;i++) {
            set.add(sc.nextInt());
        }
        int index=0;
        for (int i : set) {
            if (index != set.size() - 1) {
                System.out.print(i + " ");
            }
            else System.out.print(i);
            index++;
        }
    }
}
