import java.util.*;

public class Question2 {

    public static int findNode(int[] tree, int value) {

        for(int i = 0; i < tree.length; i++) {
            if(tree[i] == value)
                return i;
        }

        return -1;
    }

    public static List<Integer> getPath(int[] tree, int index) {

        List<Integer> path = new ArrayList<>();

        while(index >= 0) {
            if(index >= tree.length || tree[index] == -1)
                break;

            path.add(index);

            if(index == 0)
                break;

            index = (index - 1) / 2;
        }

        Collections.reverse(path);

        return path;
    }

    public static int findLCA(int[] tree, int a, int b) {

        int indexA = findNode(tree, a);
        int indexB = findNode(tree, b);

        if(indexA == -1 || indexB == -1)
            return -1;

        List<Integer> pathA = getPath(tree, indexA);
        List<Integer> pathB = getPath(tree, indexB);

        int lcaIndex = -1;

        int size = Math.min(pathA.size(), pathB.size());

        for(int i = 0; i < size; i++) {

            if(pathA.get(i).equals(pathB.get(i)))
                lcaIndex = pathA.get(i);
            else
                break;
        }

        return tree[lcaIndex];
    }

    public static void main(String[] args) {

        int[] tree = {3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4};

        int a = 6;
        int b = 4;

        System.out.println(findLCA(tree, a, b));
    }
}