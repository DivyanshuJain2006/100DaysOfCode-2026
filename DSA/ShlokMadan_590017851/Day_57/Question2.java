
public class Question2 
{
    public static boolean isMirror(int[] a, int[] b) 
    {
        return checkMirror(a, b, 0, 0);
    }
    public static boolean checkMirror(int[] a, int[] b, int i, int j) 
    {
        boolean aExists = i < a.length && a[i] != -1;
        boolean bExists = j < b.length && b[j] != -1;
        if(!aExists && !bExists)
            return true;
        if(aExists != bExists)
            return false;
        if(a[i] != b[j])
            return false;
        boolean leftRight = checkMirror(a, b, 2 * i + 1, 2 * j + 2);
        boolean rightLeft = checkMirror(a, b, 2 * i + 2, 2 * j + 1);
        return leftRight && rightLeft;
    }
    public static void main(String[] args) 
    {
        int[] warehouse1 = {1, 2, 3};
        int[] warehouse2 = {1, 3, 2};
        if(isMirror(warehouse1, warehouse2))
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}