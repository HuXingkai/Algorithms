package huaweiTest;

import java.util.Scanner;

/**
 * Created by andy on 2018/9/16.
 */
public class partyTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] peoples = new int[8];
        while (scanner.hasNext()) {
            String str = scanner.next();
            String[] times = str.split(",");
            int comeT = Integer.parseInt(times[0]);
            int goT = Integer.parseInt(times[1]);

            if (comeT==goT-1) continue;
            if (comeT<0) break;

            for (int i=comeT-12;i<goT-12;i++) {
                peoples[i]++;
            }
        }
        for (int i=0;i<8;i++) {
            System.out.println("[" + (12 + i) + "," + (13 + i) + ")" + ":" + peoples[i]);
        }
    }
}
