class Solution {
    public String removeDuplicates(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (st.empty()) {
                st.push(ch);
            } 
            else if (st.peek() == ch) {
                st.pop();
            } 
            else {
                st.push(ch);
            }
        }

        StringBuilder res = new StringBuilder();

        while (!st.empty()) {
            res.append(st.pop());
        }

        return res.reverse().toString();
    }
}