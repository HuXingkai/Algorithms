package alibabaTextOnline;

/**
 * Created by andy on 2017/7/8.
 */
import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> _ids = new ArrayList<Integer>();
        ArrayList<Integer> _parents = new ArrayList<Integer>();
        ArrayList<Integer> _costs = new ArrayList<Integer>();

        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        while (line != null && !line.isEmpty()) {
            if (line.trim().equals("0")) break;
            String[] values = line.trim().split(" ");
            if (values.length != 3) {
                break;
            }
            _ids.add(Integer.parseInt(values[0]));
            _parents.add(Integer.parseInt(values[1]));
            _costs.add(Integer.parseInt(values[2]));
            line = in.nextLine();
        }
        int res = resolve(_ids, _parents, _costs);

        System.out.println(String.valueOf(res));
    }

    // write your code here

    public static int resolve(ArrayList<Integer> ids, ArrayList<Integer> parents, ArrayList<Integer> costs) {
        int max=0;
        ArrayList<Integer> nodeIdList = ids;
        //所有的id中，去掉为父类的剩下的就是所有的叶子结点
        for (Integer p:parents) {
            if (nodeIdList.contains(p)) {
                nodeIdList.remove(p);
            }
        }
        int[] array = new int[nodeIdList.size()];

        int i=0;
        for (int n:nodeIdList) {
            do {
                array[i] += costs.get(n-1);
                n=parents.get(n-1);
            }
            while (n != 0);
            i++;
        }

        for (int num:array) {
            if (num > max) {
                max=num;
            }
        }
        return max;

    }
}