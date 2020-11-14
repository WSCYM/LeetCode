package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

/**
 * @author ym
 * @version 1.0.0
 * @ClassName 统计参与通信的服务器
 * @Description TODO
 * @createTime 2020-11-14 21:47:00
 */
public class 统计参与通信的服务器 {
    public int countServers(int[][] grid) {
        //找出每行只有一个的服务器，并记录位置，即为可能不能参与通信的服务器
        ArrayList<Integer[]> as = new ArrayList<>();
        int sumCount=0;
        for (int i = 0;i<grid.length;i++){
            int tmpI=-1,tmpJ=-1,count = 0;
            for (int j = 0 ;j<grid[0].length;j++){
                if (grid[i][j]==1){
                    tmpI = i;
                    tmpJ = j;
                    count++;
                    sumCount++;
                }
            }
            if (count==1){
                Integer[] pos = new Integer[2];
                pos[0] = tmpI;
                pos[1] = tmpJ;
                as.add(pos);
            }
        }
        int CanNotRes = 0;
        //对可能不能参与通讯的服务器遍历，若在该列也只有一个服务器，则不能通讯的服务器数+1
        for (Integer[] pos : as){
            int cnt = 0;
            for (int i = 0;i<grid.length;i++){
                if (grid[i][pos[1]]==1){
                    cnt++;
                }
            }
            if (cnt==1){
                CanNotRes++;
            }
        }
        //总服务器数-不能通讯服务器数
        return sumCount - CanNotRes;
    }
}
