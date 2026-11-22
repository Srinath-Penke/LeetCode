class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> result = new ArrayList<>();

        int m = grid.length;
        int n = grid[0].length;

        int skip = 0;

        for (int i = 0; i < m; i++) {
            int start = (i % 2 == 0) ? 0 : n - 1;
            int step = (i % 2 == 0) ? 1 : -1;

            for (int j = start; j >= 0 && j < n; j += step) {
                if (skip % 2 == 0) {
                    result.add(grid[i][j]);
                }
                skip++;
            }
        }

        return result;
    }
}
