class Solution {
    public int maxSubArray(int[] nums) {
        int i = 0;
        int bestEnding = nums[i];
        int ans = nums[i];

        for(i = 1; i < nums.length; i++){
            int v1 = bestEnding + nums[i];
            int v2 = nums[i];

            bestEnding = Math.max(v1, v2);
            ans = Math.max(ans, bestEnding);
        }
        return ans;
    }
}