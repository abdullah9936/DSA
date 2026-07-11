class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;

        for(int i = 0; i < n; i++){
            sum += nums[i];
        }

        for(int j = 0; j < n; j++){
            
            right = sum - nums[j] - left;

            if(left == right){
                return j;
            }
            left += nums[j];
        }
        return -1;
    }
}