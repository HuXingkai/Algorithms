package jianzhiOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by andy on 2018/8/30.
 * 输入一个链表，从尾到头打印链表每个节点的值。
 * 利用栈的数据结构实现先入后出，既可以从尾到头打印
 */
public class ReverseNode {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<ListNode> stack = new Stack<>();

        while(listNode!=null){
            stack.push(listNode);
            listNode=listNode.next;
        }

        ArrayList<Integer> anlist=new ArrayList<>();
        while(!stack.isEmpty()){
            anlist.add(stack.pop().val);
        }
        return anlist;
    }

    public static void main(String[] args) {
        ReverseNode re = new ReverseNode();
        //ListNode li = new ListNode(1);
        System.out.println(re.printListFromTailToHead(null));
    }
}
class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}
