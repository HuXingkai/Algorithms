package huaweiTest;

import java.util.*;

/**
 * Created by andy on 2018/9/16.
 */
public class LastOnceChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(find(str));
    }

    public static String find(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i=0;i<str.length();i++) {
            if (!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), 1);
            } else {
                int n=map.get(str.charAt(i))+1;
                map.put(str.charAt(i), n);
            }
        }
        //而ListIterator只能用于List及其子类型，如List、ArrayList、LinkedList和Vector等
        //ListIterator中含有previous方法，可以倒序遍历
        //因此需要首先将map存放到list里面,
        // 注意逆序的时候，必须需要指定ListIterator从最后一个元素开始
        ListIterator<Map.Entry<Character,Integer>> i=new ArrayList<>(map.entrySet()).listIterator(map.size());
        while(i.hasPrevious()) {
            Map.Entry<Character,Integer> entry=i.previous();
            if (entry.getValue() == 1) {
                return entry.getKey()+"";
            }
        }
        return "NULL";
    }
}
