package jingdongTest;

import java.util.Scanner;
import java.util.Stack;

/**https://www.nowcoder.com/profile/2475858/test/18412018/105619
 * Created by andy on 2018/9/9.
 */
public class baoweifangan {
    public static int[] sortArr(int[] mounts,int index) {
        if (index == 0) {
            return mounts;
        }
        int[] ans = new int[mounts.length];
        System.arraycopy(mounts,index,ans,0,mounts.length-index);
        System.arraycopy(mounts,0,ans,mounts.length-index,index);
        return ans;
    }

    public static int solve(int[] mounts) {
        if (mounts.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(mounts[0]);

        int i=1;
        int result = mounts.length;
        int duplited=1;
        while (!stack.isEmpty()&&i<mounts.length) {
            if (mounts[i] < stack.peek()) {
                stack.push(mounts[i]);
                i++;
                if (duplited > 2) {
                    if (i != mounts.length - 1) {
                        result += (duplited * duplited - 3 * duplited) / 2+1;
                    }
                    else result += (duplited * duplited - 3 * duplited) / 2;

                }
                duplited = 1;
                continue;
            }
            while (!stack.isEmpty()&&mounts[i] >= stack.peek()) {

                if (mounts[i] == stack.peek()) {
                    duplited++;
                    if (i == mounts.length - 1) {
                        if (duplited > 2) {
                            if (i != mounts.length - 1) {
                                result += (duplited * duplited - 3 * duplited) / 2+1;
                            }
                            else result += (duplited * duplited - 3 * duplited) / 2;

                        }
                    }
                    break;
                }

                else if (stack.size() != 2 || i != mounts.length - 1) {
                    result++;
                    if (duplited > 2) {
                        if (i != mounts.length - 1) {
                            result += (duplited * duplited - 3 * duplited) / 2+1;
                        }
                        else result += (duplited * duplited - 3 * duplited) / 2;

                    }
                    duplited = 1;
                }

                stack.pop();
            }

            stack.push(mounts[i]);
            i++;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] mounts = new int[n];
        int max=0;
        int index = 0;
        for (int i=0;i<n;i++) {
            mounts[i] = sc.nextInt();
            if (mounts[i] > max) {
                max = mounts[i];
                index = i;
            }
        }
        int [] sortMounts=sortArr(mounts, index);
        System.out.println(solve(sortMounts));

        /*int result=n;
        for (int i=0;i<n-2;i++) {
            if (sortMounts[i] < sortMounts[i + 1]) {
                continue;
            }
            int hight=sortMounts[i+1];

            for (int j=i+2;j<n;j++) {

                if (sortMounts[j] < hight) {
                    continue;
                }

                if (sortMounts[j] >= hight&&j-i!=n-1) {
                    hight = sortMounts[j];
                    result++;
                }
            }
        }
        System.out.println(result);*/
    }
}
