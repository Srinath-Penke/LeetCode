class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> result = new ArrayList<>();

        int m = grid.length;
        int n = grid[0].length;

        boolean isStart = true;
        int skip = 0;

        for (int i = 0; i < m; i++) {
            int start = isStart ? 0 : n - 1;
            int end = isStart ? n : -1;
            int step = isStart ? 1 : -1;

            for (int j = start; j != end; j += step) {
                if (skip % 2 == 0) {
                    result.add(grid[i][j]);
                }
                skip++;
            }

            isStart = !isStart;
        }

        return result;
    }
}