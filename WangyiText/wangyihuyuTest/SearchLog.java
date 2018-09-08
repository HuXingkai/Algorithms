package WangyiText.wangyihuyuTest;

import java.util.Scanner;

/**
 * Created by andy on 2018/9/8.
 * 8
 2018.09.01-13:00:00 101 helloworld
 2018.09.01-13:03:10 102 thisislogtool
 2018.09.01-13:05:04 102 icanprintmanythings
 2018.09.01-13:08:15 101 youshouldtryit
 2018.09.01-13:11:09 104 ihavefoundaveryfunnygame
 2018.09.01-14:14:02 103 itsvery666verygoodgame
 2018.09.01-14:34:36 101 comeandjoinme
 2018.09.01-14:52:38 101 wobianbuxiaqule
 2
 2
 --search game
 --hostid 104
 1
 --search huxn
 --after 3

 给出一个日志信息，包含时间 日志的id 日志信息
 命令以及参数，命令分别为--search 关键字；--hostid id；--before 整数；--after 整数
 --search 选项必有，查询第一个含有关键字的日志信息，并输出日志内容
 --hostid id 表示只关注id为id 测日志信息
 --before n ：表示除了查询到的信息，还输出前面n个日志信息。如果不足n个，全部输出
 --after n ：表示除了查询到的信息，还输出后面个n日志信息。如果不足n个，全部输出
 */
public class SearchLog {
    public static void search(String keyword, int id, int before, int after, int[] hostid, String[] logs) {
        int target = -1;
        for (int i=0;i<logs.length;i++) {
            if (logs[i].indexOf(keyword) >= 0 && (hostid[i] == id || id == -1)) {
                target = i;
                break;
            }
        }

        if (target < 0) {
            System.out.println("ERROR");
            return;
        }

        for (int i=target-before;i<=target+after;i++) {
            if (i < 0) {
                i=-1;
                continue;
            }
            if (i >= logs.length) {
                break;
            }
            System.out.println(logs[i]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] hostid = new int[N];
        String[] logs = new String[N];
        String[] times = new String[N];
        for (int i=0;i<N;i++) {
            times[i] = sc.next();
            hostid[i] = Integer.parseInt(sc.next());
            logs[i] = sc.next();
        }
        int T = sc.nextInt();
        for (int i=0;i<T;i++) {
            int K = sc.nextInt();
            String keywords = "";
            int id = -1;
            int before = 0;
            int after = 0;
            for (int j=0;j<K;j++) {
                String command = sc.next();
                String arg = sc.next();
                if (command.equals("--search")) {
                    keywords = arg;
                }
                if (command.equals("--hostid")) {
                    id = Integer.parseInt(arg);
                }
                if (command.equals("--before")) {
                    before = Integer.parseInt(arg);
                }
                if (command.equals("--after")) {
                    after = Integer.parseInt(arg);
                }
            }
            search(keywords,id,before,after,hostid,logs);
        }
    }
}
