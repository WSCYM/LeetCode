package JZOffer;

public class 二维数组中的查找 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length==0||matrix[0].length==0) return false;
        int i = 0;
        int j = matrix[0].length-1;
        while (matrix[i][j]!=target){
            if (matrix[i][j]>target){
                if (j==0) return false;
                j--;
            } else {
                if (i==matrix.length-1) return false;
                i++;
            }
        }
        return true;
    }
}
