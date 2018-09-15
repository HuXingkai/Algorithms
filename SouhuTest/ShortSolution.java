package SouhuTest;

import java.util.Scanner;

/**
 * Created by andy on 2018/9/13.
 */
public class ShortSolution {
    public static int reachNUm(int target) {
        target = Math.abs(target);
        int step=0;
        int sum=0;
        while (sum < target) {
            step++;
            sum += step;
        }
        while ((sum - target) % 2 != 0) {
            step++;
            sum += step;
        }
        return step;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println(reachNUm(N));
    }
}
