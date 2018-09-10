package aibank;

import java.util.Scanner;

/**
 * Created by andy on 2018/9/10.
 */
public class Solution {
    public static int numOfName(String S, String T) {
        int[][] dp = new int[T.length()+1][S.length()+1];
        for(int i=0; i<S.length(); i++)
            dp[0][i] = 1;
        //dp
        for(int i=1; i<=T.length(); i++){
            for(int j=1; j<=S.length(); j++){
                if(T.charAt(i-1)==S.charAt(j-1)){
                    dp[i][j] = dp[i][j-1]+dp[i-1][j-1];
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[T.length()][S.length()];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(numOfName(str,"aibank"));
    }
}
