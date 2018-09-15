package aiqiyi;

/**
 * Created by andy on 2018/9/15.
 * 如果某个case语句匹配，并且如果后面没有break关键字，会继续执行后面的case语句代码和default，直到遇见break或者右花括号。
 * 因此下面的代码将输出 value=8
 */
public class SwitchTest{//1
    public static void main(String[] args) {//2
        System.out.println("value="+switchit(4));//3
    }//4
    public static int switchit(int x) {
        int j=1;
        switch (x) {
            case 1:j++;
            case 2:j++;
            case 3:j++;
            case 4:j++;
            case 5:j++;
            default:j++;
        }
        return j+x;
    }
}
