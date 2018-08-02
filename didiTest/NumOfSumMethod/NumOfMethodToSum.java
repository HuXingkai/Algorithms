package didiTest.NumOfSumMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumOfMethodToSum {
    public static List<List<Integer>> result = new ArrayList<>();
    public static List<Integer> temp = new ArrayList<>();
    public static void backtracking(int[] array, int start,int sum) {
        if (sum < 0) {
            return;
        }
        if (sum == 0) {
            result.add(new ArrayList<>(temp));
        }
        if (sum > 0) {
            for (int i=start;i<array.length;i++) {
                temp.add(array[i]);
                backtracking(array, i + 1, sum - array[i]);
                temp.remove(temp.size() - 1);
            }

        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = scanner.nextInt();
        int[] array = new int[n];
        for (int i=0;i<n;i++) {
            array[i]=scanner.nextInt();
        }
        backtracking(array,0,sum);
        System.out.println(result);
        System.out.println(result.size());
    }
}
