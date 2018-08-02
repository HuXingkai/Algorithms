package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by andy on 2017/10/2.
 */
public class PermutationII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                /**
                 * 这个判断很漂亮！记录已经加入list的元素，来判断下一个（重复）元素是否应该加入
                 * */
                if(used[i] || i > 0 && nums[i] == nums[i-1]&& !used[i - 1] ) continue;//&& !used[i - 1]
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        PermutationII permutations=new PermutationII();
        int[] nums = {2,2,1,1};
        List<List<Integer>> answer=permutations.permuteUnique(nums);
        System.out.println(answer);
    }
}
