public class FindmaxGroups {

    public static int findMaxGroups(int n, int[] mentor) {

        int maxGroups = 0;

        for (int student = 1; student <= n; student++) {

            int current = student;
            int count = 0;

            while (current != -1) {
                count++;

                current = mentor[current - 1];
            }

            maxGroups = Math.max(maxGroups, count);
        }

        return maxGroups;
    }

    public static void main(String[] args) {

        int n = 5;
        int[] mentor = {-1, 1, 2, 1, -1};

        int result = findMaxGroups(n, mentor);

        System.out.println(result);
    }
}