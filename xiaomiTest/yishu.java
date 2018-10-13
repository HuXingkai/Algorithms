package xiaomiTest;

import java.util.*;

/**
 * Created by andy on 2018/9/20.
 */
public class yishu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        List<Integer> numlist = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            if (str.equals("END")) {
                break;
            }
            String[] strs = str.split("#");
            int n = Integer.parseInt(strs[1], Integer.parseInt(strs[0]));
            list.add(str);
            numlist.add(n);
        }

        Set<Integer> set = new LinkedHashSet<>();
        for (int i=0;i<numlist.size();i++) {
            set.add(numlist.get(i));
        }
        List<Integer> numlist1 = new ArrayList<>(numlist);
        List<Integer> ans = new ArrayList<>();
        for (Integer i : set) {
            numlist1.remove(i);
            if (!numlist1.contains(i)) {
                ans.add(i);
            }
        }
        if (ans.size() == 0) {
            System.out.println("None");
        }

        for (Integer i : ans) {
            int index = numlist.indexOf(i);
            System.out.println(list.get(index));
        }
    }
}
