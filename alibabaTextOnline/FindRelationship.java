package alibabaTextOnline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by andy on 2017/7/5.
 * 题目：给定一个关系对应图谱 让你然后给你两个人（比如A,B）和一个数字，然后你判断谁否在这个数字内两个人有关系
 * 比如A和B有关，B和J有关，那么A和J在2步内存在关系。
 * 做法是先将对应的输入人的所有关系网找出来（最多两条），然后记录两个人的关系步数，和给定的部署对比。
 */
public class FindRelationship {
    public List<String> list1=new ArrayList<>();
    public List<String> list2=new ArrayList<>();
    public List<String> list3=new ArrayList<>();
    public List<String> list4=new ArrayList<>();
    public List[] array = new List[2];
    int n=0;

    //实现的根据value获取Key的方法
    public static List<String> getKey(HashMap<String,String> map, String value){
        List<String> key = new ArrayList<>();

        //Map,HashMap并没有实现Iteratable接口.不能用于增强for循环.
        for(String getKey: map.keySet()){
            if(map.get(getKey).equals(value)){
                key.add(getKey);
         }
        }
        return key;
    }

    //此方法实现找出给定人所有的关系网
    public void findRelation(String x, HashMap<String, String> map) {
        int m=0;
        List<String> next = new ArrayList<>();
        if (map.containsKey(x)&&(!list1.contains(map.get(x)))) {
            list1.add(map.get(x));
            next.add(map.get(x));
            m=1;
        }
        if (map.containsValue(x)) {
            List<String> values = getKey(map, x);
            if (m == 0) {
                while (values.size() > 0) {
                    if (!list1.contains(values.get(0))) {
                        list1.add(values.get(0));
                        next.add(values.get(0));
                        m=1;
                        values.remove(0);
                        break;
                    }
                    else values.remove(0);
                }
            }
            if (m == 1&&values.size()!=0&&(!list2.contains(values.get(0)))) {
                list2.add(values.get(0));
                next.add(values.get(0));
            }
        }
        if (next.size() != 0) {
            for (String l : next
                    ) {
                findRelation(l,map);
            }
         }
         else {
            for (String l:list1) {
                array[n].add(l);
            }
            list1.clear();
            for (String l:list2) {
                list1.add(l);
            }
            n=n+1;
        }


    }
    public boolean hasRelation(String x, String y, int d,HashMap<String,String> map) {
        list1.add(x);
        list2.add(x);
        array[0] = list3;
        array[1] = list4;
        findRelation(x, map);
        for (int i=0;i<list3.size();i++) {
            if (list3.get(i).equals(y) && i <= d) {
                return true;
            }
        }
        for (int i=0;i<list4.size();i++) {
            if (list4.get(i).equals(y) && i <= d) {
                return true;
            }
        }
        return false;
        }

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("A", "B");
        map.put("B", "J");
        map.put("C", "D");
        map.put("E", "F");
        map.put("G", "H");
        map.put("H", "I");
        map.put("I", "J");
        FindRelationship findRelationship = new FindRelationship();
        boolean result=findRelationship.hasRelation("J", "I", 3, map);
        System.out.println(findRelationship.list3);
        System.out.println(findRelationship.list4);
        System.out.println(result);
    }

}
