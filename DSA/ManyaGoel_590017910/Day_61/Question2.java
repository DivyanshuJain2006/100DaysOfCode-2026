import java.io.*;
public class Question2 {
    static int[] mentor;
    static int[] depth;
    static int[] path;
    public static int getDepth(int start) {
        int current = start;
        int len = 0;
        while (current != -1 && depth[current] == 0) {
            path[len++] = current;
            current = mentor[current];
        }
        int d = (current == -1) ? 0 : depth[current];
        while (len > 0) {
            depth[path[--len]] = ++d;
        }
        return depth[start];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the number of students: ");
        int n = Integer.parseInt(br.readLine().trim());
        mentor = new int[n + 1];
        depth = new int[n + 1];
        path = new int[n + 1];

        System.out.println("Enter the mentor of each student (-1 if no mentor):");
        for (int i = 1; i <= n; i++) {
            System.out.print("Mentor of student " + i + ": ");
            mentor[i] = Integer.parseInt(br.readLine().trim());
        }
        System.out.print("Mentor: ["); 
        for (int i = 1; i <= n; i++) {
            System.out.print(mentor[i]);
            if (i < n) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, getDepth(i));
        }
        System.out.println("Minimum number of groups required: " + answer);
    }
}