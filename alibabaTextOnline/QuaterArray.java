package alibabaTextOnline;

/**
 * Created by andy on 2017/7/5.
 * 原题目地址：http://blog.csdn.net/dream__tt/article/details/62037647
 */
public class QuaterArray {
    public boolean checkQuaterArary(int[] A) {
        for (int m1 = 1; m1 < A.length - 5; m1++) {
            int sum1=0;
            //求出前几个数的和
            for (int i=0;i<m1;i++) {
                sum1 = sum1 + A[i];
            }

            int m2 = sumArray(m1, A, sum1);
            if (m2 > 0) {
                int m3 = sumArray(m2, A, sum1);
                if (m3 > 0) {
                    int m4 = sumArray(m3, A, sum1);
                    if (m4 == A.length) {
                        System.out.println(""+m1+"-"+m2+"-"+m3);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int sumArray(int m, int[] A,int sum) {
        int k=m+1;
        int sum2=0;
        while (sum2 < sum && (k<A.length)) {
            sum2 = sum2 + A[k];
            k=k+1;
            if (sum2 == sum) {
                return k;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        QuaterArray quaterArray=new QuaterArray();
        int[] array={2,5,1,1,1,1,4,1,7,3,7};
        System.out.println(quaterArray.checkQuaterArary(array));
    }
}
