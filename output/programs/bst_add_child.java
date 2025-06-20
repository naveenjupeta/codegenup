class Node {
    int data;
    Node left;
    Node right;

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Node(int data) {
        this(data, null, null);
    }

    public void insert(int new_data) {
        if (new_data < this.data) {
            if (this.left == null) {
                this.left = new Node(new_data);
            } else {
                this.left.insert(new_data);
            }
        } else {
            if (this.right == null) {
                this.right = new Node(new_data);
            } else {
                this.right.insert(new_data);
            }
        }
    }