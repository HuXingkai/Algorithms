package zijietiaodong;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by andy on 2018/10/8.
 */
public class zhuangbei {
    public static int findValue(int[] items, int[] value, int m, int n) {
        //建立一个二维的数组，表示在选取/不选区第i件物品时，在不超过当前重量限制的条件下，获得的最优解
        int[][] dp = new int[n + 1][m + 1];
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=m;j++){
                //这里从1开始递增背包的重量限制
                if (j < items[i-1]) {
                    dp[i][j]=dp[i-1][j];
                } else if (dp[i - 1][j - items[i-1]] + value[i-1] > dp[i - 1][j]) {
                    dp[i][j] = dp[i - 1][j - items[i-1]] + value[i-1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Integer> cost = new ArrayList<>();
        List<Integer> grade = new ArrayList<>();
        while (scanner.hasNext()) {
            cost.add(scanner.nextInt());
            grade.add(scanner.nextInt());
        }
        int[] items = new int[grade.size()];
        for (int i=0;i<grade.size();i++) {
            items[i] = grade.get(i);
        }

        int[] value = new int[cost.size()];
        for (int i=0;i<cost.size();i++) {
            value[i] = cost.get(i);
        }
        System.out.println(findValue(items,value,m,n));
    }
}
