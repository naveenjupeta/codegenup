public class Queue {
    private LinkedList<String> items;

    public Queue() {
        this.items = new LinkedList<String>();
    }

    @Override
    public String toString() {
        if (this.items.isEmpty()) {
            return "<Queue (empty)>";
        } else {
            return "<Queue " + this.items + ">";
        }
    }

    public int length() {
        return this.items.size();
    }

    public String dequeue() {
        if (this.items.isEmpty()) {
            throw new IndexOutOfBoundsException("Queue is empty.");
        } else {
            return this.items.removeFirst();
        }
    }

    public void enqueue(String item) {
        this.items.addLast(item);
    }

    public boolean is_empty() {
        return this.items.isEmpty();
    }

    public String peek() {
        return this.items.getFirst();
    }