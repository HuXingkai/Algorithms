package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by andy on 2017/10/2.
 */
public class Permutation6ms {
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> curres=new ArrayList<Integer>();
        dfs(curres,nums,0,0);
        return res;
    }

    public void dfs(ArrayList<Integer> curres, int[] nums, int index, int start){
        if(curres.size()==nums.length){
            res.add(new ArrayList<>(curres));
            return;
        }
        int i=0;
        if (index>0&&nums[index]==nums[index-1]){
            i=start;
        }
        for(;i<=index; i++){
            curres.add(i,nums[index]);
            dfs(curres,nums,index+1,i+1);
            curres.remove(i);
        }
        return;
    }
    public static void main(String[] args) {
        Permutation6ms permutations=new Permutation6ms();
        int[] nums = {2,2,1,1};
        List<List<Integer>> answer=permutations.permuteUnique(nums);
        System.out.println(answer);
    }
}
