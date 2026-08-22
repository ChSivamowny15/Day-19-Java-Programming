class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class Postorder {
    static void postorder(Node root) {
        if (root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
}
