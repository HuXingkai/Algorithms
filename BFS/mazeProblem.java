package BFS;

import java.util.*;

/**
 * Created by andy on 2018/8/22.
 * https://www.nowcoder.com/questionTerminal/cf24906056f4488c9ddb132f317e03bc
 *定义一个二维数组：
 int maze[5][5] = {
 0, 1, 0, 0, 0,
 0, 1, 0, 1, 0,
 0, 0, 0, 0, 0,
 0, 1, 1, 1, 0,
 0, 0, 0, 1, 0,
 };
 它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，
 不能斜着走，要求编程序找出从左上角到右下角的最短路线。
 *
 */
public class mazeProblem {
    public static void findline(int [][] maze, int n, int m) {
        //代表当前要访问的节点
        Queue<node> queue = new LinkedList<>();
        //记录已经访问过的节点
        boolean [][] visited=new boolean[n][m];
        //通过二维数组记录每个位置的节点，便于后续取相应的节点
        node[][] nodes = new node[n][m];
        //定义一个栈用于输出
        Stack<node> out = new Stack<>();
        //起点位置
        node start = new node(0, 0,-1,-1);
        //二维数组的（0，0）位置对应的就是起点
        nodes[0][0] = start;
        node end = new node(n - 1, m - 1,-1,-1);
        //将起点加入队列中
        queue.add(start);
        while (!queue.isEmpty()) {
            node tep = queue.poll();
            //将当前的节点设置为“已访问”
            visited[tep.x][tep.y] = true;
            //如果当前节点是终点，结束循环
            if (tep.equals(end)) {
                nodes[n-1][m-1]=tep;
                break;
            }
            //下面4个if语句用于判断当前节点的上下左右四个方向上可以下一步的相邻节点
            node now;
            if (tep.x - 1 >= 0 && maze[tep.x - 1][tep.y] == 0&&!visited[tep.x - 1][tep.y]) {
                now = new node(tep.x - 1, tep.y, tep.x, tep.y);
                queue.add(now);
                nodes[tep.x - 1][tep.y]=now;
            }
            if (tep.x + 1 < n && maze[tep.x + 1][tep.y] == 0&& !visited[tep.x + 1][tep.y]) {
                now = new node(tep.x + 1, tep.y, tep.x, tep.y);
                queue.add(now);
                nodes[tep.x + 1][tep.y]=now;
            }
            if (tep.y + 1 < m && maze[tep.x][tep.y + 1] == 0&& !visited[tep.x][tep.y + 1]) {
                now = new node(tep.x, tep.y + 1, tep.x, tep.y);
                queue.add(now);
                nodes[tep.x][tep.y + 1]=now;
            }
            if (tep.y - 1 >=0 && maze[tep.x][tep.y - 1] == 0&& !visited[tep.x][tep.y - 1]) {
                now = new node(tep.x, tep.y - 1, tep.x, tep.y);
                queue.add(now);
                nodes[tep.x][tep.y - 1]=now;
            }
        }
        node local = nodes[n-1][m-1];
        out.add(local);
        //利用二维数组，从终点开始，倒叙寻找路径上的节点，并压人栈中
        //每一个节点都存储着前驱节点的坐标，根据这个坐标和二维数组，便可以找出前驱节点。
        //从而可以再继续找出前驱节点的前驱节点，直到逆向找到起点位置。
        while (local.prex > -1) {
            out.add(nodes[local.prex][local.prey]);
            local=nodes[local.prex][local.prey];
        }
        //将栈中的节点坐标信息输出
        while (!out.isEmpty()) {
            node nodeout = out.pop();
            System.out.println("("+nodeout.x+","+nodeout.y+")");
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
            findline(maze, n, m);
        }
    }
}

/**
 * 节点类
 *
 */
class node{
    public int x;
    public int y;
    public int prex;
    public int prey;

    /**
     * 节点类的构造函数
     * @param x 节点当前的横坐标
     * @param y 当前节点的纵坐标
     * @param prex 前驱节点横坐标
     * @param prey 前驱节点纵坐标
     */
    public node(int x, int y, int prex, int prey) {
        this.x = x;
        this.y = y;
        this.prex = prex;
        this.prey = prey;
    }

    /**
     * 判断节点是否相等的方法
     * @param n
     * @return
     */
    public boolean equals(node n) {
        if (n.x == x && n.y == y) {
            return true;
        }
        return false;
    }
}
