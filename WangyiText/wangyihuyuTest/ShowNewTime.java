package WangyiText.wangyihuyuTest;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/test/question/done?tid=18365338&qid=117506
 * Created by andy on 2018/9/8.
 * 首先第一位，只能是0~2，如果出错，那么就改成0，因为要字典序最小
   然后第二位，这里我栽了跟头，也是我这道题没过的原因，就是如果第一位上不是2的话，那么第二位0~9都合法，然而是第一位2的话，
  第二位就只能是0~3，关键来了，如果第二位不合法，要把第二位变成0吗？因为第一位是这样做的，所以会想当然的这样想，然而这样是错的，
  第二位不合法可以通过修改第一位使第二位合法，将第一位修改为0的话字典序更小
   后面的两位，如果大于5则改成0
 */
public class ShowNewTime {
    public static String showRorrect(String time) {
        String[] splits = time.split(":");
        int hour=Integer.parseInt(splits[0]);
        int minute=Integer.parseInt(splits[1]);
        int second=Integer.parseInt(splits[2]);
        if (hour > 23) {
            splits[0] = "0" + splits[0].charAt(1);
            /*if (hour / 10 >= 2) {
                splits[0] = "0" + splits[0].charAt(1);
            } else {
                splits[0] = splits[0].charAt(0)+"0";
            }*/
        }
        if (minute > 59) {
            splits[1] = "0" + splits[1].charAt(1);
        }
        if (second > 59) {
            splits[2] = "0" + splits[2].charAt(1);
        }
        String correctTime="";
        for (int i=0;i<3;i++) {
            if (i != 2) {
                correctTime += splits[i] + ":";
            }else correctTime += splits[i];
        }
        return correctTime;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0;i<n;i++) {
            String time = sc.next();
            System.out.println(showRorrect(time));
        }
    }
}
