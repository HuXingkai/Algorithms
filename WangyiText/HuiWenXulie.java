package WangyiText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andy on 2017/8/22.
 * 如果一个数字序列逆置之后跟原序列是一样的就称这样的数字序列为回文序列。例如：
 {1, 2, 1}, {15, 78, 78, 15} , {112} 是回文序列,
 {1, 2, 2}, {15, 78, 87, 51} ,{112, 2, 11} 不是回文序列。
 现在给出一个数字序列，允许使用一种转换操作：
 选择任意两个相邻的数，然后从序列移除这两个数，并用这两个数字的和插入到这两个数之前的位置(只插入一个和)。
 现在对于所给序列要求出最少需要多少次操作可以将其变成回文序列。
 */
public class HuiWenXulie {
    public List<Integer> strpNum = new ArrayList<>();
    public int arrayLength;

    //    判断一个序列是否为回文序列
    public boolean isHuiWen(int... A) {
        int length = A.length;
        if (length == 1) {
            return true;
        }
        for (int i=0;i<length/2;i++) {
            if (A[i] != A[length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    // 定义一步操作，判断一步操作之后是否为回文序列
    public void operate(int... A) {
        for (int i=0;i<A.length-1;i++) {
            int[] array1 = new int[A.length - 1];
            for (int j=0;j<array1.length;j++) {
                if (j < i) {
                    array1[j] = A[j];
                }
                else if (j == i) {
                    array1[j] = A[j]+A[j + 1];
                }
                else array1[j] = A[j + 1];
            }
            if (isHuiWen(array1)) {
                strpNum.add(arrayLength-array1.length);
            } else operate(array1);
        }
    }
    public int huiwenStep(int n,int... A) {
        this.arrayLength=n;
        if (isHuiWen(A)) {
            return 0;
        }
        operate(A);
        int minStep=n;
        for (int num:strpNum) {
            if (num < minStep) {
                minStep=num;
            }
        }
        return minStep;
    }

    public static void main(String[] args) {
        HuiWenXulie hui = new HuiWenXulie();
        int[]A={1,2,1};
        int n=hui.huiwenStep(3, A);
        System.out.println(n);
    }

}
