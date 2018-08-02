package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andy on 2017/9/29.
 * Given a set of distinct integers, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,3], a solution is:

 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 *
 */
public class Subsets {
    List<List<Integer>> result=new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int k=0;k<=nums.length;k++){
            backtracking(nums,0,k,list);
        }
        return result;
    }
    public void backtracking(int[] nums, int start, int k,List<Integer> list){
        if(k<0){
            return;
        }
        else if(k==0){
            result.add(new ArrayList(list));
        }
        else{
            for(int i=start;i<nums.length;i++){
                list.add(nums[i]);
                backtracking(nums,i+1,k-1,list);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Subsets subsets=new Subsets();
        int[] nums={1,2,3};
        List<List<Integer>> answer=subsets.subsets(nums);
        System.out.println(answer);
    }
}
