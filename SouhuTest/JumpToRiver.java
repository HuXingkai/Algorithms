package SouhuTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by andy on 2018/9/13.
 */
public class JumpToRiver {
    public static int bfs(int n, int[] length) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(0);
        int count=1;
        int minL=1;
        while (!queue.isEmpty()) {
            int index = queue.poll();
            visited[index] = true;
            count--;
            if (index + length[index] >= n) {
                return minL;
            }
            for (int i=1;i<=length[index];i++) {
                if (length[i + index] != 0 && !visited[i + index]) {
                    queue.add(i + index);
                }
            }
            if (count == 0) {
                minL++;
                count = queue.size();
            }
        }
        return minL;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] length = new int[n];
        for (int i=0;i<n;i++) {
            length[i] = scanner.nextInt();
        }
        System.out.println(bfs(n,length));
    }
}
