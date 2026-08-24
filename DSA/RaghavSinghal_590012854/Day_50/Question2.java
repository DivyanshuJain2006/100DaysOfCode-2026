import java.util.*;

public class Main {

    static int lastRockWeight(int[] rocks) {
        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int rock : rocks) {
            pq.offer(rock);
        }

        while (pq.size() > 1) {
            int x = pq.poll(); 
            int y = pq.poll(); 

            if (x != y) {
                pq.offer(x - y);
            }
        }

        if (pq.isEmpty()) {
            return 0;
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        int[] rocks = {2, 7, 4, 1, 8, 1};

        System.out.println(lastRockWeight(rocks));
    }
}