import java.util.*;

public class Main {
    public static int validateReceivingLog(String[][] records) {
        Map<String, String> seen = new HashMap<>();

        for (int i = 0; i < records.length; i++) {
            String vendorId = records[i][0];
            String lotNumber = records[i][1];
            String certCode = records[i][2];

            String key = vendorId + "\u0000" + lotNumber;

            if (seen.containsKey(key)) {
                if (!seen.get(key).equals(certCode)) {
                    return i;
                }
            } else {
                seen.put(key, certCode);
            }
        }

        return -1;
    }
}import java.util.*;

public class Main {
    public static int validateReceivingLog(String[][] records) {
        Map<String, String> seen = new HashMap<>();

        for (int i = 0; i < records.length; i++) {
            String vendorId = records[i][0];
            String lotNumber = records[i][1];
            String certCode = records[i][2];

            String key = vendorId + "\u0000" + lotNumber;

            if (seen.containsKey(key)) {
                if (!seen.get(key).equals(certCode)) {
                    return i;
                }
            } else {
                seen.put(key, certCode);
            }
        }

        return -1;
    }
}