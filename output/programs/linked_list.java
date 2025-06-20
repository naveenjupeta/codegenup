class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;
    Node tail;

    LinkedList() {
        this.head = null;
        this.tail = null;
    }

    void insert(int data, int position) {
        Node newNode = new Node(data);

        if (position == 0) {
            newNode.next = head;
            head = newNode;
        } else if (position == size()) {
            tail.next = newNode;
            tail = newNode;
        } else {
            Node prev = null;
            Node curr = head;
            int index = 0;

            while (curr!= null) {
                if (position == index) {
                    prev.next = newNode;
                    newNode.next = curr;
                    return;
                }
                index++;
                prev = curr;
                curr = curr.next;
            }
        }
    }

    int size() {
        int size = 0;
        Node curr = head;

        while (curr!= null) {
            size++;
            curr = curr.next;
        }

        return size;
    }

    Node search(int data) {
        Node curr = head;

        while (curr!= null) {
            if (curr.data == data) {
                return curr;
            }
            curr = curr.next;
        }

        throw new IllegalArgumentException("Data not in linked list.");
    }

    void delete(int data) {
        Node prev = null;
        Node curr = head;

        while (curr!= null) {
            if (curr.data == data) {
                if (curr == head) {
                    head = curr.next;
                } else {
                    prev.next = curr.next;
                }
            }
            prev = curr;
            curr = curr.next;
        }

        if (curr == null) {
            throw new IllegalArgumentException("Data not in linked list.");
        }
    }