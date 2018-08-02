package didiTest;

import java.util.*;

public class Restaurant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<Integer> deskCap = new ArrayList<>();
        for (int i=0;i<n;i++) {
            deskCap.add(scanner.nextInt());
        }
        Collections.sort(deskCap);
        int[][] guests = new int[m][2];
        for (int i=0;i<m;i++) {
            for (int j=0;j<2;j++) {
                guests[i][j] = scanner.nextInt();
            }
        }
        //这个排序方式很用用！数组用Arrays，集合用Collections
        Arrays.sort(guests, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        long maxMoney=0;
        for (int i=m-1;i>=0;i--) {
            for (int j=0;j<deskCap.size();j++) {
                if (guests[i][0] <= deskCap.get(j)) {
                    deskCap.remove(j);
                    maxMoney += guests[i][1];
                    break;
                }
            }
        }
        System.out.println(maxMoney);
    }
}
