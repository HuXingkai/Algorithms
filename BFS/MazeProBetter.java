package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by andy on 2018/8/23.
 * 此方法精简一些，但是无法输出路径
 */
public class MazeProBetter {
    public static void findways(int n, int m, int[][] maze) {
        Queue<String> queue = new LinkedList<>();
        int minL = 0;
        int count = 1;
        boolean[][] visited = new boolean[n][m];
        int currentX = 0;
        int currentY = 0;
        int[][] next = {{0, 1}, {-1,0}, {0,-1}, {1,0}};
        queue.add(currentX + "," + currentY);
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            String tep = queue.poll();
            count--;
            int x = Integer.parseInt(tep.split(",")[0]);
            int y = Integer.parseInt(tep.split(",")[1]);
            visited[x][y] = true;

            if (x == n - 1 && y == m - 1) {
                System.out.println("最短的路径为："+minL);
                return;
            }

            for (int i=0;i<4;i++) {
                int nextX = x + next[i][0];
                int nextY = y + next[i][1];
                if (nextX >= n || nextX < 0 || nextY >= m || nextY < 0 || maze[nextX][nextY] == 1 || visited[nextX][nextY]) {
                    continue;
                }
                queue.add(nextX + "," + nextY);
            }

            if (count == 0) {
                minL++;
                count = queue.size();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {//!!!注意while处理多个case
            int n=scanner.nextInt();
            int m = scanner.nextInt();
            int [][] maze=new int[n][m];
            for (int i=0;i<n;i++) {
                for (int j=0;j<m;j++) {
                    maze[i][j] = scanner.nextInt();
                }
            }
            //System.out.println(Arrays.deepToString(maze));
            findways( n, m,maze);
        }
    }
}
