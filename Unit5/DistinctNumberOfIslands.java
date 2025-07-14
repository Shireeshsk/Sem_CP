package Unit5;

import java.util.*;
public class DistinctNumberOfIslands {
    public int countDistinctIslands(int[][] grid) {
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        Set<String> set = new TreeSet<>();
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    StringBuilder sb = new StringBuilder();
                    dfs(i,j,i,j,vis,grid,sb);
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }

    public void dfs(int row,int col,int br,int bc,boolean vis[][],int grid[][],StringBuilder sb){
        vis[row][col] = true;
        sb.append(row-br).append(" ").append(col-bc).append(" ");
        int rowdir[] ={-1,0,1,0};
        int coldir[] = {0,1,0,-1};
        for(int i =0;i<4;i++){
            int nrow= row + rowdir[i];
            int ncol = col + coldir[i];
            if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && grid[nrow][ncol]==1 && !vis[nrow][ncol]){
                dfs(nrow,ncol,br,bc,vis,grid,sb);
            }
        }
    }
}
