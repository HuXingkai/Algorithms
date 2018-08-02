package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by andy on 2017/10/2.
 * Given a collection of distinct numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]

 */
public class PermutationsB {
    List<List<Integer>> result=new ArrayList<List<Integer>>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list=new ArrayList<>();
        List<Integer> index=new ArrayList<>();
        backtracking(nums,list,index,new boolean[nums.length]);
        return result;
    }
    public void backtracking(int[] nums,List<Integer> list,List<Integer> index,boolean[] used){
        if(list.size()>nums.length){
            return;
        }
        else if(list.size()==nums.length){//&&!result.contains(list)
            result.add(new ArrayList(list));
        }
        else {
            for(int i=0;i<nums.length;i++){
                if (index.contains(i)) {
                    continue;
                }
                if (i>0&&!used[i-1]&& nums[i] == nums[i - 1]) {
                    continue;
                }
                used[i]=true;
                list.add(nums[i]);
                index.add(i);
                backtracking(nums,list,index,used);
                list.remove(list.size()-1);
                index.remove(index.size()-1);
                used[i]=false;
            }
        }

    }

    public static void main(String[] args) {
        PermutationsB permutations=new PermutationsB();
        int[] nums = {2,2,1,1};
        List<List<Integer>> answer=permutations.permuteUnique(nums);
        System.out.println(answer);
    }
}
