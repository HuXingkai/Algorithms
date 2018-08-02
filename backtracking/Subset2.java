package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by andy on 2017/9/29.
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,2], a solution is:

 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 */
public class Subset2 {
    List<List<Integer>> result=new ArrayList<List<Integer>>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list=new ArrayList<>();
        for(int k=0;k<=nums.length;k++){
            backtracking(nums,0,k,list);
        }
        return result;
    }
    public void backtracking(int[] nums,int start,int k,List<Integer> list){
        if(k<0){
            return;
        }
        else if(k==0){
            if(!result.contains(list)){
                result.add(new ArrayList(list));
            }
        }
        else{
            for(int i=start;i<nums.length;i++){
                list.add(nums[i]);
                backtracking(nums,i+1,k-1,list);
                list.remove(list.size()-1);
            }
        }
    }
}
