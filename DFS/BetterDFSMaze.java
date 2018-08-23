package DFS;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by andy on 2018/8/23.
 * 迷宫问题更好的解法
 * 深度优先的关键点
 1. 函数的形式参数
 2. 递归结束条件
 3. 下一步的坐标计算
 4. 判断是否下一步可走
 5. 已走过的路做标记
 6. 回溯时将当前步标记清除

 分析：
 1. 二维数组表示迷宫，参数需要当前坐标x,y，以及当前是第几步。
 2. 结束条件为，找到目标。
 3. 以顺时针方式计算下一步坐标，最多,有四种走法，右，下，左，上。用一个二维数组保存四种走法坐标的变化情况，next[4][2]={{1,0},{0,1},{-1,0},{0,-1}},遍历到一条路一直往前走，回溯时遍历下一条路。
 4. 判断是否为障碍或者边界
 5. 数组标记该坐标为2
 6. 清除该坐标的标记
 */
public class BetterDFSMaze {
    static int minStep = Integer.MAX_VALUE;

    //利用一个二维数组，用于表示坐标可以走的方向，这种方法很巧妙
    //用一个二维数组保存四种走法坐标的变化情况，next[4][2]={{1,0},{0,1},{-1,0},{0,-1}},
    // 遍历到一条路一直往前走，回溯时遍历下一条路。
    static int[][] next = new int[][]{{0, 1}, {1,0}, {0, -1}, {-1, 0}};

    //代表重点坐标
    static int outX, outY;
    //记录每次走的路径
    static Stack<String> pathTrace = new Stack<String>();
    //坐标边界
    static int buttom, right;
    static int [][] maze;
    //记录已经访问的位置
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {//!!!注意while处理多个case
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            maze = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    maze[i][j] = scanner.nextInt();
                }
            }

            visited = new boolean[n][m];
            outX = n - 1;
            outY = m - 1;
            buttom = n;
            right = m;
            visited[0][0] = true;
            pathTrace.add(0 + "," + 0);
            findway(0,0,0);
            System.out.println("最短的步数为："+minStep);
        }
    }

    public static void findway(int currentX, int currentY, int step){
        if (currentX == outX && currentY == outY) {
            System.out.println("当前步数"+step);
            if (step < minStep) {
                minStep = step;
            }
            //输出路径
            for (String item:pathTrace) {
                System.out.println("("+item+")");
            }
            System.out.println();
        }
        //!!!这里利用for循环，有一个非常重要的作用就是，当回溯回来之后，已经深入遍历过的节点不会再重新被遍历一次
        for (int i = 0; i < 4; i++) {
            int nextX = currentX + next[i][0];
            int nextY = currentY + next[i][1];

            if (nextX >= buttom || nextX < 0 || nextY >= right || nextY < 0 || maze[nextX][nextY] == 1 || visited[nextX][nextY])
                //如果当前方向不可行，结束当前的循环，开始下一个循环
                continue;

            visited[nextX][nextY] = true;
            pathTrace.push(nextX+","+nextY);
//          System.out.print(nextX + "," + nextY+"-->");//显示路径的走向，这里从上一次路径递归返回时，循环确定下一步走法时开始输出，看结果book的路径更直观

            findway(nextX, nextY, step + 1);
            visited[nextX][nextY] = false;//这里要清除标记
            pathTrace.pop();
//
        }
        return;
    }

}