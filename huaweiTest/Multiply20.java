package huaweiTest;

import java.util.Scanner;

/**
 * Created by andy on 2018/9/16.
 */
public class Multiply20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num1 = scanner.nextLine();
        String num2 = scanner.nextLine();
        System.out.println(multiply(num1, num2));
        System.out.println("————————————");
        System.out.println(multi1(num1, num2));
    }

    /**方法详解：
     * https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation?page=2
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] position = new int[m + n];

        for (int i=m-1;i>=0;i--) {
            for (int j=n-1;j>=0;j--) {
                int mul=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = mul + position[p2];

                position[p1] += sum / 10;
                position[p2] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int pos : position) {
            if (!(sb.length() == 0 && pos == 0)) {
                sb.append(pos);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static String multi1(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        String[] step1 = new String[n];
        for (int i=n-1;i>=0;i--) {
            int jinwei=0;
            String tem = "";
            for (int j=m-1;j>=0;j--) {
                int mul = (num2.charAt(i) - '0') * (num1.charAt(j) - '0');
                mul += jinwei;
                if (j != 0) {
                    tem = mul % 10 + tem;
                    jinwei = mul / 10;
                }else tem = mul + tem;

            }
            for (int k=0;k<n-i-1;k++) {
                tem += "0";
            }
            step1[i] = tem;
        }

        int newL = step1[0].length();
        for (int i=0;i<n;i++) {
            int l = step1[i].length();
            for (int j=0;j<newL-l;j++) {
                step1[i] = "0" + step1[i];
            }
        }

        int jinwei=0;
        String result = "";
        for (int i = newL - 1; i >= 0; i--) {

            int sum =0;
            for (int j=0;j<n;j++) {
                sum += (step1[j].charAt(i) - '0');
            }

            sum += jinwei;
            if (i != 0) {
                result=sum % 10 + result;
                jinwei = sum / 10;
            }
            else result=sum + result;
        }
        return result.split("0").length==0?"0":result;
    }
}
