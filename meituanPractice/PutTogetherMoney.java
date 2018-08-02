package meituanPractice;
/**
 * 回溯算法，时间复杂度太大
 * */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PutTogetherMoney {
    public static List<List<Integer>> result = new ArrayList<>();

    public static void backtracking(int n, int[] steps, int start, List<Integer> list) {
        if (n < 0) {
            return;
        }
        if (n == 0) {
            result.add(new ArrayList<>(list));
        } else {
            for (int i=start;i<steps.length;i++) {
                list.add(steps[i]);
                backtracking(n - steps[i], steps, i, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[]{1,5,10,20,50,100};

        backtracking(n,array,0,new ArrayList<>());
        System.out.println(result);
        System.out.println(result.size());
    }
}
