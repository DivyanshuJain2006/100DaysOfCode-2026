import java.util.*;

class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.offer(num);
        }

        while (k-- > 0) {
            int min = pq.poll();
            min *= multiplier;
            pq.offer(min);
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = pq.poll();
        }

        return nums;
    }
}