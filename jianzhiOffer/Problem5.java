package jianzhiOffer;

import java.util.Stack;

/**
 * Created by andy on 2018/8/31.
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Problem5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while(!stack1.isEmpty()){
            int tep=stack1.pop();
            stack2.push(tep);
        }
        int pop=stack2.pop();
        while(!stack2.isEmpty()){
            int tep=stack2.pop();
            stack1.push(tep);
        }
        return pop;
    }
    //书上的方法
    public int pop1() {
        if(stack1.empty()&&stack2.empty()){
            throw new RuntimeException("Queue is empty!");
        }
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
