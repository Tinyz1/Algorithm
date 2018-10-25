package com.algorithm.easy;

import java.util.LinkedList;

/**
 * Created by TangZz on 2018/10/24.
 * <p>
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
public class MinStack_155 {

    /**
     * 最优代码分析
     * 使用了LinkList的push和pop，
     * 最小值的LinkList只有在入栈的值小于等于当前栈顶元素事入栈；同样，只有在出栈元素和当前元素相同时才出栈
     * 最小值的栈数据比较少，比每次入栈少空间
     */
    class MinStack {

        private LinkedList<Integer> stack;
        private LinkedList<Integer> minStack;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
        }

        public void push(int x) {
            stack.push(x);
            if(minStack.isEmpty() || x <= minStack.peek().intValue())
            {
                minStack.push(x);
            }
        }

        public void pop() {
            if(stack.isEmpty() || minStack.isEmpty())return;
            if(stack.peek().intValue() == minStack.peek().intValue())minStack.pop();
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }









    private static LinkedList<Integer> value = null;
    private static LinkedList<Integer> minValue = null;
    private static int min = 0;
    private static int length = 0;

    public MinStack_155() {
        value = new LinkedList<>();
        minValue = new LinkedList<>();
        min = 0;
        length = 0;
    }

    public void push(int x) {
        if (length == 0 ) {
            min = x;
        }else{
            min = minValue.get(length - 1);
            if( x < min ){
                min = x;
            }
        }
        value.add(x);
        minValue.add(min);
        length++;
    }

    public void pop() {
        value.remove(length - 1);
        minValue.remove(length - 1);
        length--;

    }

    public int top() {
        return value.get(length - 1);
    }

    public int getMin() {
        return minValue.get(length - 1);
    }

    public static void main(String[] args) {
        MinStack_155 minStack = new MinStack_155();
        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
        System.out.println(minStack.getMin());
//        minStack.pop();
//        System.out.println(minStack.top());
//        System.out.println(minStack.getMin());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


