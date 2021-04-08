package JZOffer;

public class 把字符串转换成整数 {
    public int strToInt(String str) {
        if (str.length()==0) return 0;
        char[] chars = str.toCharArray();
        int i = 0;
        for (;i<chars.length;i++){
            if(chars[i]!=' ') break;
        }
        boolean lessThan0 = false;
        if (i>=chars.length || (chars[i]!='+' && chars[i]!='-' && !(chars[i]>='0' && chars[i] <='9'))){
            return 0;
        }
        if (chars[i]=='+'){
            i++;
        } else if (chars[i]=='-') {
            i++;
            lessThan0 = true;
        }
        long res = 0;
        while (i<chars.length && chars[i]>='0' && chars[i] <='9'){
            res = res*10+(chars[i]-'0');
            if (!lessThan0 && res>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if (lessThan0 && -res<Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int) (lessThan0?-res:res);
    }

    public static void main(String[] args) {
        System.out.println(new 把字符串转换成整数().strToInt("9223372036854775808"));
    }
}
