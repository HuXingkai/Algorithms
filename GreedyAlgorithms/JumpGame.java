package GreedyAlgorithms;
/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.

 For example:
 A = [2,3,1,1,4], return true.

 A = [3,2,1,0,4], return false.*/
public class JumpGame {
    public int step=1;
    public boolean canJump(int[] nums) {
        int length = nums.length-1;
        if(length==0) return true;
        int[] farest = new int[length];
        for (int i=0;i<length;i++) {
            farest[i] = i + nums[i];
            if (farest[i] >= length && canReach(farest, i)) {
                return true;
            }
        }
        return false;
    }

    public boolean canReach(int[] far,int i) {
        if (i==0) return true;
        for (int k=0;k<i;k++) {
            if (far[k] >= i) {
                return canReach(far,k);
            }
        }
        return false;
    }

    //尝试新解法,每次只在能够到达的最远位置之内遍历，更新能够到达的最远值，如果最远位置超过数组长度，结束遍历。最多只遍历一遍。
    //Accepted！！！
    public boolean canjump(int[] nums) {
        int canreach = nums[0];
        int length=nums.length-1;
        int index=1;
        for (; index <= canreach&&canreach<length; index++) {
            if (index + nums[index] > canreach) {
                canreach = index + nums[index];
                step++;
            }
        }
        if (canreach >= length) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        int[] arr={2,3,1,1,4};
        System.out.println(jumpGame.canjump(arr));
        System.out.println(jumpGame.step);
    }
}
/*更简洁的方法
本题用一个数 reach 表示能到达的最远下标，一步步走下去，如果发现在 reach 范围之内某处能达到的范围大于 reach，
那么我们就用更大的范围来替换掉原先的 reach，这样一个局部的最优贪心策略，在全局看来也是最优的，因为
局部能够到达的最大范围也是全局能够到达的最大范围：
* public boolean canJump(int[] nums) {
        int reach = nums[0];
        for(int i = 1; i < nums.length && reach >= i; i++)
            if(i + nums[i] > reach) reach = i + nums[i];  //贪心策略
        return reach >= (nums.length-1) ? true : false;
    }  */