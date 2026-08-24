package Day_61;

public class Question2 {
    public int findGroups(int n, int[] mentor) {
        int maxDepth = 0;
        for (int i = 0; i < n; i++) {
            int depth = getDepth(i, mentor);
            maxDepth = Math.max(maxDepth, depth);
        }
        return maxDepth;
    }
    private int getDepth(int student, int[] mentor) {
        if (mentor[student] == -1) {
            return 1;
        }
        return 1 + getDepth(mentor[student] - 1, mentor);
    }
}
