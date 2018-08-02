package IntroductionToAlgorithm.Select;

import IntroductionToAlgorithm.QuickSort.Partition;

/**
 * Created by andy on 2017/6/26.
 * 期望时间为线性时间的选择算法，调用了快速排序的划分方法--PARTITION()
 * 目标是选出第i个顺序统计变量
 */
public class RandomizedSelect {
    public Partition partition=new Partition();
    public int randomizedSelect(int[] A, int p, int r, int i) {
        if (p == r) {
            return A[p];
        }
        int q=partition.PARTITION(A, p, r);
        int k=q-p+1;
        if (i == k) {
            return A[q];
        }
        else if (i < k) {
            return randomizedSelect(A, p, q - 1,i);
        }
        else  {
            return randomizedSelect(A, q+1, r, i-k);
        }
    }

    public static void main(String[] args) {
        int[] a={2,8,7,1,3,5,6,4,9,10,11,20,21,12,17,18,13,14,15,16,19};
        int answer=new RandomizedSelect().randomizedSelect(a, 0, a.length - 1, 19);
        System.out.println(answer);
    }
}
