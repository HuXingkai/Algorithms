package KnapSack;
/**
 * 0-1背包问题
 * http://shmilyaw-hotmail-com.iteye.com/blog/2009761
 * 假设我们有n件物品，分别编号为1, 2...n。其中编号为i的物品价值为vi，它的重量为wi。为了简化问题，
 * 假定价值和重量都是整数值。现在，假设我们有一个背包，它能够承载的重量是W。现在，我们希望往包里装这些物品，
 * 使得包里装的物品价值最大化，那么我们该如何来选择装的东西呢？
 * */
public class KnapSack01 {
    public static int solve(int l,int w,int[] value, int[] weight, int[][] totalV) {
        for (int i=1;i<value.length;i++) {
            for (int j=1;j<=w;j++) {
                if (weight[i] > j) {
                    totalV[i][j]=totalV[i-1][j];
                } else if (totalV[i - 1][j] > totalV[i - 1][j-weight[i]] + value[i]) {
                    totalV[i][j]=totalV[i-1][j];
                }
                else {
                    totalV[i][j]=totalV[i - 1][j-weight[i]] + value[i];
                }
            }
        }
        return totalV[l][w];
    }

    public static void main(String[] args) {
        int[] v = {0, 60, 100, 120};
        int[] w = {0, 10, 20, 30};
        int weight = 50;
        int[][] c = new int[v.length][weight + 1];
        int answer = solve(3, weight, v, w, c);
        System.out.println(answer);
    }
}
