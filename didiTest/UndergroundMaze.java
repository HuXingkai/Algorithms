package didiTest;

import java.util.*;

public class UndergroundMaze {
    public static int step=0;
    public static List<List<int[]>> findMinStep(int[][] maze,int n,int m) {
        Set<int[]> beginSet = new HashSet<>(), endSet = new HashSet<>();
        boolean[][] visited = new boolean[n][m];
        int[] startposition = {0, 0}, endpositon = {0, m - 1};
        beginSet.add(startposition);
        endSet.add(endpositon);
        List<List<int[]>> queueList = new ArrayList<>();
        List<int[]> tempList = new ArrayList<>();
        tempList.add(new int[]{0,0});
        visited[0][0] = true;
        queueList.add(new ArrayList<>(tempList));

        while (!beginSet.isEmpty()) {
            tempList.clear();
            for (int[] axias : beginSet) {
                //up
                if (axias[0] - 1 >= 0 && maze[axias[0] - 1][axias[1]] == 1 && !visited[axias[0] - 1][axias[1]]) {
                    tempList.add(new int[]{axias[0] - 1, axias[1]});
                    visited[axias[0] - 1][axias[1]] = true;

                    if (tempList.contains(endpositon)) {
                        break;
                    }
                }
                //down
                if (axias[0] + 1 < n && maze[axias[0] + 1][axias[1]] == 1 && !visited[axias[0] + 1][axias[1]]) {
                    tempList.add(new int[]{axias[0] + 1, axias[1]});
                    visited[axias[0] + 1][axias[1]] = true;
                    if (tempList.contains(endpositon)) {
                        break;
                    }
                }
                //left
                if (axias[1] - 1 >= 0 && maze[axias[0]][axias[1] - 1] == 1 && !visited[axias[0]][axias[1] - 1]) {
                    tempList.add(new int[]{axias[0], axias[1] - 1});
                    visited[axias[0]][axias[1] - 1] = true;

                    if (tempList.contains(endpositon)) {
                        break;
                    }
                }
                //right
                if (axias[1] + 1 < m && maze[axias[0]][axias[1]+ 1] == 1 && !visited[axias[0]][axias[1]+ 1]) {
                    tempList.add(new int[]{axias[0], axias[1]+ 1});
                    visited[axias[0]][axias[1]+ 1] = true;

                    if (tempList.contains(endpositon)) {
                        break;
                    }
                }
            }
            beginSet = new HashSet<>(tempList);
            queueList.add(new ArrayList<>(tempList));
        }
        return queueList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int p = scanner.nextInt();
        int[][] maze = new int[n][m];
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                maze[i][j] = scanner.nextInt();
            }
        }
        List<List<int[]>> queueList = findMinStep(maze, n, m);
        List<int[]> path = new ArrayList<>();
        path.add(new int[]{0, m - 1});
        for (int i=queueList.size()-2;i>=0;i--) {
            for (int[] list:queueList.get(i)) {
                if (Math.abs(list[1] - path.get(path.size() - 1)[1]) == 1 && (list[0] == path.get(path.size() - 1)[0])) {
                    step++;
                    path.add(new int[]{list[0], list[1]});
                }
                if ((list[0] - path.get(path.size() - 1)[0]) == 1 && (list[1] == path.get(path.size() - 1)[1])) {
                    step+=3;
                    path.add(new int[]{list[0], list[1]});
                }
                if ((list[0] - path.get(path.size() - 1)[0]) == -1 && (list[1] == path.get(path.size() - 1)[1])) {
                    path.add(new int[]{list[0], list[1]});
                }
            }
        }
        if (step > p) {
            System.out.println("Can not escape!");
        }
        else {
            System.out.println(Arrays.deepToString(path.toArray()));
            for (int i=path.size()-1;i>=0;i--) {
                if (i != 0) {
                    System.out.print("["+path.get(i)[0]+","+path.get(i)[1]+"]"+",");
                }
                else System.out.print("["+path.get(i)[0]+","+path.get(i)[1]+"]");
            }
        }
    }
}
