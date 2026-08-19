import java.util.*;

public class Question2 {

    public static void main(String[] args) {

        int[] tree = {3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4};
        int a1 = 5;
        int b1 = 1;

        System.out.println(findLCA(tree, a1, b1));
    }


    static int findLCA(int[] tree, int a, int b) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < tree.length; i++) {

            if (tree[i] != -1) {
                map.put(tree[i], i);
            }
        }

        if (!map.containsKey(a) || !map.containsKey(b)) {
            return -1;
        }

        int indexA = map.get(a);
        int indexB = map.get(b);

        HashSet<Integer> ancestors = new HashSet<>();

        while (true) {

            ancestors.add(indexA);

            if (indexA == 0) {
                break;
            }

            indexA = (indexA - 1) / 2;
        }

        while (!ancestors.contains(indexB)) {
            indexB = (indexB - 1) / 2;
        }

        return tree[indexB];
    }
}