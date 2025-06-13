
```java
public class Node {
    Object data;
    Node next;

    public Node(Object data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    Node head;
    Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insert(Object data, int position) {
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

    public int size() {
        int size = 0;
        Node curr = head;
