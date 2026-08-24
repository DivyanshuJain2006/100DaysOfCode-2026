import java.util.HashMap;

public class Question2 {

    static String winner(String[] goals) {
        HashMap<String, Integer> map = new HashMap<>();

        String ans = "";
        int maxGoals = 0;

        for (String team : goals) {
            int cnt = map.getOrDefault(team, 0) + 1;
            map.put(team, cnt);

            if (cnt > maxGoals) {
                maxGoals = cnt;
                ans = team;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] goals = {"A", "ABA", "ABA", "A", "A"};

        System.out.println(winner(goals));
    }
}