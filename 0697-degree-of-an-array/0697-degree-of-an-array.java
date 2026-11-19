
class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i : nums)
            freq.put(i, 1 + freq.getOrDefault(i, 0));

        int max = 0;
        for (int val : freq.values())
            max = Math.max(max, val);

        int finalMax = max;
        freq.entrySet().removeIf(entry -> entry.getValue() < finalMax);

        int best = nums.length;

        for (int key : freq.keySet()) {
            int start = -1, end = -1;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == key) {
                    if (start == -1)
                        start = i;

                    end = i;
                }
            }

            best = Math.min(best, end - start + 1);
        }

        return best;
    }
}
