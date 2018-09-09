package WangyiText.wangyihuyuTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by andy on 2018/9/9.
 * 功能：十进制转换成任意进制的方法
 * 求余数将其存入数组中
 */
public class jinzhizhuanhuan {
    public static void transform(int num, int n) {
        List<Integer> list = new ArrayList<>();
        while (num != 0) {
            list.add(num % n);
            num /= n;
        }
        show(list);
    }

    public static void show(List<Integer> list) {
        for (int i=list.size()-1;i>=0;i--) {
            if (list.get(i) > 9) {
                System.out.print((char)(list.get(i)+55));
            }
            else System.out.print(list.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int n = sc.nextInt();
        transform(num, n);
    }
}
