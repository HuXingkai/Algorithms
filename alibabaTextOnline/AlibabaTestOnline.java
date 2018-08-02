package alibabaTextOnline;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/10.
 * 思路是，先找到所有的叶子结点，然后从树的最低端的叶子结点寻找他的parent直到根节点，并记录
 * 对应任务的总开销并保存到数组中。最后，找到数组总最大的元素，即为最大的总开销。
 * 需要的注意的点：要实现根据id寻找他的parent和cost方法。这里偷懒了，直接默认ids是按照顺序排列的
 * 即给一个id，其parent为parents.get(n-1); cost为costs.get(n-1).减一是因为list从0开始。
 * 如果不想偷懒，新建一个类，含有id,parent,cost属性，并且实现getParentById();getCostById()方法。
 */
public class AlibabaTestOnline {
    public int max=0;
    public int MaxCosts(ArrayList<Integer> ids, ArrayList<Integer> parents, ArrayList<Integer> costs) {
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

    public static void main(String[] args) {
        ArrayList<Integer> ids = new ArrayList<>();
        ArrayList<Integer> parents = new ArrayList<>();
        ArrayList<Integer> costs = new ArrayList<>();
        for (int i=0;i<5;i++) {
            ids.add(i+1);
        }
        parents.add(0);
        parents.add(0);
        parents.add(1);
        parents.add(1);
        parents.add(3);

        costs.add(2);
        costs.add(3);
        costs.add(2);
        costs.add(3);
        costs.add(3);

        AlibabaTestOnline ali=new AlibabaTestOnline();
        int answer=ali.MaxCosts(ids, parents, costs);
        System.out.println(answer);
    }
}
