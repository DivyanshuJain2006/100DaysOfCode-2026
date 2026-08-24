import java.util.*;

class Main {

    static int lca(int[] tree, int a, int b) {
        List<Integer> pathA = new ArrayList<>();
        List<Integer> pathB = new ArrayList<>();

        if (!findPath(tree, 0, a, pathA) || !findPath(tree, 0, b, pathB))
            return -1;

        int i = 0;
        int ans = -1;

        while (i < pathA.size() && i < pathB.size()) {
            if (!pathA.get(i).equals(pathB.get(i)))
                break;

            ans = pathA.get(i);
            i++;
        }

        return ans;
    }

    static boolean findPath(int[] tree, int index, int target, List<Integer> path) {
        if (index >= tree.length || tree[index] == -1)
            return false;

        path.add(tree[index]);

        if (tree[index] == target)
            return true;

        if (findPath(tree, 2 * index + 1, target, path) ||
            findPath(tree, 2 * index + 2, target, path))
            return true;

        path.remove(path.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        int[] tree = {3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4};

        System.out.println(lca(tree, 5, 1));
        System.out.println(lca(tree, 6, 4));
        System.out.println(lca(new int[]{1, 2, 3}, 2, 99));
    }
}
