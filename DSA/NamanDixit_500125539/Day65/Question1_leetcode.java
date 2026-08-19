class Question1_leetcode {

    // HashMap stores:
    // value -> number of times it appears
    HashMap<Integer, Integer> frequency = new HashMap<>();


    // ---------------------------------------------------------
    // FUNCTION TO COUNT FREQUENCY OF EACH NODE
    // ---------------------------------------------------------

    void countFrequency(TreeNode root) {

        // If the node is empty, stop
        if (root == null) {
            return;
        }

        // Get the value of the current node
        int value = root.val;

        // Increase the frequency of this value
        frequency.put(
            value,
            frequency.getOrDefault(value, 0) + 1
        );

        // Visit the left subtree
        countFrequency(root.left);

        // Visit the right subtree
        countFrequency(root.right);
    }


    // ---------------------------------------------------------
    // MAIN LEETCODE FUNCTION
    // ---------------------------------------------------------

    public int[] findMode(TreeNode root) {

        // First, count how many times
        // every value appears
        countFrequency(root);


        // Variable to store the highest frequency
        int maxFrequency = 0;


        // Find the highest frequency
        for (int count : frequency.values()) {

            if (count > maxFrequency) {
                maxFrequency = count;
            }
        }


        // Store all modes
        ArrayList<Integer> modes = new ArrayList<>();


        // Check every value in the HashMap
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {

            // If its frequency is equal to
            // the highest frequency,
            // it is a mode
            if (entry.getValue() == maxFrequency) {

                modes.add(entry.getKey());
            }
        }


        // Convert ArrayList to int[]
        int[] result = new int[modes.size()];


        // Copy values into the result array
        for (int i = 0; i < modes.size(); i++) {

            result[i] = modes.get(i);
        }


        // Return all modes
        return result;
    }
}