package jingdongTest;

/**
 * Created by andy on 2018/9/9.
 */
public class GoUpstairs {
    public void DFS(int m) {
        int[] dp = new int[m + 1];
        dp[1] = 0;dp[2] = 1;dp[3] = 2;
        for (int i=4;i<=m;i++) {
            dp[i] = (dp[i - 1]%1000000007 + dp[i - 2]%1000000007)%1000000007;
        }
        System.out.println(dp[m]);
    }

    public static void main(String[] args) {
        new GoUpstairs().DFS(3);
    }
}
