package WangyiText;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by andy on 2017/8/27.
 */
public class CopyAndPaste {

    public static int process(String str) {
        String clipboard="";
        String createStr="";
        String subStr="";
        int minNum=0;
        int i=0;
        while (i < str.length()) {
            subStr+=str.charAt(i);
            if (!createStr.contains(subStr)) {
                minNum++;//type the character
                createStr+=subStr;
                i++;
                subStr="";
            }
            else{
                while (createStr.contains(subStr)) {
                    i++;
                    if (i < str.length()) {
                        subStr += str.charAt(i);
                    }
                    else break;
                }
                if (i < str.length()) {
                    subStr = subStr.substring(0, subStr.length()-1);
                }

                if (subStr.length() == 1||subStr.equals(clipboard)) {
                    minNum++;
                    createStr+=subStr;
                    subStr = "";
                }
                else {
                    minNum+=2;
                    createStr+=subStr;
                    clipboard=subStr;
                    subStr = "";
                }
            }
        }
        return minNum;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());  // Scanner has functions to read ints, longs, strings, chars, etc.
        String[] str = new String[t];
        for (int i = 1; i <= t; ++i) {
            str[i-1]=in.nextLine();
        }
        for (int i=0;i<str.length;i++) {
            System.out.println("Case #"+(i+1)+":"+process(str[i]));
        }
    }
}
