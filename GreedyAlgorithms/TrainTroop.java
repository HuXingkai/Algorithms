package GreedyAlgorithms;

import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

/**
 * Created by andy on 2018/8/30.
 * 链接：https://www.nowcoder.com/questionTerminal/79190c8e6202414bad33d6e287b61f3d
 来源：牛客网

 小牛牛是牛牛王国的将军,为了训练出精锐的部队,他会对新兵进行训练。部队进入了n个新兵,每个新兵有一个战斗力值和潜力值,当两个新兵进行决斗时,总是战斗力值高的获胜。获胜的新兵的战斗力值就会变成对手的潜力值 + 自己的战斗力值 - 对手的战斗力值。败者将会被淘汰。若两者战斗力值一样,则会同归于尽,双双被淘汰(除了考察的那个新兵之外，其他新兵之间不会发生战斗) 。小牛牛想知道通过互相决斗之后新兵中战斗力值+潜力值最高的一个可能达到多少,你能帮助小牛牛将军求出来吗?
 输入描述:
 输入包括n+1行,第一行包括一个整数n(1 ≤ n ≤ 10^5);
 接下来的n行,每行两个整数x和y(1 ≤ x,y ≤ 10^9)


 输出描述:
 输出一个整数,表示新兵中战斗力值+潜力值最高的一个能达到多少。
 示例1
 输入
 2
 1 2
 2 1
 输出
 4
 */


public class TrainTroop {
    /**
     * 已知获胜战斗力值会加上对手的潜力值-对手的战斗力值。
     * 贪心思想，要培养一个战力和潜力和最大的兵王，就要尽可能多的增加其战力，即打赢所有潜力大于战力的新兵，记他们的潜力战力差的总和为add。
     * 选兵王，有两种情况：
     * <p>
     * 1、潜力qian大于战力zhan，不能与自己交战，所以要先从add中减去他的部分，最终兵王战力潜力和为add-(qian-zhan)+zhan+qian=add+2*zhan
     * 对这种情况，找出所有潜力qian大于战力zhan的兵中，zhan最大然后加上add
     * 2、否则，直接加上他的潜力战力，即add+qian+zhan,找出qian<zhan中最大的潜力战力和。
     * 故对两种情况，分别找到战力最大值maxZhan与潜力战力和的最大值maxSum，比较2*maxZhan和maxSum, 取大的加上add即为正确答案
     * <p>
     * 注意这里,当maxSum=(zhan+qian)>2*maxZhan时，因为zhan>qian,由反证可知zhan>maxZhan,自然可以打赢所有潜力大于战力的新兵。
     */

    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            long sum = 0;
//            寻找的最大比较值
            long comparedVal = 0;
            for (int i = 0; i < n; i++) {
                long x = scanner.nextInt();
                long y = scanner.nextInt();
                if (x < y) {
//                    添加增量
                    sum += y - x;
                    comparedVal = Math.max(comparedVal, x + x);
                } else {
                    comparedVal = Math.max(comparedVal, x + y);
                }
            }
            System.out.println(comparedVal + sum);
        }
    }*/

    public static void main(String[] args) {
        List<soldier> canBeat = new ArrayList<>();
        List<soldier> troop = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i=0;i<n;i++) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            soldier s = new soldier(x, y);
            troop.add(s);
            if (y > x) {
                canBeat.add(s);
            }
        }

        Collections.sort(troop);
        Collections.sort(canBeat, new Comparator<soldier>() {
            @Override
            public int compare(soldier o1, soldier o2) {
                if (o1.x > o2.x) {
                    return 1;
                } else if (o1.x < o2.x) {
                    return -1;
                }
                return 0;
            }
        });

        long fightNum=0;
        long MAX=0;
        for(int i=troop.size()-1;i>=0;i--) {
            soldier now1 = troop.get(i);
            soldier now = new soldier(now1.x, now1.y);
            long self = 0;
            if (canBeat.contains(now1)) {
                self = now.y - now.x;
            }
            if (now.x > fightNum) {
                fightNum = now.x;
                for (soldier s:canBeat) {
                    if (now.x > s.x) {
                        now.x += s.y - s.x;
                    }
                }
                now.x -= self;
                MAX = Math.max(MAX, now.x + now.y);
            }
            else break;
        }

        System.out.println(MAX);
    }
}

class soldier implements Comparable{
    public long x;
    public long y;

    public soldier(long x, long y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Object o) {
        soldier s = (soldier) o;
        if (this.x + this.y > s.x + s.y) {
            return 1;
        } else if (this.x + this.y < s.x + s.y) {
            return -1;
        }
        return 0;
    }
}
