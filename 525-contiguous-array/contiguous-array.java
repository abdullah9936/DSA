class Solution {
    public int findMaxLength(int[] a) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int zero = 0;
        int one = 0;
        int res = 0;

        for (int i = 0; i < a.length; i++) {

            if (a[i] == 0) {
                zero++;
            } else {
                one++;
            }

            int diff = zero - one;

            if (diff == 0) {

                res = Math.max(res, i + 1);
                
            } else if (map.containsKey(diff)) {

                int idx = map.get(diff);
                res = Math.max(res, i - idx);

            } else {

                map.put(diff, i);
            }
        }

        return res;
    }
}