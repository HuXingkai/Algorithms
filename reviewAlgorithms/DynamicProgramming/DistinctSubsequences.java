package reviewAlgorithms.DynamicProgramming;

/**
 * Created by andy on 2018/9/10.
 * 链接：https://www.nowcoder.com/questionTerminal/ed2923e49d3d495f8321aa46ade9f873?orderByHotValue=1&mutiTagIds=593_641_640_639&page=1&onlyReference=false
 来源：牛客网

 Given a string S and a string T, count the number of distinct subsequences of T in S.
 A subsequence of a string is a new string which is formed from the original string by deleting some (can be none)
 of the characters without disturbing the relative positions of the remaining characters.
 (ie,"ACE"is a subsequence of"ABCDE"while"AEC"is not).
 Here is an example:
 S ="rabbbit", T ="rabbit"

 Return3.

 我们需要一个二维数组dp(i)(j)来记录长度为i的字串在长度为j的母串中出现的次数，这里长度都是从头算起的，而且遍历时，
 保持子串长度相同，先递增母串长度，母串最长时再增加一点子串长度重头开始计算母串。

 首先我们先要初始化矩阵，当子串长度为0时，所有次数都是1，当母串长度为0时，所有次数都是0.当母串子串都是0长度时，次数是1
 （因为都是空，相等）。接着，如果子串的最后一个字母和母串的最后一个字母不同，说明新加的母串字母没有产生新的可能性，
 可以沿用该子串在较短母串的出现次数，所以dp(i)(j) = dp(i)(j-1)。如果子串的最后一个字母和母串的最后一个字母相同，
 说明新加的母串字母带来了新的可能性，我们不仅算上dp(i)(j-1)，也要算上新的可能性。那么如何计算新的可能性呢，
 其实就是在既没有最后这个母串字母也没有最后这个子串字母时，子串出现的次数，我们相当于为所有这些可能性都添加一个新的可能。
 所以，这时dp(i)(j) = dp(i)(j-1) + dp(i-1)(j-1)。下图是以rabbbit和rabbit为例的矩阵示意图。计算元素值时，当末尾字母一样，
 实际上是左方数字加左上方数字，当不一样时，就是左方的数字。
 */

/**
 * 这道题和百信银行的笔试题完全一样
 */
public class DistinctSubsequences {
    public int numDistinct(String S, String T) {
        int[][] table = new int[T.length()+1][S.length()+1];
        for(int i=0; i<S.length(); i++)
            table[0][i] = 1;
        //dp
        for(int i=1; i<=T.length(); i++){
            for(int j=1; j<=S.length(); j++){
                if(T.charAt(i-1)==S.charAt(j-1)){
                    table[i][j] = table[i][j-1]+table[i-1][j-1];
                }else{
                    table[i][j] = table[i][j-1];
                }
            }
        }
        return table[T.length()][S.length()];
    }

}
