package midd;

public class 单词搜索 {
    public boolean exist(char[][] board, String word){
        int row=board.length;
        int col=board[0].length;
        boolean[][] visit=new boolean[row][col];
        int[][] direct={{0,1},{0,-1},{1,0},{-1,0}};
        char[] words=word.toCharArray();
        int len=word.length();
        //对二维数组的每个元素都dfs
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(dfs(i,j,board,word,row,col,direct,len,visit,words,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int x, int y, char[][] board, String word, int row, int col, int[][] direct, int len, boolean[][] visit, char[] words, int idx) {
        //搜索到String中的最后一个字母了，看最后一个字母是否相同
        if (idx == len - 1) {
            return board[x][y] == words[idx];
        }
        //字母匹配成功
        if (board[x][y] == words[idx]) {
            //访问
            visit[x][y] = true;
            //回溯
            for (int[] direction : direct) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                //下一个位置未出界且未访问过
                if (inArea(newX, newY,row,col) && !visit[newX][newY]) {
                    if (dfs(newX,newY,board,word,row,col,direct,len,visit,words,idx+1)) {
                        return true;
                    }
                }
            }
            //撤销访问
            visit[x][y] = false;
        }
        return false;

    }

    private boolean inArea(int x, int y, int row, int col) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }


}
