package SouhuTest;

import java.util.Scanner;

/**
 * Created by andy on 2018/9/13.
 */
public class VersionCompare {
    public static int compareVersion(String version1, String version2) {
        String [] levels1=version1.split("\\.");
        String [] levels2=version2.split("\\.");

        int length = Math.max(levels1.length, levels2.length);

        for (int i=0;i<length;i++) {
            Integer l1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
            Integer l2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
            int com = l1.compareTo(l2);
            if (com != 0) {
                return com;
            }
        }

        return 0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String version1 = scanner.next();
        String version2 = scanner.next();
        System.out.println(compareVersion(version1,version2));
    }
}
