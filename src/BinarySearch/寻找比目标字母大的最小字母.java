package BinarySearch;

public class 寻找比目标字母大的最小字母 {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0,right = letters.length-1;
        while (left<right){
            int mid = (left+right)/2;
            if (letters[mid]<=target){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left==letters.length-1){
            if (letters[left]<=target){
                return letters[0];
            }
        }
        return letters[left];
    }
}
