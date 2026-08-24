import java.util.*;

public class Main {

    static int n;
    static int[] mentor;
    static int[] depth;

    static int getDepth(int student) {

        if (depth[student] != 0) {
            return depth[student];
        }

        if (mentor[student] == -1) {
            return depth[student] = 1;
        }

        return depth[student] =
                getDepth(mentor[student]) + 1;
    }

    static int minimumGroups(int[] mentors) {
        mentor = mentors;
        n = mentors.length;

        depth = new int[n];

        int answer = 0;

        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, getDepth(i));
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] mentor = new int[n];

        System.out.println(
                "Enter mentors (-1 if no mentor):"
        );

        for (int i = 0; i < n; i++) {
            mentor[i] = sc.nextInt();

            if (mentor[i] != -1) {
                mentor[i]--;
            }
        }

        int result = minimumGroups(mentor);

        System.out.println(
                "Minimum number of groups: " + result
        );

        sc.close();
    }
}