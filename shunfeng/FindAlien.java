package shunfeng;


import java.util.*;

/**
 * Created by andy on 2018/9/17.
 */
public class FindAlien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer, Integer> map1 = new LinkedHashMap<>();
        Map<Integer, Integer> map2 = new LinkedHashMap<>();
        for (int i=0;i<n;i++) {
            int key = scanner.nextInt();
            map1.put(key, i);
        }
        for (int i=0;i<n;i++) {
            int key = scanner.nextInt();
            map2.put(key, i);
        }

        int num=0;

        for (int i=0;i<n;i++) {
            for (int j=i+1;j<n;j++) {
                if ((map1.get(i) - map1.get(j) > 0) && (map2.get(i) - map2.get(j) < 0)) {
                    num++;
                }
                if ((map1.get(i) - map1.get(j) < 0) && (map2.get(i) - map2.get(j) > 0)) {
                    num++;
                }
            }
        }
        System.out.println(num);
    }
}
