package shunfeng;

/**
 * Created by andy on 2018/9/18.
 * learn the Enum
 */
public class TryEnum {
    public static void change(StringBuffer b1, StringBuffer b2) {
        b1 = b2;
        b2.append("---");
    }
    public static void main(String[] args) {
        days d1 = days.valueOf(days.class, "SUN");
        days d2 = days.FRI;
        days d3 = days.SUN;
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d2.compareTo(d1));
        System.out.println(d1.compareTo(d3));

        StringBuffer b1 = new StringBuffer("a");
        StringBuffer b2 = new StringBuffer("b");
        change(b1, b2);
        System.out.println(b1+" "+b2);
    }
}
enum days{
    MON,TUE,WED,THR,FRI,SAT,SUN
}
