class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();

        for (int[] curr : intervals) {
            int n = res.size();

            if (n == 0 || res.get(n - 1)[1] < curr[0]) 
                res.add(curr);
            else
                res.get(n - 1)[1] = Math.max(res.get(n - 1)[1], curr[1]);
        }

        return res.toArray(new int[res.size()][]);
    }
}