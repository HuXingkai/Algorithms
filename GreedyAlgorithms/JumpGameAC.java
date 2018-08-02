package GreedyAlgorithms;

public class JumpGameAC {
    public boolean canJump(int[] nums) {
        if (nums.length == 0) return false;

        int maxCover = 0, step = 1;
        for (int i = 0; i < nums.length; i++) {
            step--;
            if (i + nums[i] > maxCover) {
                maxCover = i + nums[i];
                step = nums[i];
            }
            if (step == 0 && i < nums.length-1) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        JumpGameAC jumpGame = new JumpGameAC();
        int[] arr={2,3,1,1,4};
        System.out.println(jumpGame.canJump(arr));
    }
}
