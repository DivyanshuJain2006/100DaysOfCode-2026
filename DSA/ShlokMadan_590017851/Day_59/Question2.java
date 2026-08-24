public class Question2 
{
    public static int countValidPaths(int[] tree) 
    {
        if(tree.length == 0 || tree[0] == -1)
            return 0;
        return dfs(tree, 0, 0);
    }
    public static int dfs(int[] tree, int index, int mask) 
    {
        if(index >= tree.length || tree[index] == -1)
            return 0;
        mask ^= (1 << tree[index]);
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        boolean leftExists = left < tree.length && tree[left] != -1;
        boolean rightExists = right < tree.length && tree[right] != -1;
        if(!leftExists && !rightExists) 
            {
            if((mask & (mask - 1)) == 0)
                return 1;
            return 0;
        }
        return dfs(tree, left, mask) + dfs(tree, right, mask);
    }
    public static void main(String[] args) 
    {
        int[] tree = {2, 3, 1, 3, 1, -1, 1};
        System.out.println(countValidPaths(tree));
    }
}