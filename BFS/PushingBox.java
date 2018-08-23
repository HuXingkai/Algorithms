package BFS;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by andy on 2018/8/23.
 * 链接：https://www.nowcoder.com/questionTerminal/d64d259ee34141378b62e1ea4be74030
 来源：牛客网

 大家一定玩过“推箱子”这个经典的游戏。具体规则就是在一个N*M的地图上，有1个玩家、1个箱子、1个目的地以及若干障碍，其余是空地。玩家可以往上下左右4个方向移动，但是不能移动出地图或者移动到障碍里去。如果往这个方向移动推到了箱子，箱子也会按这个方向移动一格，当然，箱子也不能被推出地图或推到障碍里。当箱子被推到目的地以后，游戏目标达成。现在告诉你游戏开始是初始的地图布局，请你求出玩家最少需要移动多少步才能够将游戏目标达成。
 输入描述:
 每个测试输入包含1个测试用例
 第一行输入两个数字N，M表示地图的大小。其中0<N，M<=8。
 接下来有N行，每行包含M个字符表示该行地图。其中 . 表示空地、X表示玩家、*表示箱子、#表示障碍、@表示目的地。
 每个地图必定包含1个玩家、1个箱子、1个目的地。
 输出描述:
 输出一个数字表示玩家最少需要移动多少步才能将游戏目标达成。当无论如何达成不了的时候，输出-1。

 分析
 人是有四个前进方向的，而箱子的前进方向由人遇见他的时候决定。

 核心流程：
 人走到了一个点，需要先判断该点是不是墙，出没出界，是墙或出界就用continue终止该次循环；再判断这个点是不是箱子，若是，那么箱子要与人同样的方向移动一步；最后再判断箱子的位置是否都满足既不是墙，也不出界。

 开个四维数组visit，前面两维记录人的X、Y，另外两维记录箱子的X、Y。！！！利用人和箱子的相对位置作为是否重复的状态！！！
 */
public class PushingBox {
    //经过测试证明，定义类中含有前驱节点将大大缩短运行时间，不是内部类也可以
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


    public static int findMinLine(int n, int m, char [][] maze,int peopleX, int peopleY,int boxX, int boxY) {
        /*Queue<Node> queue = new LinkedList<>();

        boolean[][][][] visited = new boolean[n][m][n][m];
        Node start = new Node(peopleX,peopleY,boxX,boxY,0);
        int[][] next = {{0, 1}, {-1,0}, {0,-1}, {1,0}};
        queue.add(start);
        visited[peopleX][peopleY][boxX][boxY] = true;

        while (!queue.isEmpty()) {
            Node tep = queue.poll();

            visited[tep.peopleX][tep.peopleY][tep.boxX][tep.boxY] = true;

            if (maze[tep.boxX][tep.boxY]=='@'){
                return tep.stepSum;
            }

            for (int i=0;i<4;i++) {
                Node nextNode = new Node(tep.peopleX,tep.peopleY,tep.boxX,tep.boxY,tep.stepSum);
                nextNode.stepSum++;

                nextNode.peopleX += next[i][0];
                nextNode.peopleY += next[i][1];

                if (nextNode.peopleX >= n || nextNode.peopleX < 0 || nextNode.peopleY >= m ||
                        nextNode.peopleY < 0 || maze[nextNode.peopleX][nextNode.peopleY]=='#') {
                    continue;
                }
                if (nextNode.peopleX==nextNode.boxX&&nextNode.peopleY==nextNode.boxY) {
                    nextNode.boxX += next[i][0];
                    nextNode.boxY += next[i][1];
                }
                if (nextNode.boxX >= n || nextNode.boxX < 0 || nextNode.boxY >= m ||
                        nextNode.boxY < 0 || maze[nextNode.boxX][nextNode.boxY]=='#') {
                    continue;
                }
                if (!visited[nextNode.peopleX][nextNode.peopleY][nextNode.boxX][nextNode.boxX])
                    queue.add(nextNode);
                    //visited[nextNode.peopleX][nextNode.peopleY][nextNode.boxX][nextNode.boxY] = true;

            }
        }
        return -1;*/
        Queue<State> queue = new LinkedList<>();
        LinkedList<State> list = new LinkedList<>();
        boolean[][][][] visited = new boolean[n][m][n][m];
        State start = new State(peopleX,peopleY,boxX,boxY,null);
        int[][] next = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        queue.add(start);
        visited[peopleX][peopleY][boxX][boxY] = true;
        State end = null;

        while (!queue.isEmpty()) {
            State tep = queue.poll();

            //visited[tep.peopleX][tep.peopleY][tep.boxX][tep.boxY] = true;

            if (maze[tep.bx][tep.by]=='@'){
                end=tep;
                break;
            }

            for (int[] a:next) {
                State nextNode = new State(tep.px+a[0],tep.py+a[1],tep.bx,tep.by,tep);

                if (nextNode.px==nextNode.bx&&nextNode.py==nextNode.by) {
                    nextNode.bx += a[0];
                    nextNode.by += a[1];
                    if (nextNode.bx >= n || nextNode.bx < 0 || nextNode.by >= m ||
                            nextNode.by < 0 || maze[nextNode.bx][nextNode.by]=='#') {
                        continue;
                    }
                }
                else if (nextNode.px >= n || nextNode.px < 0 || nextNode.py >= m ||
                        nextNode.py < 0 || maze[nextNode.px][nextNode.py]=='#') {
                    continue;
                }

                if (!visited[nextNode.px][nextNode.py][nextNode.bx][nextNode.by])
                    queue.add(nextNode);
                    visited[nextNode.px][nextNode.py][nextNode.bx][nextNode.by] = true;
            }
        }
        if (end != null) {
            while (end != null) {
                list.add(end.pre);
                end = end.pre;
            }
        }
        return list.size()-1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*while (scanner.hasNext()) {//!!!注意while处理多个case
            int n=scanner.nextInt();
            int m = scanner.nextInt();
            int peopleX=0,  peopleY=0, boxX=0,  boxY=0;
            String [][] maze=new String[n][m];
            for (int i=0;i<n;i++) {
                for (int j=0;j<m;j++) {
                    maze[i][j] = scanner.next();
                    if (maze[i][j].equals("*")) {
                        boxX=i;
                        boxY = j;
                    }
                    if (maze[i][j].equals("X")) {
                        peopleX=i;
                        peopleY = j;
                    }
                }
            }

            int num=findMinLine(n, m, maze, peopleX, peopleY, boxX, boxY);
            System.out.println(num);
        }*/

        while (scanner.hasNext()) {
            long startTime = System.currentTimeMillis();
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] maze = new char[n][m];
            for (int i = 0; i < n; i++) {
                maze[i] = scanner.next().toCharArray();
            }
            int peoplex = 0;
            int peopley = 0;
            int boxx = 0;
            int boxy = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (maze[i][j] == 'X') {
                        peoplex = i;
                        peopley = j;
                    }
                    if (maze[i][j] == '*') {
                        boxx = i;
                        boxy = j;
                    }
                }
            }
            int num = findMinLine(n, m, maze, peoplex, peopley, boxx, boxy);
           System.out.println(num);
            long endTime = System.currentTimeMillis();
            System.out.println("运行时间："+(endTime-startTime));
        }
    }
}
/**
 * 节点类
 *
 */
class Node{
    public int peopleX;
    public int peopleY;
    public int boxX;
    public int boxY;
    int stepSum;

    /**
     * 节点类的构造函数
     * @param x 节点当前的横坐标
     * @param y 当前节点的纵坐标
     * @param prex 前驱节点横坐标
     * @param prey 前驱节点纵坐标
     */
    public Node(int x, int y, int prex, int prey,int step) {
        this.peopleX = x;
        this.peopleY = y;
        this.boxX = prex;
        this.boxY = prey;
        this.stepSum = step;
    }
}
