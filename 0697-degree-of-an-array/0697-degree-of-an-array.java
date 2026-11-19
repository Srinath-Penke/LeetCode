class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, int[]> freq = new HashMap<>();

        int degree = 1;
        int best = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (!freq.containsKey(num)) {
                freq.put(num, new int[] {1, i, i});
            } else {
                int[] arr = freq.get(num);
                arr[0]++;
                arr[2] = i;
            }

            int[] arr = freq.get(num);
            if (arr[0] > degree) {
                degree = arr[0];
                best = arr[2] - arr[1] + 1;
            } else if (arr[0] == degree) {
                best = Math.min(best, arr[2] - arr[1] + 1);
            }
        }
        return best;
    }
}