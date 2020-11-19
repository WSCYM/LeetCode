package BinarySearch;

public class 搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0 || matrix[0].length==0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0,right = m-1;
        while (left<right){
            int mid = left + (right-left)/2;
            if (matrix[mid][n-1]<target){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left>m-1) return false;
        int row = left ; left = 0;right = n-1;
        while (left<=right){
            int mid = left + (right-left)/2;
            if (matrix[row][mid]==target){
                return true;
            } else if (matrix[row][mid]>target){
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new 搜索二维矩阵().searchMatrix(new int[][]{{1,3}},3));
    }
}
