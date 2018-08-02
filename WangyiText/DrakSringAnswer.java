package WangyiText;

import java.util.Scanner;

/**
 * Created by andy on 2017/9/2.
 */
public class DrakSringAnswer {
    public static int getNum(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 3;
        }
        if (n == 2) {
            return 9;
        }
        return getNum(n - 2) + 2 * getNum(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getNum(n));
        int aa=6;int bb=12;
        int a=++aa*bb++;
        System.out.println(a);
    }
}
