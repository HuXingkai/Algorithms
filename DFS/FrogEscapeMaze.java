package DFS;

import java.util.*;

/**
 * Created by andy on 2018/8/28.
 * 链接：https://www.nowcoder.com/questionTerminal/571cfbe764824f03b5c0bfd2eb0a8ddf
 来源：牛客网

 小青蛙有一天不小心落入了一个地下迷宫,小青蛙希望用自己仅剩的体力值P跳出这个地下迷宫。为了让问题简单,假设这是一个n*m的格子迷宫,迷宫每个位置为0或者1,0代表这个位置有障碍物,小青蛙达到不了这个位置;1代表小青蛙可以达到的位置。小青蛙初始在(0,0)位置,地下迷宫的出口在(0,m-1)(保证这两个位置都是1,并且保证一定有起点到终点可达的路径),小青蛙在迷宫中水平移动一个单位距离需要消耗1点体力值,向上爬一个单位距离需要消耗3个单位的体力值,向下移动不消耗体力值,当小青蛙的体力值等于0的时候还没有到达出口,小青蛙将无法逃离迷宫。现在需要你帮助小青蛙计算出能否用仅剩的体力值跳出迷宫(即达到(0,m-1)位置)。
 输入描述:
 输入包括n+1行:
 第一行为三个整数n,m(3 <= m,n <= 10),P(1 <= P <= 100)
 接下来的n行:
 每行m个0或者1,以空格分隔


 输出描述:
 如果能逃离迷宫,则输出一行体力消耗最小的路径,输出格式见样例所示;如果不能逃离迷宫,则输出"Can not escape!"。 测试数据保证答案唯一
 示例1
 输入
 4 4 10 1 0 0 1 1 1 0 1 0 1 1 1 0 0 1 1
 输出
 [0,0],[1,0],[1,1],[2,1],[2,2],[2,3],[1,3],[0,3]
 */
public class FrogEscapeMaze {
    public static int[][] step = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    //储存消耗逃脱路径
    public static Map<Integer, Stack<String>> map = new HashMap<>();
    //
    static boolean [][] visited;
    static Stack<String> queue = new Stack<>();
    static int m;
    static int n;

    public static void dfs(int CurrentX, int CurrentY, int [][] maze, int p) {
        if (CurrentX == 0 && CurrentY == m - 1) {
            map.put(p, (Stack<String>)queue.clone());
        }
        for (int i=0;i<4;i++) {
            int stepX = CurrentX + step[i][0];
            int stepY = CurrentY + step[i][1];

            if (stepX < n && stepX >= 0 && stepY < m && stepY >= 0 && maze[stepX][stepY] == 1 && !visited[stepX][stepY]) {
                visited[stepX][stepY] = true;
                queue.add("[" + stepX + "," + stepY + "]");

                if (i == 0) {

                    dfs(stepX, stepY, maze, p);
                    queue.pop();
                    visited[stepX][stepY] = false;
                }
                if (i == 1 || i == 3) {
                    dfs(stepX, stepY, maze, p + 1);
                    queue.pop();
                    visited[stepX][stepY] = false;
                }
                if (i == 2) {
                    dfs(stepX, stepY, maze, p +3);
                    queue.pop();
                    visited[stepX][stepY] = false;
                }
            }
        }
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        visited = new boolean[n][m];
        int P=sc.nextInt();
        int [][] maze=new int[n][m];
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        queue.add("[" + 0 + "," + 0 + "]");
        visited[0][0] = true;
        dfs(0, 0, maze, 0);
        int answer=Integer.MAX_VALUE;
        for (int i : map.keySet()) {
            if (i > P) {
                continue;
            }
            answer = Math.min(answer, i);
        }
        if (answer == Integer.MAX_VALUE) {
            System.out.println("Can not escape!");
        }
        else {
            String str = map.get(answer).toString();
            System.out.println(str.substring(1,str.length()-1));
            /**
             *
             int i=map.get(answer).size();
             for(String str:map.get(answer)){
             if(i!=1){
             System.out.print(str+",");
             i--;
             }
             else System.out.print(str);
             }*/
        }
    }
}
