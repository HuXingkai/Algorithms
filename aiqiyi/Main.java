package aiqiyi;

import java.util.*;

/**
 * Created by andy on 2017/10/14.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int k = scanner.nextInt();
        Map<String, Integer> map = new HashMap<>();
        for (int i=0;i<str.length();i++) {
            String s=str.substring(i, i+1);
            if (map.containsKey(s)) {
                int n=map.get(s);
                n++;
                map.put(s, n);
            }
            else {
                map.put(s, 1);
            }
        }

        List<Integer> flist = new ArrayList<>();

        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next().toString();
            flist.add(map.get(key));

        }
        for (int i=0;i<k;i++) {
            Collections.sort(flist);
            int num=flist.get(flist.size()-1);
            num--;
            flist.set(flist.size() - 1, num);
        }
        int result=0;
        for (int i=0;i<flist.size();i++) {
            result = result + flist.get(i) * flist.get(i);
        }
        System.out.println(result);
    }
}
