package huaweiTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by andy on 2018/9/16.
 */
public class UnzipString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(unzip(str));
    }

    public static String unzip(String str) {
        List<StringPackage> list = new ArrayList<>();
        int start=0;
        int numbegin=0;
        int numend=0;
        for (int i=0;i<str.length();i++) {
            if (str.charAt(i) < 'a') {
                numbegin=i;
                numend=i+1;
                while (numend<str.length()&&str.charAt(numend) < 'a') {
                    numend++;
                }
                int num = Integer.parseInt(str.substring(numbegin, numend));
                String p = str.substring(start, numbegin);
                StringPackage sp = new StringPackage(num, p);
                list.add(sp);
                i = numend-1;
                start = numend;
            }
            /*int num = Integer.parseInt(str.substring(numbegin, numend));
            String p = str.substring(i, numbegin);
            StringPackage sp = new StringPackage(num, p);
            list.add(sp);
            i = numend;*/
        }
        Collections.sort(list);
        String answer = "";
        for (StringPackage s : list) {
            for (int i=0;i<s.num;i++) {
                answer = answer + s.pack;
            }
        }
        return answer;
    }
}
class StringPackage implements Comparable{
    int num;
    String pack;

    public StringPackage(int n,String str) {
        num = n;
        pack = str;
    }

    @Override
    public int compareTo(Object o) {
        StringPackage sp=(StringPackage)o;
        if (num > sp.num) {
            return 1;
        }
        if (num == sp.num) {
            return pack.compareTo(sp.pack);
        }
        return -1;
    }
}
