package writtenTest.Shein;

public class Solution {
    /**
     *
     * @param str string字符串 the string
     * @return string字符串
     */
    public String changespaceto20 (String str) {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)==' '){
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().changespaceto20("a  b    c"));
    }
}
