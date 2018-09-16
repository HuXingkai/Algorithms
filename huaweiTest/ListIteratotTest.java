package huaweiTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Created by andy on 2018/9/16.
 */
public class ListIteratotTest {
    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0;i<8;i++) {
            list.add(i);
        }
        ArrayList<String> al = new ArrayList<>();
        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");

        System.out.print("Original contents of String al: ");
        Iterator<String> it = al.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();

        System.out.println("数字列表：");
        Iterator<Integer> intiter = list.iterator();
        while (intiter.hasNext()) {
            System.out.print(intiter.next() + " ");
        }System.out.println();

        System.out.println("ListIterator顺序遍历：");
        //迭代器默认的初始位置使所有元素的头。如果要逆序遍历，需要指定初始位置位尾部
        //如果已经进了一次顺序遍历，迭代器已经跑到元素末尾了，这时候可以逆序迭代。如果再来一遍顺序迭代，
        //由于迭代器已经在末尾，所以不会有任何元数输出。
        ListIterator<Integer> iterator = list.listIterator(list.size());

        /*while (iterator.hasNext()) {
            System.out.print(iterator.next()+ " ");
        }System.out.println();*/

        System.out.println("ListIterator逆序遍历：");
        while (iterator.hasPrevious()) {
            System.out.print(iterator.previous()+ " ");
        }System.out.println();

        ListIterator<String> lt = al.listIterator();
        while(lt.hasNext()){
            lt.set(lt.next() + "+");
        }
        System.out.print("Modified contents of al: ");
        lt = al.listIterator();
        while(lt.hasNext()){
            System.out.print(lt.nextIndex() + ":");
            System.out.print(lt.next() + " ");
        }
        System.out.println();

        System.out.print("Modified list backwards: ");
        while(lt.hasPrevious()){
            System.out.print(lt.previousIndex() + ":");
            System.out.print(lt.previous() + " ");
        }
    }
}
