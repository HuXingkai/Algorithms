package shunfeng;

import java.util.Scanner;

/**
 * Created by andy on 2018/9/17.
 */
public class GymTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        while (!str.equals("end")) {
            String[] strs = str.split(" ");
            String id = strs[0];
            Student s;
            grade r1 = null; grade r2; grade j = null; grade b;
            for (int i=1;i<strs.length;i++) {
                String tem = strs[i];
                if (tem.contains("s")) {
                    float f = Float.valueOf(tem.replace('s', '.'));
                    if (f < 12) {
                        r1.grages="GREAT";
                        r1.num = 4;
                    }
                    if (f > 12&&f<12.4) {
                        r1.grages="GOOD";
                        r1.num = 3;
                    }
                    if (f < 12.9&&f>12.5) {
                        r1.grages="PASS";
                        r1.num = 2;
                    }
                    if (f > 13) {
                        r1.grages="FAIL";
                        r1.num = 1;
                    }
                }
                if (tem.contains("cm")) {
                    int f = Integer.parseInt(tem.substring(0,tem.indexOf('c')));
                    if (f > 266) {
                        j.grages="GREAT";
                        j.num = 4;
                    }
                    if (f > 256&&f<266) {
                        j.grages="GOOD";
                        j.num = 3;
                    }
                    if (f < 255&&f>246) {
                        j.grages="PASS";
                        j.num = 2;
                    }
                    if (f < 245) {
                        j.grages="FAIL";
                        j.num = 1;
                    }
                }
            }
        }
    }
}
class Student implements Comparable{
    String id;
    grade run100;
    grade run800;
    grade jump;
    grade ball;

    public Student(String i, grade r1, grade r2, grade j, grade b) {
        id = i;
        run100=r1;
        run800=r2;
        jump=j;
        ball = b;
    }

    @Override
    public int compareTo(Object o) {
        Student s = (Student) o;
        if (run100.num > s.run100.num) {
            return 1;
        } else if (run100.num == s.run100.num) {
            if (run800.num > s.run800.num) {
                return 1;
            } else if (run800.num == s.run800.num) {
                if (jump.num > s.jump.num) {
                    return 1;
                } else if (jump.num == s.jump.num) {
                    if (ball.num > s.ball.num) {
                        return 1;
                    } else if (ball.num == s.ball.num) {
                        return id.compareTo(s.id);
                    }
                }
            }
        }
        return -1;
    }
}
enum grade{
    GREAT("GREAT",4),GOOD("GOOD",3),PASS("PASS",2), FAIL("FAIL",1);

    String grages;
    int num;
    grade(String grage, int i) {
        grages = grage;
        num = i;
    }
}