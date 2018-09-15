package SouhuTest;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by andy on 2018/9/13.
 */
public class ColorRing {
    public static int find(String str) {
        int max=-1;
        for (int i=0;i<str.length();i++) {
            Set set = newSet();
            if (set.contains(str.charAt(i))) {
                int start = i+1;
                set.remove(str.charAt(i));
                while (!set.isEmpty()) {
                    if (set.contains(str.charAt(start%str.length()))) {
                        set.remove(str.charAt(start%str.length()));
                        start++;
                    }
                    else start++;
                }
                max = Math.max(max, str.length() - start + i);
            }
        }
        return max;
    }

    public static Set newSet() {
        Set<Character> set = new HashSet<>();
        for (int i=0;i<5;i++) {
            set.add((char)('A'+i));
        }
        return set;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            System.out.println(find(str));
        }
    }
}
