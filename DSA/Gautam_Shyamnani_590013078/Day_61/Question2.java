import java.util.*;

public class Question2{

    static int[] mentor;
    static int[] depth;

    static int findDepth(int student) {

        // Already calculated
        if (depth[student] != 0) {
            return depth[student];
        }

        if (mentor[student] == -1) {
            return depth[student] = 1;
        }

        // Depth = mentor's depth + 1
        return depth[student] = findDepth(mentor[student]) + 1;
    }

    static int minimumGroups(int n, int[] mentorInput) {

        mentor = new int[n];

        for (int i = 0; i < n; i++) {
            if (mentorInput[i] == -1) {
                mentor[i] = -1;
            } else {
                mentor[i] = mentorInput[i] - 1;
            }
        }

        depth = new int[n];

        int answer = 0;

        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, findDepth(i));
        }

        return answer;
    }

    public static void main(String[] args) {

        int n = 5;
        int[] mentor = {-1, 1, 2, 1, -1};

        System.out.println(minimumGroups(n, mentor));
    }
}