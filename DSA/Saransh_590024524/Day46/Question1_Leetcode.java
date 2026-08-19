package DSA.Saransh_590024524.Day46;

import java.util.HashSet;
import java.util.Set;

public class Question1_Leetcode {
    Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }

        Set<Integer> result = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                result.add(num);
            }
        }

        int[] ans = new int[result.size()];
        int i = 0;
        for (int num : result) {
            ans[i++] = num;
        }

        return ans;    
}
