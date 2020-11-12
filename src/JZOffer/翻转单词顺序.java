package JZOffer;

public class 翻转单词顺序 {
    public String reverseWords(String s) {
        String[] ss = s.split(" +");
        StringBuffer sb = new StringBuffer();
        for (int i = ss.length-1;i>=0;i--){
            sb.append(ss[i].trim());
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
