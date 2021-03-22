package bitManipulation;

public class 最大单词长度乘积 {
    public boolean hasSameWord(String a,String b){
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        boolean[] chars = new boolean[26];
        for (char charA:charsA){
            chars[charA-'a'] = true;
        }
        for (char charB:charsB){
            if (chars[charB-'a']){
                return true;
            }
        }
        return false;
    }

    public int maxProduct(String[] words) {
        int maxLength = 0;
        for (int i = 0;i<words.length;i++){
            for (int j = i+1;j<words.length;j++){
                if (!hasSameWord(words[i],words[j])&&words[i].length()*words[j].length()>maxLength){
                    maxLength = words[i].length()*words[j].length();
                }
            }
        }
        return maxLength;
    }
}
