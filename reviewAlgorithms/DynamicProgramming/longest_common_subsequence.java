package reviewAlgorithms.DynamicProgramming;

/**
 * Created by andy on 2018/8/2.
 * 经典的最长公共子序列（LCS）问题：
 * 1. 子序列(subsequence)： 一个特定序列的子序列就是将给定序列中零个或多个元素去掉后得到的结果(不改变元素间相对次序)。
 * 例如序列<A,B,C,B,D,A,B>的子序列有：<A,B>、<B,C,A>、<A,B,C,D,A>等。
   2.公共子序列(common subsequence)： 给定序列X和Y，序列Z是X的子序列，也是Y的子序列，则Z是X和Y的公共子序列。
   例如X=<A,B,C,B,D,A,B>，Y=<B,D,C,A,B,A>，那么序列Z=<B,C,A>为X和Y的公共子序列，其长度为3。但Z不是X和Y的最长公共子序列，
   而序列<B,C,B,A>和<B,D,A,B>也均为X和Y的最长公共子序列，长度为4，而X和Y不存在长度大于等于5的公共子序列。
 * 算法导论 P222
 */
public class longest_common_subsequence {
    public int [][] b;
    public int findLCS(String A, int n, String B, int m) {
        //建立一个表用于存储LCS的长度,这里用数组表示
        int [][] c=new int[n+1][m+1];
        //建立另一个表用于帮助构造最优解（LCS）:1代表向左，2代表斜上，3代表向上
        b=new int[n+1][m+1];
        //output
        int length=0;
        for (int i=0;i<=m;i++) {
            c[0][m]=0;
        }
        for (int j=0;j<=n;j++) {
            c[j][0]=0;
        }
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=m;j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    c[i][j]=c[i-1][j-1]+1;
                    b[i][j] = 2;
                    //只有二者序列相同的时候构成了LCS
                    if (c[i][j] > length) {
                        length=c[i][j];
                    }
                } else if (c[i - 1][j] > c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = 3;
                } else {
                    c[i][j]=c[i][j - 1];
                    b[i][j] = 1;
                }
            }
        }
        return length;
    }

    public void print_LCS(int[][] b, String A,  int n, int m) {
        if (n == 0 || m == 0) {
            return;
        }
        if (b[n][m] == 2) {
            print_LCS(b, A,  n - 1, m - 1);
            System.out.print(A.charAt(n-1));
        } else if (b[n][m] == 1) {
            print_LCS(b, A, n, m - 1);
        } else {
            print_LCS(b, A,  n - 1, m);
        }
    }
    public static void main(String [] args){
        String A= "1A2C3D4B56";
        String B = "B1D23CA45B6A";
        longest_common_subsequence lcs = new longest_common_subsequence();
        System.out.println(lcs.findLCS(A,10,B,12));

        lcs.print_LCS(lcs.b,A,10,12);
    }
}
