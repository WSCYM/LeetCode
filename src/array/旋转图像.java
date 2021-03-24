package array;

public class 旋转图像 {
    public void rotate(int[][] matrix) {
        if (matrix.length==0) return;
        for (int i = 0;i<matrix.length;i++){
            for (int j = i+1;j<matrix[0].length;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        int l = 0;int r = matrix[0].length-1;
        while (r>l){
            for (int i = 0;i<matrix.length;i++){
                int tmp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = tmp;
            }
            l++;
            r--;
        }
    }
}
