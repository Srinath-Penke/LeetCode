class Solution {
    public int maxProfit(int[] prices) {
        int best = 0, min = Integer.MAX_VALUE; 
        for (int i : prices) {
            if (i < min) {
                min = i;
            }
            best = Math.max(best, i - min);
        }
        return best;
    }
}