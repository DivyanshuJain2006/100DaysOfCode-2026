import java.util.*;

public class Main {

    static List<Integer> findAnagrams(String log, String pattern) {
        List<Integer> ans = new ArrayList<>();

        if (log.length() < pattern.length())
            return ans;

        int[] p = new int[26];
        int[] w = new int[26];

        for (char c : pattern.toCharArray())
            p[c - 'a']++;

        int k = pattern.length();

        for (int i = 0; i < log.length(); i++) {

            w[log.charAt(i) - 'a']++;

            if (i >= k)
                w[log.charAt(i - k) - 'a']--;

            if (Arrays.equals(p, w))
                ans.add(i - k + 1);
        }

        return ans;
    }

    public static void main(String[] args) {

        String log = "cbaebabacd";
        String pattern = "abc";

        System.out.println(findAnagrams(log, pattern));
    }
}