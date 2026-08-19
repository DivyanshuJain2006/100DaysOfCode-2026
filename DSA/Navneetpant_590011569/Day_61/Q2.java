class Solution {
    public int findGroups(int n, int[] mentor) {

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int current = i;
            int depth = 1;

            while (mentor[current] != -1) {
                depth++;
                current = mentor[current] - 1;
            }

            map.putIfAbsent(depth, new ArrayList<>());
            map.get(depth).add(i + 1);
        }

        return map.size();
    }
}