package WangyiText.wangyihuyuTest;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/test/question/done?tid=18365338&qid=117506
 * Created by andy on 2018/9/8.
 */
public class FindCharInMaze {
    public static int find(String targetWord, char[][] maze,int m,int n) {
        int num=0;
        char start = targetWord.charAt(0);
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (start == maze[i][j]) {
                    int temi = i;
                    int tempj = j;
                    int k=1;
                    while (tempj+k < n && targetWord.charAt(k)==maze[i][tempj+k]) {
                        if (k == targetWord.length() - 1) {
                            num++;
                            break;
                        }
                        k++;
                    }
                    k=1;
                    while (temi+k < m && targetWord.charAt(k)==maze[temi+k][j]) {
                        if (k == targetWord.length() - 1) {
                            num++;
                            break;
                        }
                        k++;
                    }
                    k=1;
                    while (tempj+k < n&&temi+k < m && targetWord.charAt(k)==maze[temi+k][tempj+k]) {
                        if (k == targetWord.length() - 1) {
                            num++;
                            break;
                        }
                        k++;
                    }
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i=0;i<T;i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            char [][] maze = new char[m][n];
            for (int k=0;k<m;k++) {
                String str = sc.next();
                for(int j=0;j<n;j++) {
                    maze[k][j] = str.charAt(j);
                }
            }
            String targetWord = sc.next();
            System.out.println(find(targetWord,maze,m,n));
        }
    }
}
