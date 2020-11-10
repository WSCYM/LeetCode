package JZOffer;

public class 左旋转字符串 {
    public String reverseLeftWords(String s, int n) {
        String ls = s.substring(0 , n);
        String rs = s.substring(n);
        return rs.concat(ls);
    }
}
