package stackAndQueue;

import java.util.Stack;

public class 每日温度 {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[T.length];
        for (int i = 0;i<T.length;i++){
            if (!stack.isEmpty()&&T[stack.peek()]<T[i]){
                while (!stack.isEmpty() && T[stack.peek()]<T[i]){
                    Integer pop = stack.pop();
                    ret[pop] = i-pop;
                }
            }
            stack.push(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        new 每日温度().dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
    }
}
