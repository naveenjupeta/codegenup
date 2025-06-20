public class Node {
    private Object data;
    private Node next;

    public Node(Object data) {
        this.data = data;
        this.next = null;
    }
}

public class Queue {
    private Node head;
    private Node tail;

    public Queue() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "<Queue (empty)>";
        } else {
            return "<Queue " + head + ">";
        }
    }

    public int length() {
        Node curr = head;
        int length = 0;

        while (curr!= null) {
            length++;
            curr = curr.next;
        }

        return length;
    }

    public void enqueue(Object item) {
        Node new_node = new Node(item);

        if (head == null && tail == null) {
            head = new_node;
            tail = new_node;
        } else {
            tail.next = new_node;
            tail = new_node;
        }
    }

    public Object dequeue() {
        if (head == null) {
            return null;
        } else {
            Object dequeued = head.data;
            head = head.next;
            return dequeued;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Object peek() {
        return head.data;
    }

    public void printQueue() {
        Node curr = head;

        if (curr == null) {
            System.out.println("[]");
        } else {
            System.out.print("[");
            while (curr!= null) {
                System.out.print(curr.data);
                curr = curr.next;
                if (curr!= null) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }