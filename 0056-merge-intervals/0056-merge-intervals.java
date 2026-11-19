class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[][] res = new int[intervals.length][2];
        res[0] = intervals[0];
        int k = 1;

        for (int[] curr : intervals) {
            if (res[k - 1][1] < curr[0]) {
                res[k++] = curr;
            } else {
                res[k - 1][1] = Math.max(res[k - 1][1], curr[1]);
            }
        }

        return Arrays.copyOf(res, k);
    }
}