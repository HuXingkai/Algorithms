package reviewAlgorithms.DynamicProgramming;

/**
 * Created by andy on 2018/8/2.
 * 最长回文子序列
 * 给定字符串，求它的最长回文子序列长度。
 * 回文子序列反转字符顺序后仍然与原序列相同。例如字符串abcdfcba中，最长回文子序列长度为7，abcdcba或abcfcba。
 *
 */
public class longest_palindrome_subsequence {
    public int getLongestPalindromeSubsequence(String A, int n) {
        //p[i][j]记录i-j之间最长回文子序列的长度
        int[][] p = new int[n][n];
        for (int i=0;i<n;i++) {
            p[i][i] = 1;
        }
        //这里是状态转移方程中的一个特列，当j=i+1的时候，对应的是含有两个元素情绪，如果s[i]=s[j],按照方程p[i+1][j-1]
        //会出现p[2][1]的情况，将其值初始化为0
        //不是必须的，因为二元数组会自动初始化为0
        for (int i=1;i<n; i++) {
            p[i][i - 1] = 0;
        }
        //注意!!!i的取值不能从0开始递增，因为这样填动态规划表的时候，
        // 没有按照从最小规模的问题到大规模问题的顺序求解。
        for (int i=n-1;i>=0;i--) {

            for (int j=i+1;j<n;j++) {
                if (A.charAt(i) == A.charAt(j)) {
                    p[i][j]=p[i+1][j-1]+2;
                } else if (p[i][j - 1] > p[i + 1][j]) {
                    p[i][j] = p[i][j - 1];
                } else {
                    p[i][j] = p[i + 1][j];
                }
            }
        }
        return p[0][n - 1];
    }

    public static void main(String[] args) {
        String a = "abcdfcba";
        System.out.println(new longest_palindrome_subsequence().getLongestPalindromeSubsequence(a,a.length()));
    }
}
