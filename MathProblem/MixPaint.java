package MathProblem;

import java.util.Arrays;
import java.util.Scanner;

/**https://my.oschina.net/liyurong/blog/1828999
 * https://www.cnblogs.com/tonyluis/p/5774700.html
 * Created by andy on 2018/8/29.
 * 后来发现一条规律，就是0001,0010,0100,1000，可以通过^生成任意4位的数字，那么本题的答案不会超过32（int的长度）

 再后来想到高斯消元和最小线性无关组就有了自己的思路。首先将数组排序，获取最高位的1，每次将最高位的1进行^运算，
 使得数组里面从后往前数最高位每个1只保留一个，最终得到类似于{00000000, 00 000 001,00 000 011，00011000,00100010}这样的结构，那
 么答案就出来了。


 */
public class MixPaint {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            final int SUM = in.nextInt();
            int[] colors = new int[SUM];
            for (int i = 0; i < SUM; i++)
                colors[i] = in.nextInt();
            Arrays.sort(colors);
            System.out.println(minColor(colors));
            System.out.println("方法2："+hunheyanse(colors));
        }
    }

    static int minColor(int[] colors) {
        int max = 1 << 30;
        int right = colors.length - 1;
        while (right >= 0 && colors[right] != 0) {
            while (max > colors[right])
                max >>= 1;
            while (right > 0 && colors[right - 1] >= max) {
                colors[right - 1] ^= colors[right];
                insertSort(colors, right - 1);
            }
            right--;
        }
        return right >= 0 ? colors.length - right - 1 : colors.length;
    }

    // 将一个数插入到有序数组中 ArrayList底层使用数组实现，不如直接使用数组
    // 使用LinkedList可以减少直接插入排序的移位操作
    static void insertSort(int[] nums, int index) {
        int temp = nums[index];
        if (temp <= nums[0]) {
            for (int i = index; i > 0; i--)
                nums[i] = nums[i - 1];
            nums[0] = temp;
            return;
        }
        for (int i = index - 1; i >= 0; i--) {
            if (temp > nums[i]) {
                for (int j = index; j > i + 1; j--)
                    nums[j] = nums[j - 1];
                nums[i + 1] = temp;
                return;
            }
        }
    }

    //求矩阵的秩的方法

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/5b1116081ee549f882970eca84b4785a
     * 来源：牛客网
     * <p>
     * 说明：以下代码和思路均是参考各位大神，
     * 本人只做了额外的总结和解释，帮助大家理解。
     * <p>
     * 问题理解：
     * 输入n个数，将这些数之间进行多次xor（异或操作），异或有个性质 a^b=c 那么 a^c=b.
     * 其中一个数可能被xor多次，看最后能剩余多少不重复的数，输出数量即可。
     *
     那对于这题，如果一个数字 x 的某一位为1（2进制），那我用这个数字和其他相同位为1的数字 i 分别进行异或运算作为 i 的值，
     那么这组数里只剩 x 的这一位为 1，那么说明至少需要一个这个位上为1的数来异或出 x ，
     再用相同的方法计算出除 x 外的数需要的颜料数就可以得到最后的结果。为了不计算重复的位值，将数组进行排序，
     每次计算最高位（最大的数），下一个循环不计算这个数就OK。而楼主的 if 语句是判断两个数的最高位是否都为1。
     * <p>
     * 思路：
     * 类似矩阵求秩：首先将各数从大到小排序,
     * 对位数与该行相同的进行异或操作，操作结束后该行就“独立”了。
     * <p>
     * 具体过程如下：
     * 排序 i=0      异或      排序 i=1    异或
     * 101010 --> 111010 --> 111010 --> 111010 -->
     * 111010 --> 110110 --> 001100 --> 010111 -->
     * 101101 --> 101101 --> 010111 --> 010000 -->
     * 110110 --> 101010 --> 010000 --> 001100 -->
     * <p>
     * 排序 i=2   排序 i=3    排序 i=4 end
     * 111010 --> 111010 --> 111010 --> 111010
     * 010111 --> 010111 --> 010111 --> 010111
     * 000111 --> 001100 --> 001100 --> 001100
     * 001100 --> 000111 --> 000111 --> 000111
     */
    public static int hunheyanse(int[] col) {
        Arrays.sort(col);
        int count = 0;
        for (int i=col.length-1;i>=0;i--) {
            for (int j=i-1;j>=0;j--) {
                //这里用了一个if语句，优化了最高位的判断过程即下面的 highbit函数的调用
                //先做一把异或，如果两个数的最高位都是1，异或结果最高位是0，一定小于前两个数。
                //如果最高位为 1，0 异或结果的最高位是1，大于原来最高位是0的数
                /**
                 *
                 if(highbit(col[i]) == highbit(col[j])){
                 col[j] = col[j] ^ col[i];
                 }
                 */
                int temp = col[i] ^ col[j];
                if (temp < col[j]) {
                    col[j] = temp;
                }
            }
            Arrays.sort(col);
        }

        for (int i=0;i<col.length;i++) {
            if (col[i] != 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * 获取一个数的二进制串中最高位为1的位置
     * @param x
     * @return
     */
    public static int highbit(int x){
        for(int i=31;i>=0;i--)
        {
            int m = (x>>i)&1;
            if(m != 0)
                return i+1;
        }
        return 0;
    }
}
