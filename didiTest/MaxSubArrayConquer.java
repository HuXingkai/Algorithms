package didiTest;

import java.util.Scanner;

/**
 * 问题是这样的：一个整数数组中的元素有正有负，在该数组中找出一个连续子数组，
 * 要求该连续子数组中各元素的和最大，这个连续子数组便被称作最大连续子数组。
 * 比如数组{2,4,-7,5,2,-1,2,-4,3}的最大连续子数组为{5,2,-1,2}，最大连续子数组的和为5+2-1+2=8。
 */
public class MaxSubArrayConquer {
    public static long findMaxCrossingSubarray(int low,int mid, int high,long...A){
        long leftSum=-1000000000L;
        long sum=0;
        int maxLeft=0,maxRight=0;
        for (int i = mid; i>=low; i--) {
            sum+=A[i];
            if (sum>leftSum) {
                leftSum=sum;
                maxLeft=i;
            }
        }
        long righttSum=-1000000000L;
        long sum1=0;
        for (int i = mid+1; i<=high; i++) {
            sum1+=A[i];
            if (sum1>righttSum) {
                righttSum=sum1;
                maxRight=i;
            }
        }

        return leftSum+righttSum;
    }

    public static long findMaxSubArray(int low,int high,long...A){
        if (low==high) {
            return A[low];
        }
        else{
            int mid=(low+high)/2;
            long ArrayLeft=findMaxSubArray(low, mid, A);
            long ArrayRight=findMaxSubArray(mid+1, high, A);
            long ArrayCross=findMaxCrossingSubarray(low, mid, high, A);
            if ((ArrayLeft>ArrayRight)&&(ArrayLeft>ArrayCross)) {
                return ArrayLeft;
            }
            else if((ArrayRight>ArrayLeft)&&(ArrayRight>ArrayCross)){
                return ArrayRight;
            }
            else return ArrayCross;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long [] array = new long[n];
        for (int i=0;i<n;i++) {
            array[i] = scanner.nextInt();
        }
        long max = findMaxSubArray(0, n-1, array);
        System.out.println(max);
    }
}
