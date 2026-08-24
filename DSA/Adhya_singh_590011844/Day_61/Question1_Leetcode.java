import java.util.*;

public class Main {

    static int findJudge(int n, int[][] trust) {

        int[] inDegree = new int[n + 1];
        int[] outDegree = new int[n + 1];

        for (int[] relation : trust) {
            int a = relation[0];
            int b = relation[1];

            outDegree[a]++;
            inDegree[b]++;
        }

        for (int person = 1; person <= n; person++) {

            if (inDegree[person] == n - 1 &&
                outDegree[person] == 0) {

                return person;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of people: ");
        int n = sc.nextInt();

        System.out.print("Enter number of trust relationships: ");
        int m = sc.nextInt();

        int[][] trust = new int[m][2];

        System.out.println("Enter trust relationships:");

        for (int i = 0; i < m; i++) {
            trust[i][0] = sc.nextInt();
            trust[i][1] = sc.nextInt();
        }

        int result = findJudge(n, trust);

        System.out.println("Town Judge: " + result);

        sc.close();
    }
}