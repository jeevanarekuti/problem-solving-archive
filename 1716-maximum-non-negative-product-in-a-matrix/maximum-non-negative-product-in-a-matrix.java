class Solution {
    public int maxProductPath(int[][] grid) {
        int MOD = 1_000_000_007;
        int m = grid.length;
        int n = grid[0].length;
        
        // dp_max[i][j] = maximum product from (0,0) to (i,j)
        // dp_min[i][j] = minimum product from (0,0) to (i,j)
        long[][] dp_max = new long[m][n];
        long[][] dp_min = new long[m][n];
        
        // Initialize top-left cell
        dp_max[0][0] = dp_min[0][0] = grid[0][0];
        
        // Fill first row (can only move right)
        for (int j = 1; j < n; j++) {
            dp_max[0][j] = dp_min[0][j] = dp_max[0][j-1] * grid[0][j];
        }
        
        // Fill first column (can only move down)
        for (int i = 1; i < m; i++) {
            dp_max[i][0] = dp_min[i][0] = dp_max[i-1][0] * grid[i][0];
        }
        
        // Fill the rest of the grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int current = grid[i][j];
                
                if (current >= 0) {
                    // Positive number: max * positive = max, min * positive = min
                    dp_max[i][j] = Math.max(dp_max[i-1][j], dp_max[i][j-1]) * current;
                    dp_min[i][j] = Math.min(dp_min[i-1][j], dp_min[i][j-1]) * current;
                } else {
                    // Negative number: max * negative = min, min * negative = max
                    dp_max[i][j] = Math.min(dp_min[i-1][j], dp_min[i][j-1]) * current;
                    dp_min[i][j] = Math.max(dp_max[i-1][j], dp_max[i][j-1]) * current;
                }
            }
        }

        long result = dp_max[m-1][n-1];
        return result >= 0 ? (int)(result % MOD) : -1;
    }
    /*
        1 -2 -2
        1 4,-2 4,-2
        3 -16,8,-12 8
    */
}