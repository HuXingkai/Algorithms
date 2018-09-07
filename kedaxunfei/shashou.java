package kedaxunfei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by andy on 2018/9/7.
 */
public class shashou {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] safe = new int[n];
        for (int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        int night=0;
        int[] tep = arr.clone();
        while (!issafe(tep)) {
            night++;
            tep = getlist(tep);
        }
        System.out.println(night);

    }

    public static boolean issafe(int[] arr) {
        for (int i=0;i<arr.length-1;i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static int[] getlist(int[] arr) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i=0;i<arr.length-1;i++) {
            if (arr[i] < arr[i + 1]) {
                list.add(i + 1);
            }
        }
        int[] newArr = new int[list.size()];
        for (int i=0;i<newArr.length;i++) {
            newArr[i] = arr[list.get(i)];
        }
        return newArr;
    }
}
