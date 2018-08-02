package pingan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by andy on 2017/10/19.
 */
public class Main {
    public static int findNum(int n) {
        boolean noIncrease = true;
        int num = n + 1;
        String strNUm = num + "";
        List<Character> minlist = new ArrayList<>();
        for (char i='0';i<='9';i++) {
            minlist.add(i);
        }
        char[] charArr = strNUm.toCharArray();
        List<Character> characters = new ArrayList<>();//existed
        for (int j=0;j<charArr.length;j++) {
            if (!characters.contains(charArr[j])&&noIncrease) {
                characters.add(charArr[j]);
                int index = minlist.indexOf(charArr[j]);
                minlist.remove(index);
            }
            else {
                int k=0;
                boolean ifwhile = false;
                while (noIncrease) {
                    if (charArr[j] < minlist.get(k)) {
                        charArr[j] = minlist.remove(k);
                        noIncrease = false;
                        ifwhile = true;
                        break;
                    }
                    k++;
                }
                if (!ifwhile) {
                    charArr[j] = minlist.remove(0);
                }
                characters.add(charArr[j]);
            }
        }
        String answer = "";
        for (char m:charArr) {
            answer += m;
        }
        return Integer.parseInt(answer);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = findNum(n);
        System.out.println(a);
    }
}
