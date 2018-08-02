package GreedyAlgorithms;
/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Your goal is to reach the last index in the minimum number of jumps.

 For example:
 Given array A = [2,3,1,1,4]

 The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

 Note:
 You can assume that you can always reach the last index.
 思路是记录每一步可以到达的最远距离。如果该距离大于数组长度，这时候的步数即为最小的跳跃数目。
 */
public class JumpGameII {
    public int step=1;
    public int jump(int[] nums) {
        if(nums.length==1) return 0;
        int canreach = nums[0];
        int length=nums.length-1;
        int index=1;
        int longest=canreach;
        while (true) {
            if (canreach >= length) {
                return step;
            }
            step++;
            for (; index <= canreach&&canreach<length; index++) {
                if (index + nums[index] > longest) {
                    longest = index + nums[index];
                }
            }
            canreach = longest;
        }
    }

    public static void main(String[] args) {
        JumpGameII jumpGameII = new JumpGameII();
        int[] arr={7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
        int an = jumpGameII.jump(arr);
        System.out.println(an);
    }
}
