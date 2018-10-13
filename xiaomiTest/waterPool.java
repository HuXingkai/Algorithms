package xiaomiTest;

import java.util.Scanner;

/**
 * Created by andy on 2018/9/20.
 */
public class waterPool {
    /*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/
    static int findMaxCapacity(int[] array, int m) {
// Start typing your Java solution below
        // DO NOT write main() function
        int area = 0;
        java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
        for (int i = 0; i < array.length; i++) {
            if (stack.empty() || array[stack.peek()] < array[i]) {
                stack.push(i);
            } else {
                int start = stack.pop();
                int width = stack.empty() ? i : i - stack.peek() - 1;
                area = Math.max(area, array[start] * width);
                i--;
            }
        }
        while (!stack.empty()) {
            int start = stack.pop();
            int width = stack.empty() ? array.length : array.length
                    - stack.peek() - 1;
            area = Math.max(area, array[start] * width);
        }
        return area;

    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _array_size = 0;
        _array_size = Integer.parseInt(in.nextLine().trim());
        int[] _array = new int[_array_size];
        int _array_item;
        for(int _array_i = 0; _array_i < _array_size; _array_i++) {
            _array_item = Integer.parseInt(in.nextLine().trim());
            _array[_array_i] = _array_item;
        }

        int _m;
        _m = Integer.parseInt(in.nextLine().trim());

        res = findMaxCapacity(_array, _m);
        System.out.println(String.valueOf(res));

    }
}
