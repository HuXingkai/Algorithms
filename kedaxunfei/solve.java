package kedaxunfei;

        import java.util.Arrays;
        import java.util.Scanner;

/**
 * Created by andy on 2018/9/7.
 */
public class solve {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i=0;i<T;i++) {
            int n = sc.nextInt();
            int aver = sc.nextInt();
            int[] score = new int[n];
            int sum=0;
            for (int j=0;j<n;j++) {
                score[j] = sc.nextInt();
                sum += score[j];
            }
            int chazhi = n * aver - sum;
            Arrays.sort(score);
            int num=0;
            int k=0;
            while (chazhi > 0) {
                chazhi=chazhi-100+score[k];
                num++;
                k++;
            }
            System.out.println(num);
        }
    }
}
