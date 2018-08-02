package alibabaTextOnline;

/**
 * Created by andy on 2017/7/5.
 * 题目地址：http://blog.csdn.net/heheSakura/article/details/69951794
 */
public class FindMinStep {
    public int max;
    public int findMinStepToEnd(int[] A) {
        int n=1;
        int index=0;
        while (max < A.length-1) {
            index = longestCanReach(index, A);
            System.out.println(A[index]);
            n=n+1;
        }
        return n;
    }
    //此方法用于判断在当前可以选择的前进步数内，加上到达位置的步数，最远能达到的位置。
    public int longestCanReach(int n,int[]A) {
        max = 0;
        int index=n+1;
        for (int i=n+1;i<n+A[n];i++) {
            int max1 = i + A[i];
            if (max1 > max) {
                max=max1;
                index=i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] array={3,4,2,1,3,1};
        FindMinStep findMinStep=new FindMinStep();
        System.out.println(findMinStep.findMinStepToEnd(array));
    }
}
