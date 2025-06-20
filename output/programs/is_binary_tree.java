import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class BinarySearchTree {
    Node root;

    BinarySearchTree(Node root) {
        this.root = root;
    }

    boolean isBST(Node root, Integer smallest, Integer largest) {
        if (root == null) {
            return true;
        }

        if (largest!= null && root.data > largest) {
            return false;
        }

        if (smallest!= null && root.data < smallest) {
            return false;
        }

        if (!isBST(root.left, smallest, root.data)) {
            return false;
        }

        if (!isBST(root.right, root.data, largest)) {
            return false;
        }

        return true;
    }

    boolean isBST() {
        return isBST(root, null, null);
    }
}

public class Tests {

    BinarySearchTree createBST1() {
        Node root = new Node(5, new Node(3, new Node(1), new Node(9)), new Node(6));
        return new BinarySearchTree(root);
    }

    BinarySearchTree createBST2() {
        Node root = new Node(5, new Node(3, new Node(1), new Node(4)), new Node(7, new Node(6), new Node(8)));
        return new BinarySearchTree(root);
    }

    @Test
    public void testIsBST() {
        BinarySearchTree bst1 = createBST1();
        BinarySearchTree bst2 = createBST2();

        assertFalse(bst1.isBST());
        assertTrue(bst2.isBST());
    }