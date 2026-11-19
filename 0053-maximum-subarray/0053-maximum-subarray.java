class Solution {
    public int maxSubArray(int[] nums) {
        int best = Integer.MIN_VALUE, cur = Integer.MIN_VALUE;

        for (int i : nums) {
            if (cur < 0) {
                cur = i;
            } else {
                cur = Math.max(i, cur + i);
            }
            best = Math.max(cur, best);
        }

        return best;
    }
}