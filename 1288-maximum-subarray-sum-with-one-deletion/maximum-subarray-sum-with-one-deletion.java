class Solution {
    public int maximumSum(int[] arr) {
        int keep = arr[0];
        int delete = Integer.MIN_VALUE;
        int ans = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int prevKeep = keep;

            keep = Math.max(arr[i], prevKeep + arr[i]);

            if (delete == Integer.MIN_VALUE) {
                delete = prevKeep;
            } else {
                delete = Math.max(prevKeep, delete + arr[i]);
            }

            ans = Math.max(ans, Math.max(keep, delete));
        }

        return ans;
    }
}