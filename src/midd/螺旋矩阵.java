package midd;

import java.util.ArrayList;
import java.util.List;

public class 螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        int m=matrix.length;
        int n=matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int total=m*n;
        //行列下标
        int row=0;
        int column=0;
        //方向数组，两个元素分别表示行和列的加减
        //分别表示右、下、左、上。即逆时针方向
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        //逐一遍历所有元素
        for(int i=0;i<total;i++){
            list.add(matrix[row][column]);
            visited[row][column]=true;
            int nextRow=row+directions[directionIndex][0];
            int nextColumn=column+directions[directionIndex][1];
            //超出边界或者下一个元素已访问
            if(nextRow<0 || nextRow>=m || nextColumn < 0 || nextColumn >= n
                    || visited[nextRow][nextColumn]){
                directionIndex = (directionIndex + 1) % 4;
            }
            row+=directions[directionIndex][0];
            column+=directions[directionIndex][1];

        }
        return list;


    }
}
