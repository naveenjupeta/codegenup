
```java
public class Stack {
    private LinkedList<Object> items;
    private LinkedList<Object> minStack;

    public Stack() {
        this.items = new LinkedList<Object>();
        this.minStack = new LinkedList<Object>();
    }

    @Override
    public String toString() {
        if (this.items.isEmpty()) {
            return "<Stack (empty)>";
        } else {
            return "<Stack tail=" + this.items.getLast() + ", length=" + this.items.size() + ">";
        }
    }

    public void push(Object item) {
        this.items.add(item);

        if (this.minStack.isEmpty() || (int) this.minStack.getLast() > (int) item) {
            this.minStack.add(item);
        } else {
            this.minStack.add(this.minStack.getLast());
        }
    }

    public Object pop() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException("pop from empty list");
        }

        this.minStack.removeLast();

        return this.items.removeLast();
    }
