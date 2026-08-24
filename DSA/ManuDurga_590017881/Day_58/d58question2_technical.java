package Day_58;

import java.util.*;

public class d58question2_technical {
    public static int lowestCommonAncestor(int[] tree, int a, int b) {
        Map<Integer, Integer> parent = new HashMap<>();
        int n = tree.length;

        for (int i = 0; i < n; i++) {
            if (tree[i] == -1) continue;
            int left = 2 * i + 1, right = 2 * i + 2;
            if (left < n && tree[left] != -1) parent.put(tree[left], tree[i]);
            if (right < n && tree[right] != -1) parent.put(tree[right], tree[i]);
        }

        boolean existsA = false, existsB = false;
        for (int val : tree) {
            if (val == a) existsA = true;
            if (val == b) existsB = true;
        }
        if (!existsA || !existsB) return -1;

        Set<Integer> ancestors = new HashSet<>();
        int curr = a;
        ancestors.add(curr);
        while (parent.containsKey(curr)) {
            curr = parent.get(curr);
            ancestors.add(curr);
        }

        curr = b;
        while (true) {
            if (ancestors.contains(curr)) return curr;
            if (!parent.containsKey(curr)) break;
            curr = parent.get(curr);
        }

        return -1;}}
    
// public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter Size of Array: ");
//         int n1 = sc.nextInt();
//         int[] Arr1 = new int[n1];
//         for(int i=0;i<n1;i++){
//             System.out.print(": ");
//             Arr1[i]=sc.nextInt();}
//         System.out.print("Enter Size of Array: ");
//         int n2 = sc.nextInt();
//         sc.nextLine();
//         int[] Arr2 = new int[n2];
//         for(int i=0;i<n2;i++){
//             System.out.print(": ");
//             Arr2[i]=sc.nextInt();}
//         System.out.println(checkMirror(Arr1,Arr2));
//         sc.close();}}
