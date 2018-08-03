package reviewAlgorithms.DynamicProgramming;

/**
 * Created by andy on 2018/8/3.
 * 回文子序列个数
 * 给定字符串，求它的回文子序列个数。回文子序列反转字符顺序后仍然与原序列相同。例如字符串aba中，
 * 回文子序列为"a", "a", "aa", "b", "aba"，共5个。内容相同位置不同的子序列算不同的子序列。
 *
 */
public class number_of_palindromic {
    public int getPalindromeSubsequenceNum(String A, int n) {
        //dp[i][j]记录i-j之间回文子序列的个数
        int[][] dp = new int[n][n];
        for (int i=n-1;i>=0;i--) {
            dp[i][i] = 1;
            for (int j=i+1;j<n;j++) {
                if (A.charAt(i) != A.charAt(j)) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] + 1;
                }
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        String str = "aba";
        number_of_palindromic nop = new number_of_palindromic();
        System.out.println(nop.getPalindromeSubsequenceNum(str,str.length()));
    }
}
