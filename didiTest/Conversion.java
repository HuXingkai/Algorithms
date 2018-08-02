package didiTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Conversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        boolean negative=false;
        if (m<0){
            negative = true;
            m=-m;
        }


        List<String> list = new ArrayList<>();
        int result=m;
        int remainder;
        while (!(result == 0)) {
            remainder=result%n;
            result=result/n;

            if (remainder <10) {
                list.add(remainder+"");
            }
            else {
                switch (remainder) {
                    case 10:
                        list.add("A");break;
                    case 11:
                        list.add("B");break;
                    case 12:
                        list.add("C");break;
                    case 13:
                        list.add("D");break;
                    case 14:
                        list.add("E");break;
                    case 15:
                        list.add("F");break;
                }
            }
        }
        if (negative) {
            System.out.print("-");
        }
        for (int i=list.size()-1;i>=0;i--) {
            System.out.print(list.get(i));
        }
    }
}
