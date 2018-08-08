package reviewAlgorithms.CountPageNums;

import java.util.Scanner;

/**
 * Created by andy on 2018/8/6.
 * 牛牛新买了一本算法书，算法书一共有n页，页码从1到n。牛牛于是想了一个算法题目：在这本算法书页码中0~9每个数字分别出现了多少次？
 * 输入包括一个整数n(1 ≤ n ≤ 1,000,000,000)
 *输出包括一行10个整数，即0~9这些数字在页码中出现的次数，以空格分隔。行末无空格
 *
 *输入：999
 *输出：189 300 300 300 300 300 300 300 300 300
 *
 * 解题的思路：https://www.cnblogs.com/xiaoxi666/archive/2017/03/08/6518290.html
 */
public class countPageNumPrior {
    public long sumls(long n, int tarNum) {
        //代表从1到n中，数tarNum(0~9)出现的次数
        long iCount = 0;
        //用于取整数各个位置的数的设定值
        long ifactor = 1;
        //低位的数值
        long iLowerNum = 0;
        //当前位的数值
        long iCurrent = 0;
        //更高位的数值
        long iHigerNum = 0;
        //ifactor 的值将以10的倍数递增，以便每次取更高的位的数值
        while (n / ifactor != 0) {
            iCurrent = n % (10 * ifactor)/ifactor;
            iLowerNum = n % ifactor;
            iHigerNum = n / (10 * ifactor);

            if (iCurrent < tarNum) {
                iCount+=iHigerNum*ifactor;
            } else if (iCurrent == tarNum) {
                iCount += iHigerNum * ifactor + iLowerNum + 1;
            } else {
                iCount+=(iHigerNum+1)*ifactor;
            }
            //处理0的个数
            //若n为1位数，比如本来是1 2 3 4 5 6 ，之前处理成 0 1 2 3 4 5 6,多加了1个0
            //若n为2位数，比如本来是1 2 3 4 5 6 7 8 9 10 11 12，之前处理成 00 01 02 ...09 10 11 12,多加了1+10个0
            //若n为3位数，比如本来是1 2 3 4 ... 115，之前处理成000 001 002 ...009 010 011...099 100...115，多加了1+10+100个0
            //因此需要在每层循环中减去多计算的0的个数,正好等于ifactor的个数
            if (tarNum == 0) {
                iCount-=ifactor;
            }
            ifactor = ifactor * 10;
        }
        return iCount;
    }

    public void printNumTimes(long n) {
        for (int i=0;i<=9;i++) {
            System.out.print(sumls(n, i));
            if (i != 9) {
                System.out.print(" ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        scanner.close();
        countPageNumPrior prior = new countPageNumPrior();
        prior.printNumTimes(num);
    }
}
