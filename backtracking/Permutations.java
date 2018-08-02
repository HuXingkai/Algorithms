package backtracking;

import java.util.ArrayList;
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
public class Permutations {
    List<List<Integer>> result=new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        int l=nums.length;
        List<Integer> list=new ArrayList<>();
        backtracking(nums,list,0,l);
        return result;
    }
    public void backtracking(int [] nums,List<Integer> list,int start,int l){
        if(list.size()>l){
            return;
        }
        else if(list.size()==l){
            result.add(new ArrayList(list));
        }
        else {
            for(int i=start;i<start+l;i++){
                if (list.contains(nums[i % l])) {//用于去掉重复的元素，减少递归，增加运行速度
                    continue;
                }
                list.add(nums[i%l]);
                backtracking(nums,list,i+1,l);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Permutations permutations=new Permutations();
        int[] nums = {1};
        List<List<Integer>> answer=permutations.permute(nums);
        System.out.println(answer);
    }
}
