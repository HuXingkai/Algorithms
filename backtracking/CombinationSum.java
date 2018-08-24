package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andy on 2018/8/24.
 * Combination Sum

 Given a set ofcandidate numbers (C) and a target number (T), findall unique combinations in C where thecandidate numbers sums toT.

 The same repeated numbermay be chosen from C unlimited numberof times.

 Note:

 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example,given candidate set [2, 3, 6, 7] and target 7,
 A solution set is:

 [

 [7],

 [2,2, 3]

 ]

 （容我啰嗦地白话下，给你一个正数数组candidate[],一个目标值target，寻找里面所有的不重复组合，让其和等于target，给你[2,3,6,7] 2+2+3=7 ,7=7,所以可能组合为[2,2,3],[7]）
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtracking(candidates, 0, target, list, result);
        return result;
    }

    public void backtracking(int[] candidates, int start, int target, List<Integer> list, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList(list));
        }
        for (int i=start;i<candidates.length;i++) {
            list.add(candidates[i]);
            backtracking(candidates, i, target - candidates[i], list, result);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum sum = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        System.out.println(sum.combinationSum(candidates, 7));

    }
}
