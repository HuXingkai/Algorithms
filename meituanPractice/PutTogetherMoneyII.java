package meituanPractice;
/**
 * 可以理解为 完全背包问题的变形
 * */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PutTogetherMoneyII {
    public static List<List<Integer>> result = new ArrayList<>();

    public static long dp(int[] array, int n, int sum) {
        long[][] dp = new long[n+1][sum+1];
        dp[0][0]=1;
        for (int i=1;i<=n;i++) {
            dp[i][0]=1;
            for (int j=1;j<=sum;j++) {
                //dp[1][j]=1;
                if (j < array[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else dp[i][j] = dp[i - 1][j] + dp[i - 1][j - array[i]];
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        int[] array = new int[]{0,1,5,10,20,50,100};


        //System.out.println(result);
        System.out.println(dp(array,6,sum));
    }
}
