package jianzhiOffer;

import java.util.Arrays;

/**
 * Created by andy on 2018/8/31.
 */
public class LinerTimeSort {
    public static void sortAges(int[] ages, int length) {
        if (length == 0) {
            return;
        }
        //设定的最长的寿命
        int oldestAge = 120;
        //用于保存每个年龄出现的次数
        int[] timesOfAge = new int[oldestAge + 1];
        for (int a : ages) {
            timesOfAge[a]++;
        }

        int index = 0;
        //年龄从0到最大
        for (int i=0;i<=oldestAge;i++) {
            //在年龄i下，一共出现了timesOfAge[i]次，经这些年龄一次放入ages中。
            //由于年龄时从小到大的顺序遍历，因此这里就相当于给数组排序了
            for (int j=0;j<timesOfAge[i];j++) {
                ages[index] = i;
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] ages = {1, 18, 45, 2, 15, 12, 86, 34, 32, 48, 8};
        sortAges(ages, ages.length);
        System.out.println(Arrays.toString(ages));
    }
}
