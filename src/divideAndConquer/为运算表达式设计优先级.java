package divideAndConquer;

import java.util.ArrayList;
import java.util.List;

public class 为运算表达式设计优先级 {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        char[] chars = input.toCharArray();
        for (int i = 0;i<chars.length;i++){
            if (chars[i]=='*'||chars[i]=='+'||chars[i]=='-'){
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left){
                    for (int r : right){
                        if (chars[i] =='*'){
                            res.add(l*r);
                        }
                        if (chars[i] =='+'){
                            res.add(l+r);
                        }
                        if (chars[i] =='-'){
                            res.add(l-r);
                        }
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.valueOf(input));
        }
        return res;
    }
}
