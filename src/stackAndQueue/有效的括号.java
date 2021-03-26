package stackAndQueue;

import java.util.Stack;

public class 有效的括号 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars){
            if (c==']'){
                if(stack.isEmpty() || stack.pop()!='['){
                    return false;
                }
            } else if (c==')'){
                if(stack.isEmpty() || stack.pop()!='('){
                    return false;
                }
            } else if (c=='}'){
                if(stack.isEmpty() || stack.pop()!='{'){
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
}
