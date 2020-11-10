package explore.JZOffer;

import java.util.LinkedList;
import java.util.Stack;

public class 包含min函数的栈 {

}
class MinStack {
    Stack<Integer> stackA;
    Stack<Integer> stackB;
    public MinStack() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }

    public void push(int x) {
        stackA.push(x);
        if (stackB.isEmpty() || x<=stackB.peek()){
            stackB.push(x);
        }
    }

    public void pop() {
        if (stackA.pop().equals(stackB.peek())){
            stackB.pop();
        }
    }

    public int top() {
        return stackA.peek();
    }

    public int min() {
        return stackB.peek();
    }
}
