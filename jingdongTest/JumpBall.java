package jingdongTest;

/**
 * Created by andy on 2018/9/9.
 */
public class JumpBall {
    public int Distance(int n) {
        int sum=n;
        while (n != 0) {
            n /= 2;
            sum += 2*n;
        }
        return sum;
    }
    public int calcDistance(int A, int B, int C, int D) {
        // write code here
        return Distance(A) + Distance(B) + Distance(C) + Distance(D);
    }

    public static void main(String[] args) {
        System.out.println(new JumpBall().calcDistance(100,90,80,70));
    }
}
