package greedy;

public class 分割平衡字符串 {
    public int balancedStringSplit(String s) {
        char[] chars = s.toCharArray();
        int count=0,cl=0,cr=0;
        for (char c : chars){
            if (c=='L'){
                if (cr==0){
                    cl++;
                } else {
                    cr--;
                }
            } else {
                if (cl==0){
                    cr++;
                } else {
                    cl--;
                }
            }
            if (cl==0 && cr==0){
                count++;
            }
        }
        return count;
    }
}
