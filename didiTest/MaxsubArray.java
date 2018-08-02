package didiTest;

import java.util.Scanner;

public class MaxsubArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i=0;i<n;i++) {
            array[i] = scanner.nextInt();
        }
        int max=array[0];
        int sum=0;
        int MaxSum=0;
        int low=0,high=0;
        for (int i = 0; i < array.length-1; i++) {
            sum+=array[i];
            if (sum>MaxSum) {
                MaxSum=sum;
                high=i;
            }
            if (sum<0) {
                sum=0;
                low=i+1;
            }
        }
        System.out.println(MaxSum);
    }
}
