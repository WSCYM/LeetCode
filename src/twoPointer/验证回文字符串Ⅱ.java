package twoPointer;

public class 验证回文字符串Ⅱ {
    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length-1;
        boolean removed = false;
        while (left<right){
            if (chars[left]==chars[right]){
                left++;
                right--;
            } else {
                if (isValid(chars,left+1,right) || isValid(chars,left,right-1)){
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    boolean isValid(char[] chars,int left,int right){
        while (left<right){
            if (chars[left]==chars[right]){
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
