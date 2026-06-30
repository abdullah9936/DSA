class Solution {
    public int maxProduct(int[] nums) {
        int i = 0;
        int  minEnding = nums[i];
        int maxEnding = nums[i];
        int res = nums[i];


        for(i = 1; i < nums.length; i++){
            int v1 = nums[i];
            int v2 = minEnding * nums[i];
            int v3 = maxEnding * nums[i];

            minEnding = Math.min(v1, Math.min(v2, v3));
            maxEnding = Math.max(v1, Math.max(v2, v3));

            res = Math.max(res, maxEnding);

        }
        return res;
        
    }
}