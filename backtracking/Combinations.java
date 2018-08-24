package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://blog.csdn.net/versencoder/article/details/52071930
 * Created by andy on 2018/8/24.
 * Combinations：Given two integers n and k,return all possible combinations of k numbersout of 1 ... n. For example, If n = 4 and k =2, a solution is:
 [

 [2,4],

 [3,4],

 [2,3],

 [1,2],

 [1,3],

 [1,4],

 ]

 （做一个白话版的描述，给你两个整数 n和k，从1-n中选择k个数字的组合。比如n=4，那么从1,2,3,4中选取两个数字的组合，包括图上所述的四种。）
 */
public class Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtracking(n, k, 1, list, result);
        return result;
    }

    public static void backtracking(int n, int k, int start, List<Integer> list,List<List<Integer>> result) {
        if (k < 0) {
            return;
        }
        if (k == 0) {
            //这个地方要注意，不能直接将list加到result中，因为那样只是给了个引用。会在后续过程中变化。
            //应该新建一个对象
            result.add(new ArrayList(list));
        }
        for (int i=start;i<=n;i++) {
            list.add(i);
            backtracking(n, k - 1, i + 1, list, result);
            //这个地方是回溯
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = combine(4, 2);
        System.out.println(result);
    }
}
