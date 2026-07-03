import java.util.*;

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int n1 = s1.length();
        int n2 = s2.length();
        int left = 0;

        Map<Character, Integer> s1Count = new HashMap<>();
        Map<Character, Integer> s2Count = new HashMap<>();

        // Build frequency map of s1 and first window of s2
        for (int i = 0; i < n1; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            s1Count.put(c1, s1Count.getOrDefault(c1, 0) + 1);
            s2Count.put(c2, s2Count.getOrDefault(c2, 0) + 1);
        }

        // Check first window
        if (s1Count.equals(s2Count)) {
            return true;
        }

        // Sliding Window
        for (int right = n1; right < n2; right++) {

            // Add new character
            char charRight = s2.charAt(right);
            s2Count.put(charRight, s2Count.getOrDefault(charRight, 0) + 1);

            // Remove left character
            char charLeft = s2.charAt(left);
            s2Count.put(charLeft, s2Count.get(charLeft) - 1);

            if (s2Count.get(charLeft) == 0) {
                s2Count.remove(charLeft);
            }

            left++;

            if (s1Count.equals(s2Count)) {
                return true;
            }
        }

        return false;
    }
}