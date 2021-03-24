package array;

public class 搜索二维矩阵II {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left,right,up,bottom;
        right = 0;
        while (right+1<matrix[0].length && matrix[0][right+1]<=target) right++;
        bottom = 0;
        while (bottom+1<matrix.length && matrix[bottom+1][0]<=target) bottom++;
        left=right;
        while (left-1>=0 &&matrix[bottom][left-1]>=target) left--;
        up = bottom;
        while (up-1>=0 &&matrix[up-1][right]>=target) up--;
        for (int i = up;i<=bottom;i++){
            for (int j=left;j<=right;j++){
                if (matrix[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new 搜索二维矩阵II().searchMatrix(new int[][]{{-1,3}},3);
    }
}
