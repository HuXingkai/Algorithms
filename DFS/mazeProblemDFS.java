package DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**https://blog.csdn.net/raphealguo/article/details/7560918
 * 深度优先搜索 DFS
 * Created by andy on 2018/8/22.
 * 给定一个迷宫，指明起点和终点，找出从起点出发到终点的有效可行路径，就是迷宫问题（maze problem）。

 迷宫可以以二维数组来存储表示。0表示通路，1表示障碍。注意这里规定移动可以从上、下、左、右四方方向移动。
 坐标以行和列表示，均从0开始，给定起点（0,0）和终点（4,4），迷宫表示如下：

 int maze[5][5]={
 {0,0,0,0,0},
 {0,1,0,1,0},
 {0,1,1,0,0},
 {0,1,1,0,1},
 {0,0,0,0,0}
 };
 那么下面的迷宫就有两条可行的路径，分别为：
 （1）(0,0) (0,1) (0,2) (0,3) (0,4) (1,4) (2,4) (2,3) (3,3) (4,3) (4,4)；
 （2）(0,0) (1,0) (2,0) (3,0) (4,0) (4,1) (4,2) (4,3) (4,4) ；

 可见，迷宫可行路径有可能是多条，且路径长度可能不一。
 深度优先搜索可以将所有可能的路径输出
 下面的方法只能输出可能的一种路径
 */
public class mazeProblemDFS {
    public static Queue<Node> queue1 = new LinkedList<>();
    public static void findways(int[][] maze, int n, int m) {
        Stack<Node> stack = new Stack<>();
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        Node start = new Node(0, 0);
        stack.add(start);
        queue1.add(start);
        DFSvisited(stack, maze, n, m, visited);
        stack.remove(start);
    }

    public static void DFSvisited(Stack<Node> queue, int[][] maze, int n, int m,boolean[][] visited) {
        while (!queue.isEmpty()) {
            Node tep = queue.peek();
            //将当前的节点设置为“已访问”
            visited[tep.x][tep.y] = true;
            if (tep.x == n - 1 && tep.y == m - 1) {
                while (!queue1.isEmpty()) {
                    Node out = queue1.poll();
                    System.out.println("("+out.x+","+out.y+")");
                }
                return;
            }
            Node now;
            if (tep.x - 1 >= 0 && maze[tep.x - 1][tep.y] == 0&&!visited[tep.x - 1][tep.y]) {
                now = new Node(tep.x - 1, tep.y);

                queue.add(now);
                queue1.add(now);
                DFSvisited(queue, maze, n, m, visited);
                queue.remove(now);
                queue1.remove(now);


            }
            if (tep.x + 1 < n && maze[tep.x + 1][tep.y] == 0&& !visited[tep.x + 1][tep.y]) {
                now = new Node(tep.x + 1, tep.y);

                queue.add(now);queue1.add(now);
                DFSvisited(queue, maze, n, m, visited);
                queue.remove(now);queue1.remove(now);

            }
            if (tep.y + 1 < m && maze[tep.x][tep.y + 1] == 0&& !visited[tep.x][tep.y + 1]) {
                now = new Node(tep.x, tep.y + 1);

                queue.add(now);queue1.add(now);
                DFSvisited(queue, maze, n, m, visited);
                queue.remove(now);queue1.remove(now);

            }
            if (tep.y - 1 >= 0 && maze[tep.x][tep.y - 1] == 0 && !visited[tep.x][tep.y - 1]) {
                now = new Node(tep.x, tep.y - 1);

                queue.add(now);
                queue1.add(now);
                DFSvisited(queue, maze, n, m, visited);
                queue.remove(now);
                queue1.remove(now);

            }
            else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {//!!!注意while处理多个case
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] maze = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    maze[i][j] = scanner.nextInt();
                }
            }
            findways(maze,n,m);
        }

    }

}
class Node{
    public int x;
    public int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
