package Mytest;

/**
 * Created by andy on 2017/9/15.
 */
public class test1 {
    public static void main(String[] args) {
        double d=3.1415926;
        System.out.printf("%.2f",d);

        StringBuffer sb3=new StringBuffer("a");
        System.out.println("length="+sb3.length());//length=1
        System.out.println("capacity="+sb3.capacity());//capacity=17;
        System.out.println("--------------------");
        sb3.append("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println("length="+sb3.length());//length=48;
        System.out.println("capacity="+sb3.capacity());//capacity=48;
    }
}
