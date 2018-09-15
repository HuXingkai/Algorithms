package SouhuTest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by andy on 2018/9/13.
 */
public class MaxNum {
    public static void find(String number, int cnt) {
        int nums=0;
        StringBuilder result=new StringBuilder();
        result.append(number);
        for (int i=0;i<number.length()-1;i++) {
            if (nums >= cnt) {
                break;
            }
            if (number.charAt(i) < number.charAt(i + 1)) {
                nums++;
                result.replace(i, i + 1, "A");
            }
        }
        String answer;
        int j = number.length() - 1;
        while (nums < cnt) {
            if (result.charAt(j) != 'A') {
                result.replace(j, j + 1, "A");
                j--;
                nums++;
            } else j--;
        }
        answer = result.toString();

        String[] strs = answer.split("A");
        for (String str : strs) {
            System.out.print(str);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number=sc.nextLine();
        int cnt = sc.nextInt();
        /*String strNum = number + "";
        char[] chars = strNum.toCharArray();
        Arrays.sort(chars);

        String result = "";
        for (int i=0;i<cnt;i++) {
            result = strNum.substring(0, strNum.indexOf(chars[i]))+
                    strNum.substring(strNum.indexOf(chars[i])+1, strNum.length());
            strNum = result;
        }
        System.out.println(result);*/
        find(number,cnt);
    }
}
