package JZOffer;

import java.util.ArrayList;

public class 顺时针打印矩阵 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length==0){
            return new int[0];
        }
        ArrayList<Integer> res = new ArrayList<>();
        int i=0,j=0,left=0,top=0,right = matrix[0].length,bottom=matrix.length;

        while (left<right && top<bottom){
            for (;j<right &&left<right && top<bottom;j++){
                res.add(matrix[i][j]);
                if (j==right-1) {
                    i++;
                    top++;
                    break;
                }
            }
            for (;i<bottom &&left<right && top<bottom;i++){
                res.add(matrix[i][j]);
                if (i==bottom-1) {
                    j--;
                    right--;
                    break;
                }
            }
            for (;j>=left &&left<right && top<bottom;j--){
                res.add(matrix[i][j]);
                if (j==left){
                    i--;
                    bottom--;
                    break;
                }
            }
            for (;i>=top &&left<right && top<bottom;i--){
                res.add(matrix[i][j]);
                if (i==top) {
                    j++;
                    left++;
                    break;
                }
            }

            i=left;
            j=top;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
//        new 顺时针打印矩阵().spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}});
        new 顺时针打印矩阵().spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
}
