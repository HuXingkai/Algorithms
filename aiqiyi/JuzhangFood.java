package aiqiyi;

import java.util.Scanner;

/**
 * Created by andy on 2018/9/15.
 */
public class JuzhangFood {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int P = scanner.nextInt();
        int [] food=new int[N];
        for (int i=0;i<N;i++) {
            food[i] = scanner.nextInt();
        }
        for (int j=0;j<M;j++) {
            String move=scanner.next();
            int index = scanner.nextInt();
            if (move.equals("A")) {
                food[index - 1]++;
            }
            if (move.equals("B")) {
                food[index - 1]--;
            }
        }

        int bigger=0;
        for (int i : food) {
            if (i > food[P - 1]) {
                bigger++;
            }
        }
        System.out.println(bigger+1);
    }
}
