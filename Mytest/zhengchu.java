package Mytest;

/**
 * Created by andy on 2018/9/7.
 */
public class zhengchu {
    public static void main(String[] args) {
        int n=0;
        for (int i=1;i<=1000;i++) {
            if (i % 2 != 0 && i % 3 != 0 && i % 5 != 0) {
                n++;
            }
        }
        System.out.println(n);
    }
}
