package basic;

import java.util.Stack;

public class Code_02_GetMinStack {
    private Stack<Integer> StackData;
    private Stack<Integer> StackMin;

    public Code_02_GetMinStack() {
        StackData = new Stack<>();
        StackMin = new Stack<>();
    }

    public void push(Integer obj) {
        StackData.push(obj);
        if (StackMin.empty()) {
            StackMin.push(obj);
        } else if (obj < this.getmin()) {
            StackMin.push(obj);
        } else {
            StackMin.push(StackMin.peek());
        }
    }

    public Integer pop() {
        if (StackData.empty()) {
            throw new RuntimeException("Stack is empty");
        }
        StackMin.pop();
        return StackData.pop();
    }

    public Integer getmin() {
        if (StackData.empty()) {
            throw new RuntimeException("Stack is empty");
        }
        return StackMin.peek();
    }

    public static void main(String[] args) {
        Code_02_GetMinStack stack = new Code_02_GetMinStack();
        stack.push(3);
        System.out.println(stack.getmin());
        stack.push(4);
        System.out.println(stack.getmin());
        stack.push(1);
        System.out.println(stack.getmin());
        stack.push(5);
        System.out.println(stack.getmin());
        stack.push(-1);
        System.out.println(stack.getmin());
        stack.push(-12);
        System.out.println(stack.getmin());
        System.out.println(stack.pop());
        System.out.println(stack.getmin());
        stack.push(88);
        System.out.println(stack.getmin());
        stack.push(22);
        System.out.println(stack.getmin());
        System.out.println(stack.pop());
        System.out.println(stack.getmin());
        System.out.println(stack.pop());
        System.out.println(stack.getmin());
        System.out.println(stack.pop());
        System.out.println(stack.getmin());

        System.out.println("=============");

    }
}
