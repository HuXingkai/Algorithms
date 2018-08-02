package reviewAlgorithms;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by andy on 2018/7/29.
 */
public class bianrySearch {
    public int search(int[] numbers, int p,int r,  int key){
        if (p <= r) {
            int q = (r + p) / 2;
            System.out.println(p+" "+q+" "+r);
            if (numbers[q] == key) {
                return q;
            } else if (numbers[q] > key) {
                return search(numbers, p, q-1, key);//这里的-1非常有必要！否则在判断小于最小值的时候，会死循环
            }
            else return search(numbers, q+1, r, key);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(new bianrySearch().search(A,0,A.length-1,9));
        int[][] arr = {
                {2,3,4},
                {4,5,6},
                {7,8,9},
                {7,8,9}
        };
        System.out.println(arr.length);
        System.out.println(arr[0].length);
        System.out.println(Arrays.deepToString(arr));
    }
}
