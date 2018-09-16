package huaweiTest;


import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by andy on 2018/9/16.
 */
public class stringDuplicated {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        Set<Character> set = new LinkedHashSet<>();
        for (int i=0;i<str.length();i++) {
            set.add(str.charAt(i));
        }
        for (Character a : set) {
            System.out.print(a);
        }
    }
}
