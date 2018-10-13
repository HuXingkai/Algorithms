package didiTest.saima2019;

import java.util.*;

/**
 * Created by andy on 2018/9/18.
 * 测试数据：slep slap sleep step shoe shop snap slep
 * 类似的题目
 * https://leetcode.com/problems/edit-distance/discuss/162330/Very-detailed-explanation-(Recursive-greater-DP-)-in-Java
 */
public class test1 {
    static String str1 = "q w e r t a s d f g z x c v";
    static String str2 = "y u i o p h j k l b n m";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String target = scanner.next();
        List<answer> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String tem = scanner.nextLine();
            if (tem.equals(" ")) break;
            String[] term2 = tem.split(" ");
            for (String s : term2) {
                int time = minDistance(s, target);
                answer a = new answer(s, time);
                list.add(a);
            }
            Collections.sort(list);
            for (int i=0;i<3;i++) {
                System.out.print(list.get(i).word+" ");
            }

        }

    }
    public static int minDistance(String word1, String word2) {
        //return helper_rec(word1, word1.length()-1, word2, word2.length()-1);
        int[][] arr = new int[word1.length()+1][word2.length()+1];
        //set the boundary conditions.
        for (int i = 0; i<arr.length; i++) {
            arr[i][0] = i*3;
        }

        for (int j = 0; j<arr[0].length; j++) {
            arr[0][j] = j*3;
        }

        for (int i=1; i<=word1.length();i++){
            for (int j=1; j<=word2.length() ;j++) {
                if (word1.charAt(i-1) != word2.charAt(j-1)) {
                    //replace.
                    int replaceCount;
                    if ((str1.contains("" + word1.charAt(i - 1)) && str1.contains("" + word2.charAt(j - 1))) ||
                            (str2.contains("" + word1.charAt(i - 1)) && str2.contains("" + word2.charAt(j - 1)))) {
                        replaceCount = 1 + arr[i-1][j-1];
                    }
                    else replaceCount = 2 + arr[i-1][j-1];
                    //delete.
                    int deleteCount = 3 + arr[i-1][j];
                    //add.
                    int addCount = 3 + arr[i][j-1];
                    arr[i][j] =  Math.min(replaceCount,Math.min(deleteCount, addCount));
                } else {
                    arr[i][j] = arr[i-1][j-1];
                }
            }
        }

        return arr[word1.length()][word2.length()];
        }

}
class answer implements Comparable{
    String word;
    int times;

    public answer(String w, int t) {
        word=w;
        times = t;
    }
    @Override
    public int compareTo(Object o) {
        answer a = (answer) o;
        return times - a.times;
    }
}
