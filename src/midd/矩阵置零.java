package midd;

public class 矩阵置零 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        //利用元素标记，节省空间复杂度
        boolean FirstRowZero = false;
        boolean FirstcolZero = false;
        //检查第一行是否有0
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                FirstRowZero = true;
                break;
            }
        }
        //检查第一列是否有0
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                FirstcolZero = true;
                break;
            }
        }
        //从1行1列开始,如果某元素为零，将其对应的第一行和第一列的元素置零
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //上面是标记处理

        ///下面是置0处理
        //处理被置0的地方
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 处理第一行和第一列
        if (FirstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        if (FirstcolZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }


    }
}
