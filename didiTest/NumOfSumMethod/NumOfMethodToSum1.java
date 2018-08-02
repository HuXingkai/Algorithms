package didiTest.NumOfSumMethod;

import java.util.Scanner;

public class NumOfMethodToSum1 {
    public static int num=0;
    public static void backtracking(int[] array, int start,int sum) {
        if (sum < 0) {
            return;
        }
        if (sum == 0) {
            num++;
        }
        if (sum > 0) {
            for (int i=start;i<array.length;i++) {
                backtracking(array, i + 1, sum - array[i]);
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
        System.out.println(num);
    }
}
