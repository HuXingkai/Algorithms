package reviewAlgorithms.DynamicProgramming;

/**
 * Created by andy on 2018/8/2.
 * 最长回文子串
 * 对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。
   给定字符串A以及它的长度n，请返回最长回文子串的长度。
   input:"abc1234321ab",12
    output: 7
 */
public class longest_palindromic_substring {
    public int[] getLongestPalindrome(String A, int n) {
        //用来返回最长回文子串的初始、结束位置以及长度，顺序为i, j, maxlength
        int[] ans = new int[3];
        //利用p[i][j]表示i-j的字符串是否为回文子串
        boolean [][] p=new boolean[n][n];
        int maxLength=1;
        //初始化，长度为1的字符串一定为回文串
        //长度为2 且二个元素相等的也是回文子串
        for (int i=0;i<n;i++) {
            p[i][i]=true;
            if (i < n - 1 && A.charAt(i)==A.charAt(i+1)) {
                p[i][i+1] = true;
                maxLength=2;
            }
        }
        //按照字串的长度遍历,注意len的长度最长可以为字符串最大长度
        for (int len=3;len<=n;len++) {
            //i代表初始位置，j代表字串结束的位置
            for (int i=0;i<=n-len;i++) {
                int j=len+i-1;
                //下面对应着递归方程
                if (A.charAt(i) == A.charAt(j)) {
                    p[i][j] = p[i + 1][j - 1];
                    //如果字串p[i + 1][j - 1]是回文，最大长度将拓展
                    if (maxLength < j - i + 1&&p[i + 1][j - 1]) {
                        maxLength = j - i + 1;
                        ans[0] = i;
                        ans[1] = j;
                        ans[2] = maxLength;
                    }
                } else p[i][j] = false;
            }
        }
        return ans;
    }

    public void print_LPS(String s, int n) {
        int[] a = getLongestPalindrome(s, n);
        System.out.println(s.substring(a[0],a[1]+1));
    }

    public static void main(String[] args) {
        String s = "abc1234321ab";
        longest_palindromic_substring lps = new longest_palindromic_substring();
        System.out.println(lps.getLongestPalindrome(s,12)[2]);
        lps.print_LPS(s,12);
    }
}
