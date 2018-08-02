package aiqiyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by andy on 2017/10/14.
 */
public class grassGame {
    static List<Integer> niuW = new ArrayList<>();
    static List<Integer> yangW = new ArrayList<>();
    public static void win(int n) {
        yangW.add(0);
        for (int i=1;i<=n;i++) {
            List<Integer> steps = canStep(i);
            boolean niuhas=false;
            for (int step:steps) {
                if (yangW.contains(i-step)) {
                    niuW.add(i);
                    niuhas=true;
                    break;
                }
            }
            if (!niuhas) {
                for (int step:steps) {
                    if (niuW.contains(i-step)) {
                        yangW.add(i);
                        break;
                    }
                }
            }
        }
    }

    public static List<Integer> canStep(int m) {
        List<Integer> listStep = new ArrayList<>();
        int i=0;
        while (Math.pow(4, i) <= m) {
            listStep.add((int)Math.pow(4, i));
            i++;
        }
        return listStep;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] arr=new int[t];
        for(int i=0;i<t;i++) {
            arr[i] = scanner.nextInt();
        }
        int[] arr1=arr.clone();
        Arrays.sort(arr1);
        win(arr1[arr1.length - 1]);
        for (int num:arr) {
            if (niuW.contains(num)) {
                System.out.println("niu");
            }
            if (yangW.contains(num)) {
                System.out.println("yang");
            }
        }
    }
}
