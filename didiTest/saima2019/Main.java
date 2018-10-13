package didiTest.saima2019;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by andy on 2018/10/9.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i=0;i<T;i++) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int j=0;j<n;j++) {
                arr[j] = scanner.nextInt();
            }
            System.out.println(find(arr));
        }
    }
    public static String find(int arr[]){
        for(int i=0; i<arr.length-1; ++i)
        {
            Arrays.sort(arr,i,arr.length-1);
            if(i+arr[i] >= arr.length-1) return "No";
            for(int j=i+1; j<=i+arr[i] ; ++j)
            {
                --arr[j];
                if(arr[j] < 0) return "No";
            }
        }
        if(arr[arr.length-1-1]!=0) return "No";
        return "Yes";
    }

}
