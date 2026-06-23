class Solution {
    public String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        int[] freq = new int[256];

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            freq[ch]++;
        }

        int low = 0;
        int high = 0;
        int reqLen = t.length();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (high < s.length()) {

            char r = s.charAt(high);

            if (freq[r] > 0) {
                reqLen--;
            }

            freq[r]--;
            high++;

            while (reqLen == 0) {

                if (high - low < minLen) {
                    minLen = high - low;
                    start = low;
                }

                char l = s.charAt(low);

                freq[l]++;

                if (freq[l] > 0) {
                    reqLen++;
                }

                low++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLen);
    }
}