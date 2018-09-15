package SouhuTest;

import java.util.*;

/**
 * Created by andy on 2018/9/13.
 */
public class BrotherString {
    public static boolean ifBro(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        if (str1.equals(str2)) {
            Set<Character> s = new HashSet<>();
            for (char c : str1.toCharArray()) {
                s.add(c);
            }
            return s.size() < str1.length();
        }

        List<Integer> dif = new ArrayList<>();
        for (int i=0;i<str1.length();i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                dif.add(i);
            }
        }
        return dif.size() == 2 && str1.charAt(dif.get(0)) == str2.charAt(dif.get(1)) && str1.charAt(dif.get(1)) == str2.charAt(dif.get(0));

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        if (ifBro(str1, str2)) {
            System.out.println(1);
        }
        else System.out.println(0);
    }
}
