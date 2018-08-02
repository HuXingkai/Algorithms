package IntroductionToAlgorithm.Select;

import IntroductionToAlgorithm.QuickSort.Partition;

import java.util.Arrays;

/**
 * Created by andy on 2017/6/26.
 * 最坏情况为线性时间的选则算法
 */
public class Select {
    public Partition partition=new Partition();
    public int selectMedian(int[] A,int p,int r) {
        int L=(r-p)/5+1;
        int[][] subArray=new int[L][];
        for (int i=0;i<L;i++) {
            if (i < L - 1) {
                subArray[i]=new int[5];
            }
            else subArray[i]=new int[(r-p+1)-5*(L-1)];

            for (int j=0;j<5;j++) {

                if ((j + 5 * i) < (r-p+1)) {
                    subArray[i][j]=A[p+j+5*i];
                }
            }
        }
        int[] Median=new int[L];
        for (int i=0;i<L;i++) {
            insertSortion(subArray[i]);
            //求中位数，如果偶数个数，约定为下中位数
            Median[i] = subArray[i][(subArray[i].length-1)/ 2];
        }
        if (L == 1) {
            return Median[0];
        } else return selectMedian(Median,0,Median.length-1);
    }

    public int lineSelect(int[] A, int p, int r, int i) {
        if (p == r) {
            return A[p];
        }
        int q=partition.GIVENPIVOTPARTITION(A, p, r, selectMedian(A,p,r));
        int k=q-p+1;
        if (i == k) {
            return A[q];
        }
        else if (i < k) {
            return lineSelect(A, p, q - 1,i);
        }
        else  {
            return lineSelect(A, q+1, r, i-k);
        }
    }

    //插入排序算法
    public void insertSortion(int[] Array) {
        for (int m=1;m<Array.length;m++) {
            int key = Array[m];
            int n=m-1;
            while (n >= 0 && Array[n] > key) {
                Array[n+1]=Array[n];
                n=n-1;
            }
            Array[n+1]=key;
        }
    }

    public static void main(String[] args) {
        int[] a={2,8,7,1,3,5,6,4,9,10,11,20,21,12,17,18,13,14,15,16,19};
        //new Select().insertSortion(a);
        int ans=new Select().lineSelect(a, 0, a.length - 1, 19);
        System.out.println(ans);
    }
}
