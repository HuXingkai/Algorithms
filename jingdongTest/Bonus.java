package jingdongTest;

/**
 * Created by andy on 2018/9/9.
 */
public class Bonus {
    public int getMost(int[][] board) {
        int[][] bonus = new int[6][6];
        bonus[0][0] = board[0][0];
        for (int i=1;i<6;i++) {
            bonus[0][i] = bonus[0][i-1]+board[0][i];
            bonus[i][0] = bonus[i-1][0]+board[i][0];
        }

        for (int i=1;i<6;i++) {
            for (int j=1;j<6;j++) {
                bonus[i][j] = Math.max(bonus[i - 1][j] + board[i][j], bonus[i][j - 1] + board[i][j]);
            }
        }
        return bonus[6][6];
    }
}
