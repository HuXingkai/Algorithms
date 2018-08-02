package IntroductionToAlgorithm.QuickSort;

import java.util.Arrays;

/**
 * Created by andy on 2017/6/26.
 */
public class QuickSort {
    public Partition partition=new Partition();
    public void quickSort(int[] a, int p, int r) {
        if (p < r) {
            int q =partition.PARTITION(a, p, r);
            quickSort(a, p, q - 1);
            quickSort(a, q+1, r);
        }
    }
    //快速排序的随机化版本,重在于划分的方法改变
    public void randomizedQuickSort(int[] a, int p, int r){
        if (p < r) {
            int q =partition.RANDOMIZEDPARTITION(a, p, r);
            randomizedQuickSort(a, p, q - 1);
            randomizedQuickSort(a, q+1, r);
        }
    }

    //给定主元的排序
    public void givenPovitSort(int[] a, int p, int r, int povit) {
        if (p < r) {
            int q=partition.GIVENPIVOTPARTITION(a, p, r, povit);
            //givenPovitSort(a, p, q-1, povit);
            //givenPovitSort(a, q+1, r, povit);
        }
    }
    public static void main(String[] args) {
        int[] a={2,8,7,1,3,5,6,4};
        //new QuickSort().quickSort(a,0,a.length-1);
        //new QuickSort().randomizedQuickSort(a,0,a.length-1);
        new QuickSort().givenPovitSort(a,0,a.length-1,5);
        System.out.println(Arrays.toString(a));
    }
}
