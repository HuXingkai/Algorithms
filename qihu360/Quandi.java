package qihu360;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by andy on 2018/9/17.
 */
public class Quandi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        boolean flag = false;
        for (int i=0;i<n;i++) {
            list.add(scanner.nextInt());
            if (canFormPoly(list)) {
                System.out.println(i+1);
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println(-1);
        }
    }

    public static boolean canFormPoly(ArrayList<Integer> list) {
        int len = list.size();
        for (int i = 0; i < len; i++) {
            int temp = list.remove(i);
            int sum = 0;
            for (int j = 0; j < len - 1; j++) {
                sum += list.get(j);
            }
            if (sum <= temp) { //判断是否任意len-1条边之和大于剩余一条边
                list.add(i, temp);
                return false;
            }
            list.add(i, temp);
        }
        return true;
    }
}
