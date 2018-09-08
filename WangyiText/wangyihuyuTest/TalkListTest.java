package WangyiText.wangyihuyuTest;

import java.util.*;

/**
 * https://www.nowcoder.com/test/question/done?tid=18365338&qid=117506
 * Created by andy on 2018/9/8.
 */
public class TalkListTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i=0;i<T;i++) {
            int n = scanner.nextInt();
            LinkedHashMap<Integer,Integer> talkList = new LinkedHashMap<Integer,Integer>(200,0.75f,true);
            for (int j=0;j<n;j++) {
                talkList.put(scanner.nextInt(),0);
            }
            Iterator iterator = talkList.entrySet().iterator();
            Stack<Integer> stack = new Stack<>();
            while (iterator.hasNext()) {
                Map.Entry etntry = (Map.Entry)iterator.next();
                stack.push((Integer)etntry.getKey());
            }
            while (!stack.isEmpty()) {
                if (stack.size() != 1) {
                    System.out.print(stack.pop()+" ");
                }
                else System.out.println(stack.pop());
            }
        }
    }
}
