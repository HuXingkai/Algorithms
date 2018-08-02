package BFS;

import java.util.*;

public class SurroundedRegions {
    public void solve(char[][] board) {
        int length=board[0].length;
        int width=board.length;
        boolean[][] visited=new boolean[length][width];
        List<Queue<Integer>[]> group = new ArrayList<>();
        Queue<Integer>[] xias = new LinkedList[2];
        Queue<Integer>[] temp = new LinkedList[2];

        for (int i=0;i<length;i++) {
            for (int j=0;j<width;j++) {
                if (board[i][j] == 'o'&&!visited[i][j]) {
                    xias[0] = new LinkedList<>();
                    xias[1] = new LinkedList<>();

                    temp[0] = new LinkedList<>();
                    temp[1] = new LinkedList<>();

                    visited[i][j]=true;
                    xias[0].add(i);temp[0].add(i);
                    xias[1].add(j);temp[1].add(i);
                    while (!xias[0].isEmpty() && !xias[1].isEmpty()) {
                        int x=xias[0].poll();
                        int y=xias[1].poll();
                        visited[x][y] = true;
                        for (int m=x+1;m<width;m++) {
                            if (board[m][y] == 'o') {
                                xias[0].add(m);temp[0].add(m);
                                xias[1].add(y);temp[1].add(y);
                            }
                            else break;
                        }
                        for (int m=y+1;m<length;m++) {
                            if (board[x][m] == 'o') {
                                xias[0].add(x);temp[0].add(x);
                                xias[1].add(m);temp[1].add(m);
                            }
                            else break;
                        }
                    }
                    Queue<Integer>[] temp1 = new LinkedList[2];
                    temp1[0] = temp[0];
                    temp1[1] = temp[1];
                    group.add(temp1);
                }
            }
        }

        for (Queue<Integer>[] queues:group) {
            if (!queues[0].contains(0) && !queues[0].contains(width) &&
                    !queues[1].contains(0) && !queues[1].contains(length)) {
                while (!queues[0].isEmpty() && !queues[1].isEmpty()) {
                    int x=queues[0].poll();
                    int y = queues[1].poll();
                    board[x][y] = 'x';
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[4][4];
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {
                board[i][j] = 'x';
            }
        }
        board[1][1] = 'o';
        board[1][2] = 'o';
        board[2][2] = 'o';
        board[3][1] = 'o';
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {
                System.out.print(board[i][j]);
                if (j == 3) {
                    System.out.println("\n");
                }
            }
        }

        SurroundedRegions s = new SurroundedRegions();
        s.solve(board);
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {
                System.out.print(board[i][j]);
                if (j == 3) {
                    System.out.println("\n");
                }
            }
        }
    }
}
