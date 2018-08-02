package reviewAlgorithms;
import java.util.Arrays;

/**
 * Created by andy on 2018/7/29.
 * 分治算法中经典例子：合并排序
 * 其中 后面 带有注释符号的是需要注意的地方
 */
public class divideAndconqure {
    public void merge(int p, int q, int r, int [] A) {
        //首先创建左右两个数组（两堆扑克牌）
        int length1 = q - p + 1;
        int lenght2 =r - q; /* */
        int[] left = new int[length1 + 1];
        int[] right = new int[lenght2 + 1];
        for (int i=0;i<length1;i++) {
            left[i] = A[p+i];/* */
        }
        for (int j=0;j<lenght2;j++) {
            right[j] = A[q+1+j];/* */
        }
        left[length1] = Integer.MAX_VALUE;
        right[lenght2] = Integer.MAX_VALUE;

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        //比较两个扑克牌最上面的大小
        int index1 = 0 , index2 = 0;
        for(int i=p;i<=r;i++) {/* */
            if (left[index1] < right[index2]) {
                A[i] = left[index1];
                index1++;
                System.out.println(Arrays.toString(A)+"index1 "+index1);
            } else {
                A[i] = right[index2];
                index2++;
                System.out.println(Arrays.toString(A)+"index2 "+index2);
            }
        }
    }

    public void merge_sort(int p, int r, int[] A) {

        if (p < r) {
            int q = (r + p) / 2; System.out.println(""+q+" "+p+" "+r);
            merge_sort(p, q, A);
            merge_sort(q+1, r , A);
            merge(p, q, r, A); System.out.println(Arrays.toString(A));
        }

    }

    public static void main(String [] args) {
        int[] A = {1, 4, 7, 2, 5, 8, 3, 6, 9};
        System.out.println(Arrays.toString(A));
        new divideAndconqure().merge_sort(0, A.length-1, A);
        System.out.println(Arrays.toString(A));
    }
}
