package qihu360;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by andy on 2018/9/17.
 */
public class pailie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        List<Long> list = new ArrayList<>();
        for (int i=0;i<n;i++) {
            list.add(scanner.nextLong());
        }

        List<Long> length = new ArrayList<>();
        for (int i=0;i<n;i++) {
            for (int j=i+1;j<n;j++) {
                length.add(Math.abs(list.get(i) - list.get(j)));
            }
        }

        long times=1;
        for (int i=1;i<=n-2;i++) {
            times = times * i%(1000000007);
        }
        times=2*(n-1)*times%(1000000007);
        long ans=0;
        for (long l : length) {
            ans=ans%(1000000007)+l*(times)%(1000000007);
        }
        System.out.println(ans);
    }
}
