class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int currPSum = 0;
        int currNSum = 0;

        for(int i = 0; i < nums.length; i++){
            currPSum = currPSum + nums[i];
            maxSum = Math.max(maxSum, currPSum);
            if(currPSum < 0){
                currPSum = 0;
            }

            currNSum = currNSum + nums[i];
            minSum = Math.min(minSum, currNSum);
            if(currNSum > 0){
                currNSum = 0;
            }
        }
        return Math.max(maxSum, Math.abs(minSum));
    }
}