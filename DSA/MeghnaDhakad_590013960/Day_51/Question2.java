import java.util.HashMap;
import java.util.Map;

public class Question2 {

    static int firstInvalidRecord(String[][] logs) {
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < logs.length; i++) {
            String key = logs[i][0] + "#" + logs[i][1];
            String cert = logs[i][2];

            if (map.containsKey(key)) {
                if (!map.get(key).equals(cert))
                    return i;
            } else {
                map.put(key, cert);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String[][] logs = {
                {"V1", "L1", "C1"},
                {"V2", "L2", "C3"},
                {"V1", "L1", "C1"},
                {"V1", "L1", "C2"}
        };

        System.out.println(firstInvalidRecord(logs));
    }
}