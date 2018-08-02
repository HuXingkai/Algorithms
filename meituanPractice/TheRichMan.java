package meituanPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheRichMan {
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
                backtracking(n - steps[i], steps, 0, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i=0;i<n;i++) {
            array[i] = i+1;
        }
        backtracking(n,array,0,new ArrayList<>());
        System.out.println(result.size());
    }
}
