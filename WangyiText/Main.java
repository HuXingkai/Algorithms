package WangyiText;

import java.util.Scanner;

/**
 * Created by andy on 2017/8/22.
 * 回文序列的解法：时间复杂度为O(n)
 *
 * 最终序列总是原序列的一个连续段的和。
 所以等价于是把原序列分成若干段，每段的和构成回文。
 所以直接从两侧开始维护当前前缀/后缀的和。如果都是
 正数的话那有个简单的办法。左边>右边：后缀前进一个数。
 左边<右边：前缀前进一个数。左边=右边：可以把前缀后缀
 都砍成一段，构成回文，然后重新起前缀后缀继续计算。O(n)就能做掉。
 */
public class Main {
    public static int solve(int n, int... arr) {
        int ans=0;
        int left=0;
        int right=n-1;
        while (left<right) {
            if (arr[left] < arr[right]) {
                arr[left+1] = arr[left] + arr[left + 1];
                left++;
                ans++;

            }
            else if (arr[left] > arr[right]) {
                arr[right-1] = arr[right] + arr[right - 1];
                right--;
                ans++;

            }
            else {
                left++;
                right--;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++) {
            arr[i]=scanner.nextInt();
        }
        System.out.println(solve(n,arr));
    }
}
