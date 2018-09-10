package aibank;

/**
 * Created by andy on 2018/9/10.
 * 实现字符串中 indexOf()方法
 * 匹配字符串方法，时间复杂度很高
 * KMP算法有时间看一下
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SubStringIndexOF {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int substringIndex(String source, String target) {
        int index = -1;
        boolean match = true;
        for (int i=0;i<=source.length()-target.length();i++) {
            match = true;

            for (int j=0;j<target.length();j++) {
                if (source.charAt(i+j) != target.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                index = i;
                break;
            }
        }
        return index;

    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        String _source;
        try {
            _source = in.nextLine();
        } catch (Exception e) {
            _source = null;
        }

        String _target;
        try {
            _target = in.nextLine();
        } catch (Exception e) {
            _target = null;
        }

        res = substringIndex(_source, _target);
        System.out.println(String.valueOf(res));

    }
}
