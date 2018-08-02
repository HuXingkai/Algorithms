package IntroductionToAlgorithm;

import java.util.Arrays;

/**
 * Created by andy on 2017/6/24.
 */
public class FindMaxAndMin {
    public int[] FindMaxMin(int[] A){
        int L=A.length;
        double beginIndex=0;
        int[] answer = new int[2];
        int temporaryMax = A[0];
        int temporaryMin = A[1];
        if (L % 2 == 1) {
            beginIndex=0.5;
            temporaryMax = temporaryMin = A[0];
        }
        int Max,Min=0;
        for (double j=beginIndex;j<L/2;j++) {
            int i= (int) (2*j);
            if (A[i] > A[i + 1]) {
                Max=A[i];
                Min=A[i + 1];
            }
            else{
                Min=A[i];
                Max=A[i + 1];
            }
            if (temporaryMax < Max) {
                temporaryMax=Max;
            }
            if (temporaryMin > Min) {
                temporaryMin = Min;
            }
        }
        answer[0]=temporaryMax;
        answer[1]=temporaryMin;
        return answer;
    }
    public static void main(String args[]){
        FindMaxAndMin findMaxAndMin=new FindMaxAndMin();
        int[] A={2,7,11,15,10,0,20};
        System.out.println(Arrays.toString(findMaxAndMin.FindMaxMin(A)));
    }
}
