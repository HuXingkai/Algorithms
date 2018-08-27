package backtracking;

import java.util.Scanner;

/**
 * Created by andy on 2018/8/24.
 * 链接：https://www.nowcoder.com/questionTerminal/728fcf136ca1488b8043c82fd2b181da
 来源：牛客网

 现在有n位工程师和6项工作(编号为0至5)，现在给出每个人能够胜任的工作序号表(用一个字符串表示，比如：045，表示某位工程师能够胜任0号，4号，5号工作)。现在需要进行工作安排，每位工程师只能被安排到自己能够胜任的工作当中去，两位工程师不能安排到同一项工作当中去。如果两种工作安排中有一个人被安排在的工作序号不一样就被视为不同的工作安排，现在需要计算出有多少种不同工作安排计划。
 输入描述:
 输入数据有n+1行： 第一行为工程师人数n(1 ≤ n ≤ 6) 接下来的n行，每行一个字符串表示第i(1 ≤ i ≤ n)个人能够胜任的工作(字符串不一定等长的)
注意：
 1、所有工程师都必须有事可做，且只能做一件事情。
 2、不必所有事都要做。

 输出描述:
 输出一个整数，表示有多少种不同的工作安排方案
 示例1
 输入
 6 012345 012345 012345 012345 012345 012345
 输出
 720
 */
public class JobsArrangements {
    public static int plans;

    public static void backtracking(int n, int[] jobs,int[][] canDo) {
        if (n < 0) {
            return;
        }
        if (n == 0) {
            plans++;
            return;
        }
        for (int i=0;i<6;i++) {
            if (canDo[n-1][i]==1 && jobs[i] == 1){
                continue;
            }
            else if (canDo[n - 1][i] == 1) {
                jobs[i] = 1;
                backtracking(n - 1, jobs, canDo);
                jobs[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[][] canDo = new int[n][6];
            for (int i=0;i<n;i++) {
                String str = scanner.next();
                for (int j=0;j<str.length();j++) {
                    canDo[i][Integer.parseInt(""+str.charAt(j))] = 1;
                }
            }
            int[] jobs = new int[6];
            backtracking(n, jobs, canDo);
            System.out.println(plans);
       // }

    }
}
