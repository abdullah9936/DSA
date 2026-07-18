class Solution {

    static int MOD = 1000000007;

    public static long sum(int[] arr){
        long sum = 0;

        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return sum;
    }

    public static long kadane(int[] arr) {

        long currSum = arr[0];
        long maxSum = arr[0];

        for(int i = 1; i < arr.length; i++){

            if(currSum >= 0){
                currSum += arr[i];
            }else{
                currSum = arr[i];
            }

            if(currSum > maxSum) {
                maxSum = currSum;
            }
        }

        return Math.max(maxSum, 0);
    }

    public static long kadane2(int[] arr){

        int[] newArr = new int[arr.length * 2];

        for(int i = 0; i < arr.length; i++){
            newArr[i] = arr[i];
            newArr[i + arr.length] = arr[i];
        }

        return kadane(newArr);
    }

    public int kConcatenationMaxSum(int[] arr, int k) {

        long total = sum(arr);

        if(k == 1){
            return (int)(kadane(arr) % MOD);
        }

        if(total <= 0){
            return (int)(kadane2(arr) % MOD);
        }

        long ans = kadane2(arr) + total * (k - 2);

        return (int)(ans % MOD);
    }
}