package JZOffer;

import java.util.Stack;

public class 栈的压入弹出序列 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length==0){
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        int p = 0;
        for (int i : popped){
            if (!stack.contains(i)){
                while (p!=pushed.length){
                    stack.push(pushed[p]);
                    if (pushed[p]==i){
                        p++;
                        break;
                    }
                    p++;
                }
            }
            if (stack.contains(i)) {
                if (stack.pop()!=i){
                    return false;
                }
            }
        }
        return true;
    }
}
