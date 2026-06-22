class Solution {

    public int find(int[] freq) {
        int maxc = -1;

        for (int i = 0; i < 256; i++) {
            maxc = Math.max(maxc, freq[i]);
        }

        return maxc;
    }

    public int characterReplacement(String s, int k) {
        int n = s.length();

        int low = 0;
        int[] freq = new int[256];
        int res = Integer.MIN_VALUE;

        for (int high = 0; high < n; high++) {

            char ch = s.charAt(high);
            freq[ch]++;

            int maxcnt = find(freq);
            int len = high - low + 1;
            int diff = len - maxcnt;

            while (diff > k) {

                char ch2 = s.charAt(low);
                freq[ch2]--;
                low++;

                maxcnt = find(freq);
                len = high - low + 1;
                diff = len - maxcnt;
            }

            len = high - low + 1;
            res = Math.max(res, len);
        }

        return res;
    }
}