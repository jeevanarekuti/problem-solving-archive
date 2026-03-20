class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] ans = new int[m - k + 1][n - k + 1];

        for (int i = 0; i < m - k + 1; i++) {
            for (int j = 0; j < n - k + 1; j++) {
                List<Integer> list = new ArrayList<>();
                for (int l = i; l < i + k; l++) {
                    for (int h = j; h < j + k; h++) {
                        list.add(grid[l][h]);  // ✅ no Math.abs()
                    }
                }
                Collections.sort(list);

                int minDiff = Integer.MAX_VALUE;
                for (int idx = 0; idx < list.size() - 1; idx++) {
                    int a = list.get(idx);
                    int b = list.get(idx + 1);
                    if (a != b) {  // ✅ skip duplicates (distinct values only)
                        minDiff = Math.min(minDiff, b - a);
                    }
                }

                // ✅ if all elements same, minDiff stays MAX_VALUE → return 0
                ans[i][j] = (minDiff == Integer.MAX_VALUE) ? 0 : minDiff;
            }
        }

        return ans;
    }
}