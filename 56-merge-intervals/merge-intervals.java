class Solution {
    public int[][] merge(int[][] a) {

        Arrays.sort(a, (x, y) -> Integer.compare(x[0], y[0]));

        List<int[]> res = new ArrayList<>();

        int start = a[0][0];
        int end = a[0][1];

        for (int i = 1; i < a.length; i++) {

            int s = a[i][0];
            int e = a[i][1];

            if (end >= s) {          // Overlapping intervals
                end = Math.max(end, e);
            } else {                 // Non-overlapping interval
                res.add(new int[]{start, end});
                start = s;
                end = e;
            }
        }

        // Add the last interval
        res.add(new int[]{start, end});

        return res.toArray(new int[res.size()][]);
    }
}