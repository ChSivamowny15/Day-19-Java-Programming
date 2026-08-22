import java.util.*;

class Node {
    int val;
    Node left, right;

    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Binarytreetravelsell {

    int sum, max = 0, min = 0;

    // =========================================================
    // INSERT
    // =========================================================

    public Node insert(Node root, int val) {
        if (root == null)
            return new Node(val);

        if (val < root.val)
            root.left = insert(root.left, val);
        else if (val > root.val)
            root.right = insert(root.right, val);

        return root;
    }

    // =========================================================
    // 2. INORDER
    // =========================================================

    private void helper(Node root, List<Integer> res) {
        if (root == null)
            return;

        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }

    public List<Integer> inorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    // =========================================================
    // 3. PREORDER
    // =========================================================

    private void helper1(Node root, List<Integer> res) {
        if (root == null)
            return;

        res.add(root.val);
        helper1(root.left, res);
        helper1(root.right, res);
    }

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper1(root, res);
        return res;
    }

    // =========================================================
    // 4. POSTORDER
    // =========================================================

    private void helper2(Node root, List<Integer> res) {
        if (root == null)
            return;

        helper2(root.left, res);
        helper2(root.right, res);
        res.add(root.val);
    }

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper2(root, res);
        return res;
    }

    // =========================================================
    // 5. LEVEL ORDER
    // =========================================================

    public List<List<Integer>> level(Node root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int levelsize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelsize; i++) {

                Node currentNode = queue.remove();
                currentLevel.add(currentNode.val);

                if (currentNode.left != null)
                    queue.add(currentNode.left);

                if (currentNode.right != null)
                    queue.add(currentNode.right);
            }

            result.add(currentLevel);
        }

        return result;
    }

    // =========================================================
    // 6. COUNT NODES
    // =========================================================

    public int countNodes(Node root) {

        if (root == null)
            return 0;

        int left = countNodes(root.left);
        int right = countNodes(root.right);

        return 1 + left + right;
    }

    // =========================================================
    // 7. LEAF NODES
    // =========================================================

    public void leafNodes(Node root) {

        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            System.out.print(root.val + " ");
            return;
        }

        leafNodes(root.left);
        leafNodes(root.right);
    }

    // =========================================================
    // 8. NON-LEAF NODES
    // =========================================================

    public void nonLeafNodes(Node root) {

        if (root == null)
            return;

        if (root.left != null || root.right != null)
            System.out.print(root.val + " ");

        nonLeafNodes(root.left);
        nonLeafNodes(root.right);
    }

    // =========================================================
    // 9. SUM OF NODES
    // =========================================================

    public int sumNodes(Node root) {

        if (root == null)
            return 0;

        return root.val + sumNodes(root.left) + sumNodes(root.right);
    }

    // =========================================================
    // 10. MINIMUM AND MAXIMUM
    // =========================================================

    public void findMinMax(Node root) {

        if (root == null)
            return;

        min = Math.min(min, root.val);
        max = Math.max(max, root.val);

        findMinMax(root.left);
        findMinMax(root.right);
    }

    // =========================================================
    // 11. LEFT VIEW
    // =========================================================

    public List<Integer> leftView(Node root) {

        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                Node current = queue.remove();

                if (i == 0)
                    result.add(current.val);

                if (current.left != null)
                    queue.add(current.left);

                if (current.right != null)
                    queue.add(current.right);
            }
        }

        return result;
    }

    // =========================================================
    // 12. RIGHT VIEW
    // =========================================================

    public List<Integer> rightView(Node root) {

        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                Node current = queue.remove();

                if (i == size - 1)
                    result.add(current.val);

                if (current.left != null)
                    queue.add(current.left);

                if (current.right != null)
                    queue.add(current.right);
            }
        }

        return result;
    }

    // =========================================================
    // 13. BOUNDARY TRAVERSAL
    // =========================================================

    public void boundaryTraversal(Node root) {

        if (root == null)
            return;

        System.out.print(root.val + " ");

        leftBoundary(root.left);
        leafBoundary(root.left);
        leafBoundary(root.right);
        rightBoundary(root.right);
    }

    private void leftBoundary(Node root) {

        Node current = root;

        while (current != null) {

            if (current.left != null || current.right != null)
                System.out.print(current.val + " ");

            if (current.left != null)
                current = current.left;
            else
                current = current.right;
        }
    }

    private void leafBoundary(Node root) {

        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            System.out.print(root.val + " ");
            return;
        }

        leafBoundary(root.left);
        leafBoundary(root.right);
    }

    private void rightBoundary(Node root) {

        if (root == null)
            return;

        if (root.right != null) {
            rightBoundary(root.right);
            System.out.print(root.val + " ");
        }
        else if (root.left != null) {
            rightBoundary(root.left);
            System.out.print(root.val + " ");
        }
    }

    // =========================================================
    // 14. LOWEST COMMON ANCESTOR
    // =========================================================

    public Node LCA(Node root, int a, int b) {

        while (root != null) {

            if (a < root.val && b < root.val)
                root = root.left;

            else if (a > root.val && b > root.val)
                root = root.right;

            else
                return root;
        }

        return null;
    }

    // =========================================================
    // 15. ZIGZAG TRAVERSAL
    // =========================================================

    public List<List<Integer>> zigzag(Node root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        boolean leftToRight = true;

        while (!queue.isEmpty()) {

            int size = queue.size();

            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                Node current = queue.remove();
                level.add(current.val);

                if (current.left != null)
                    queue.add(current.left);

                if (current.right != null)
                    queue.add(current.right);
            }

            if (!leftToRight)
                Collections.reverse(level);

            result.add(level);

            leftToRight = !leftToRight;
        }

        return result;
    }

    // =========================================================
    // 16. VALIDATE BST
    // =========================================================

    public boolean validateBST(Node root) {

        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(Node root, long minValue, long maxValue) {

        if (root == null)
            return true;

        if (root.val <= minValue || root.val >= maxValue)
            return false;

        return validate(root.left, minValue, root.val)
                && validate(root.right, root.val, maxValue);
    }

    // =========================================================
    // 17. KTH SMALLEST
    // =========================================================

    int k;
    int kthAnswer;

    public int kthSmallest(Node root, int kValue) {

        k = kValue;
        kthAnswer = -1;

        kthHelper(root);

        return kthAnswer;
    }

    private void kthHelper(Node root) {

        if (root == null)
            return;

        kthHelper(root.left);

        if (k > 0) {
            k--;

            if (k == 0) {
                kthAnswer = root.val;
                return;
            }
        }

        kthHelper(root.right);
    }

    // =========================================================
    // 18. ARRAY TO BST
    // =========================================================

    public Node arrayToBST(int[] arr, int left, int right) {

        if (left > right)
            return null;

        int mid = (left + right) / 2;

        Node root = new Node(arr[mid]);

        root.left = arrayToBST(arr, left, mid - 1);
        root.right = arrayToBST(arr, mid + 1, right);

        return root;
    }

    // =========================================================
    // 19. DELETE NODE
    // =========================================================

    public Node deleteNode(Node root, int key) {

        if (root == null)
            return null;

        if (key < root.val) {

            root.left = deleteNode(root.left, key);

        }
        else if (key > root.val) {

            root.right = deleteNode(root.right, key);

        }
        else {

            // No left child
            if (root.left == null)
                return root.right;

            // No right child
            if (root.right == null)
                return root.left;

            // Two children
            Node successor = root.right;

            while (successor.left != null)
                successor = successor.left;

            root.val = successor.val;

            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }

    // =========================================================
    // 20. SERIALIZE
    // =========================================================

    public String serialize(Node root) {

        StringBuilder sb = new StringBuilder();

        serializeHelper(root, sb);

        return sb.toString();
    }

    private void serializeHelper(Node root, StringBuilder sb) {

        if (root == null)
            return;

        sb.append(root.val).append(",");

        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // =========================================================
    // 21. DESERIALIZE
    // =========================================================

    Queue<Integer> values;

    public Node deserialize(String data) {

        values = new LinkedList<>();

        if (data == null || data.length() == 0)
            return null;

        String[] arr = data.split(",");

        for (String x : arr) {

            if (!x.isEmpty())
                values.add(Integer.parseInt(x));
        }

        return buildTree(Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private Node buildTree(long minValue, long maxValue) {

        if (values.isEmpty())
            return null;

        int value = values.peek();

        if (value <= minValue || value >= maxValue)
            return null;

        values.remove();

        Node root = new Node(value);

        root.left = buildTree(minValue, value);
        root.right = buildTree(value, maxValue);

        return root;
    }

    // =========================================================
    // DISPLAY INORDER
    // =========================================================

    public void displayInorder(Node root) {

        List<Integer> result = inorder(root);

        System.out.println(result);
    }

    // =========================================================
    // MAIN METHOD
    // =========================================================

    public static void main(String args[]) {

        Travelsel sol = new Travelsel();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Root val : ");

        Node root = new Node(sc.nextInt());

        int choice, no;

        do {

            // =================================================
            // NEW MENU
            // =================================================

            System.out.println("\nMenuuuuuu:");
            System.out.println(".............");

            System.out.println(
                "\n1.Insert , " +
                "2.Inorder , " +
                "3.Preorder , " +
                "4.Postorder, " +
                "5.Level Order Traversal, " +
                "6.Count , " +
                "7.Leaf Nodes, " +
                "8.Non Leaf Nodes, " +
                "9.Sum, " +
                "10.MinMax, " +
                "11.LeftView , " +
                "12.RightView, " +
                "13.Boundary View, " +
                "14.LCA , " +
                "15.Zigzag , " +
                "16.Validate BST , " +
                "17.Kth Smallest , " +
                "18.ArrayToBST , " +
                "19.Delete Node , " +
                "20.Serialize , " +
                "21.Deserialize , " +
                "22.Exit\n"
            );

            System.out.print("Enter the Choice : ");

            choice = sc.nextInt();

            switch (choice) {

                // =================================================
                // 1. INSERT
                // =================================================

                case 1:

                    System.out.println("Insert Node");

                    System.out.print("Enter No of Nodes : ");
                    no = sc.nextInt();

                    for (int i = 1; i <= no; i++) {

                        System.out.print("Enter value " + i + ": ");

                        int value = sc.nextInt();

                        root = sol.insert(root, value);
                    }

                    System.out.println("Nodes Inserted successfully");

                    break;

                // =================================================
                // 2. INORDER
                // =================================================

                case 2:

                    System.out.println("Inorder");

                    List<Integer> result = sol.inorder(root);

                    System.out.println(result);

                    break;

                // =================================================
                // 3. PREORDER
                // =================================================

                case 3:

                    System.out.println("Preorder");

                    result = sol.preorder(root);

                    System.out.println(result);

                    break;

                // =================================================
                // 4. POSTORDER
                // =================================================

                case 4:

                    System.out.println("Postorder");

                    result = sol.postorder(root);

                    System.out.println(result);

                    break;

                // =================================================
                // 5. LEVEL ORDER
                // =================================================

                case 5:

                    System.out.println("Level Order Traversal");

                    List<List<Integer>> result1 = sol.level(root);

                    System.out.println(result1);

                    break;

                // =================================================
                // 6. COUNT
                // =================================================

                case 6:

                    System.out.println("Node Count:");

                    int totalNodes = sol.countNodes(root);

                    System.out.println(
                        "Total number of nodes: " + totalNodes
                    );

                    break;

                // =================================================
                // 7. LEAF NODES
                // =================================================

                case 7:

                    System.out.println("Leaf Nodes:");

                    sol.leafNodes(root);

                    System.out.println();

                    break;

                // =================================================
                // 8. NON LEAF NODES
                // =================================================

                case 8:

                    System.out.println("Non Leaf Nodes:");

                    sol.nonLeafNodes(root);

                    System.out.println();

                    break;

                // =================================================
                // 9. SUM
                // =================================================

                case 9:

                    System.out.println("Sum of Nodes:");

                    int totalSum = sol.sumNodes(root);

                    System.out.println(
                        "Total Sum: " + totalSum
                    );

                    break;

                // =================================================
                // 10. MIN MAX
                // =================================================

                case 10:

                    sol.min = Integer.MAX_VALUE;
                    sol.max = Integer.MIN_VALUE;

                    sol.findMinMax(root);

                    System.out.println("Minimum: " + sol.min);
                    System.out.println("Maximum: " + sol.max);

                    break;

                // =================================================
                // 11. LEFT VIEW
                // =================================================

                case 11:

                    System.out.println("Left View:");

                    List<Integer> leftResult =
                        sol.leftView(root);

                    System.out.println(leftResult);

                    break;

                // =================================================
                // 12. RIGHT VIEW
                // =================================================

                case 12:

                    System.out.println("Right View:");

                    List<Integer> rightResult =
                        sol.rightView(root);

                    System.out.println(rightResult);

                    break;

                // =================================================
                // 13. BOUNDARY
                // =================================================

                case 13:

                    System.out.println("Boundary Traversal:");

                    sol.boundaryTraversal(root);

                    System.out.println();

                    break;

                // =================================================
                // 14. LCA
                // =================================================

                case 14:

                    System.out.print("Enter first value: ");
                    int a = sc.nextInt();

                    System.out.print("Enter second value: ");
                    int b = sc.nextInt();

                    Node lcaNode = sol.LCA(root, a, b);

                    if (lcaNode != null)
                        System.out.println(
                            "LCA: " + lcaNode.val
                        );
                    else
                        System.out.println(
                            "LCA not found"
                        );

                    break;

                // =================================================
                // 15. ZIGZAG
                // =================================================

                case 15:

                    System.out.println("Zigzag Traversal:");

                    List<List<Integer>> zigzagResult =
                        sol.zigzag(root);

                    System.out.println(zigzagResult);

                    break;

                // =================================================
                // 16. VALIDATE BST
                // =================================================

                case 16:

                    boolean valid = sol.validateBST(root);

                    if (valid)
                        System.out.println(
                            "Valid Binary Search Tree"
                        );
                    else
                        System.out.println(
                            "Not a Valid Binary Search Tree"
                        );

                    break;

                // =================================================
                // 17. KTH SMALLEST
                // =================================================

                case 17:

                    System.out.print(
                        "Enter K value: "
                    );

                    int kValue = sc.nextInt();

                    int kth = sol.kthSmallest(
                        root,
                        kValue
                    );

                    if (kth == -1)
                        System.out.println(
                            "Invalid K"
                        );
                    else
                        System.out.println(
                            "Kth Smallest: " + kth
                        );

                    break;

                // =================================================
                // 18. ARRAY TO BST
                // =================================================

                case 18:

                    System.out.print(
                        "Enter array size: "
                    );

                    int n = sc.nextInt();

                    int[] arr = new int[n];

                    System.out.println(
                        "Enter sorted array:"
                    );

                    for (int i = 0; i < n; i++)
                        arr[i] = sc.nextInt();

                    root = sol.arrayToBST(
                        arr,
                        0,
                        n - 1
                    );

                    System.out.println(
                        "BST created successfully"
                    );

                    System.out.println(
                        "Inorder: " +
                        sol.inorder(root)
                    );

                    break;

                // =================================================
                // 19. DELETE NODE
                // =================================================

                case 19:

                    System.out.print(
                        "Enter value to delete: "
                    );

                    int deleteValue = sc.nextInt();

                    root = sol.deleteNode(
                        root,
                        deleteValue
                    );

                    System.out.println(
                        "After deletion:"
                    );

                    System.out.println(
                        sol.inorder(root)
                    );

                    break;

                // =================================================
                // 20. SERIALIZE
                // =================================================

                case 20:

                    String data =
                        sol.serialize(root);

                    System.out.println(
                        "Serialized Tree:"
                    );

                    System.out.println(data);

                    break;

                // =================================================
                // 21. DESERIALIZE
                // =================================================

                case 21:

                    sc.nextLine();

                    System.out.print(
                        "Enter serialized data: "
                    );

                    String serializedData =
                        sc.nextLine();

                    root = sol.deserialize(
                        serializedData
                    );

                    System.out.println(
                        "Tree Deserialized Successfully"
                    );

                    System.out.println(
                        "Inorder: " +
                        sol.inorder(root)
                    );

                    break;

                // =================================================
                // 22. EXIT
                // =================================================

                case 22:

                    System.out.println(
                        "Program exited successfully."
                    );

                    break;

                // =================================================
                // INVALID
                // =================================================

                default:

                    System.out.println(
                        "Invalid choice! Try again."
                    );

                    break;
            }

        } while (choice != 22);

        sc.close();
    }
}
