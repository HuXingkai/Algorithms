package WangyiText;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by andy on 2017/8/22.
 * 小易有一个圆心在坐标原点的圆，小易知道圆的半径的平方。小易认为在圆上的点而且横纵坐标都是整数的点是优雅的，小易现在想寻找一个算法计算出优雅的点的个数，请你来帮帮他。
 例如：半径的平方如果为25
 优雅的点就有：(+/-3, +/-4), (+/-4, +/-3), (0, +/-5) (+/-5, 0)，一共12个点。
 */
public class Elegantpoint {
    /*
   * 判断是否为整数
  * @param double 传入的double
  * @return 是整数返回true,否则返回false
*/
    public static boolean isInteger(double doubnum) {
        if ((doubnum - Math.round(doubnum)) == 0) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        double radius2=0;
        Scanner s = new Scanner(System.in);

        radius2= Double.parseDouble(s.nextLine());

        int num=0;
        double radius = Math.sqrt(radius2);
        if (isInteger(radius)) {
            num+=4;
        }
        for (int i=1;i<=Math.round(radius);i++) {
            double y = Math.sqrt(radius2 - i * i);
            if (isInteger(y)&&(y!=0)) {
                num+=4;
            }
        }
        System.out.println(num);
    }
}
