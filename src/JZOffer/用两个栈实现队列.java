package explore.JZOffer;

import java.util.Stack;

public class 用两个栈实现队列 {
}

class CQueue {
    Stack s1,s2;
    public CQueue() {
        s1 = new Stack();
        s2 = new Stack();
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        if (s2.isEmpty()){
            return -1;
        }
        return (int) s2.pop();
    }
}
