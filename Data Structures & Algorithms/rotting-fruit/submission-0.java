class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        
        int[] dr ={-1,1,0,0};
        int[] dc = {0,0,-1,1};

        int days = 0;
        int fresh = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                else if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty() && fresh >0){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];
                for(int j =0;j<4;j++){
                    int nr = row + dr[j];
                    int nc = col + dc[j];
                    if(nr >= 0 && nc >= 0 && nr < m && nc < n &&grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        fresh--;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
            days++;
        }
        if(fresh > 0) {
            return -1;
        }
        return days;
    }
}
