package BFS;

import java.util.*;
public class PushingBoxFast {
    private static class State {
        int px, py, bx, by;
        State pre;

        public State(int px, int py, int bx, int by, State pre) {
            this.px = px;
            this.py = py;
            this.bx = bx;
            this.by = by;
            this.pre = pre;
        }
    }

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long startTime = System.currentTimeMillis();
            String s = sc.nextLine();
            int n = Integer.parseInt(s.split(" ")[0]);
            int px = -1, py = -1, bx = -1, by = -1;
            char[][] maze = new char[n][];
            for (int i = 0; i < n; i++) {
                maze[i] = sc.nextLine().toCharArray();
                for (int j = 0; j < maze[i].length; j++) {
                    if (maze[i][j] == 'X') {
                        px = i;
                        py = j;
                    } else if (maze[i][j] == '*') {
                        bx = i;
                        by = j;
                    }
                }
            }
            State start = new State(px, py, bx, by, null);
            List<State> list = bfs(maze, start);
            System.out.println(list.size() - 1);
            long endTime = System.currentTimeMillis();
            System.out.println("运行时间："+(endTime-startTime));
        }

    }

    private static List<State> bfs(char[][] maze, State start) {
        int n = maze.length;
        int m = maze[0].length;
        boolean[][][][] added = new boolean[n][m][n][m];
        Queue<State> queue = new LinkedList<>();
        LinkedList<State> list = new LinkedList<>();
        queue.add(start);
        added[start.px][start.py][start.bx][start.py] = true;
        int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        State end = null;
        while (!queue.isEmpty()) {
            State cur = queue.poll();
            if (maze[cur.bx][cur.by] == '@') {
                end = cur;
                break;
            }
            for (int[] a : move) {
                State next = new State(cur.px + a[0], cur.py + a[1], cur.bx, cur.by, cur);
                if (next.px == next.bx && next.py == next.by) {
                    next.bx += a[0];
                    next.by += a[1];
                    if (next.bx < 0 || next.bx >= n || next.by < 0 || next.by >= m || maze[next.bx][next.by] == '#')
                        continue;
                } else if (next.px < 0 || next.px >= n || next.py < 0 || next.py >= m || maze[next.px][next.py] == '#') {
                    continue;
                }
                if (!added[next.px][next.py][next.bx][next.by]) {
                    queue.add(next);
                    added[next.px][next.py][next.bx][next.by] = true;
                }
            }
        }
        //从最后的输出元素逆序找到开始的元素，并将其存储到list中
        //这个方法比我自己在mazeproblem用的好很多！！！
        if (end != null) {
            while (end != null) {
                list.addFirst(end);
                end = end.pre;
            }
        }
        return list;
    }
}