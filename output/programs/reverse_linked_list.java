class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    String asString() {
        StringBuilder sb = new StringBuilder();
        Node n = this;

        while (n!= null) {
            sb.append(n.data);
            n = n.next;
        }

        return sb.toString();
    }
}

Node reverseLinkedList(Node head) {
    Node prev = null;
    Node curr = head;

    while (curr!= null) {
        Node next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }

    return prev;