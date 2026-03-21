class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int low = x;
        int high = x+k-1;

        while(low<high){
            for(int a = y;a<y+k;a++){
                int val = grid[low][a];
                grid[low][a] = grid[high][a];
                grid[high][a] = val;
            }
            low++;
            high--;
        }
        return grid;
    }
}