package IntroductionToAlgorithm.QuickSort;

import java.util.Random;

/**
 * Created by andy on 2017/6/26.
 *快速排序的关键部分：数组的划分操作
 */
public class Partition {
    //一般的数组划分过程
    public int PARTITION(int[] A,int p,int r){
        int x = A[r];
        int i = p - 1;
        for (int j=p;j<r;j++) {
            if (A[j] <= x) {
                i=i+1;
                exchange(A,i,j);
            }
        }
        exchange(A,i+1,r);
        return  i+1;
    }

    //快速排序的随机化版本
    public int RANDOMIZEDPARTITION(int[] A, int p, int r) {
        int random= new Random().nextInt(r-p)+p;
        //产生一个随机数作为主元。交换的目的是为了重复使用PARTITION（）方法
        exchange(A, random, r);
        return PARTITION(A, p, r);
    }

    //给定主元的划分过程，线性时间的选择算法中用到，返回值为数组中主元的位置，从0开始
    public int GIVENPIVOTPARTITION(int[] A, int p, int r, int pivot) {
        int x = pivot;
        int i = p - 1;
        //k用于记录主元的位置，最后进行交换。
        int k=0;
        for (int j=p;j<=r;j++) {
            if (A[j] < x) {
                i=i+1;
                if (i == k) {
                    k=j;
                }
                exchange(A,i,j);
            } else if (A[j] == x) {
                k=j;
            }
        }
        exchange(A,i+1,k);
        return  i+1;
    }

    public void exchange(int[] A,int i, int j) {
        int MiddleVal=0;
        MiddleVal=A[i];
        A[i] = A[j];
        A[j]=MiddleVal;
    }
}
