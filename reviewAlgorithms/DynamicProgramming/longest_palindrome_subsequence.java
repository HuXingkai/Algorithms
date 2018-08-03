package reviewAlgorithms.DynamicProgramming;

import java.util.Arrays;

/**
 * Created by andy on 2018/8/2.
 * 最长回文子序列
 * 给定字符串，求它的最长回文子序列长度。
 * 回文子序列反转字符顺序后仍然与原序列相同。例如字符串abcdfcba中，最长回文子序列长度为7，abcdcba或abcfcba。
 *
 */
public class longest_palindrome_subsequence {
    public int[] b;
    public int len = 0;
    public int getLongestPalindromeSubsequence(String A, int n) {
        //int[] b 用来记录是回文序列的位置，便于输出
        b = new int[n]; //这样做可能缺少了d/f 的输出,因此需要判断一下记录位置的字符串和回文序列的长度
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
                    b[i] = 1; b[j] = 1;
                } else if (p[i][j - 1] > p[i + 1][j]) {
                    p[i][j] = p[i][j - 1];
                } else {
                    p[i][j] = p[i + 1][j];
                }
            }
        }
        //System.out.println(Arrays.deepToString(p));
        len=p[0][n - 1];
        return p[0][n - 1];

    }

    public void print_LPS(String s) {
        String maxStr = "";
        //利用一个数组记录字符串中需要输出的字符的位置
        int [] sta=new int[len];
        int j=0;
        for (int i=0;i<s.length();i++) {
            if (b[i] == 1) {
                maxStr+=s.charAt(i);
                //记录输出位置
                sta[j] = i;
                j++;
            }
        }
        //上述判断字符是否需要输出的时候，条件是A.charAt(i) == A.charAt(j)
        //有可能会丢失中间的单独的字符
        if (maxStr.length() == len) {
            System.out.println(maxStr);
        } else {
            //通过记录的字符位置，添加丢失的字符
            //丢失的字符能对应多种情况，如本例子中的d或f,这里为了简单，只输出一种情况。
            int index = sta[len / 2];
            String s1=maxStr.substring(0, len / 2 );
            String s2 = "" + s.charAt(index - 1);
            String s3 = maxStr.substring(len / 2 );
            maxStr = s1 + s2 + s3;
            System.out.println(maxStr);
        }
    }

    public static void main(String[] args) {
        String a = "abcdfcba";
        longest_palindrome_subsequence lps = new longest_palindrome_subsequence();
        System.out.println(lps.getLongestPalindromeSubsequence(a,a.length()));
        lps.print_LPS(a);
    }
}
