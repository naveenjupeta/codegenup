public class Stack {
    private final List<Integer> items = new ArrayList<>();
    private final Stack<Integer> minStack = new Stack<>();

    @Override
    public String toString() {
        if (items.isEmpty()) {
            return "<Stack (empty)>";
        } else {
            return "<Stack tail=" + items.get(items.size() - 1) + ", length=" + items.size() + ">";
        }
    }

    public void push(int item) {
        items.add(item);
        if (minStack.isEmpty() || minStack.peek() > item) {
            minStack.push(item);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("pop from empty list");
        }
        minStack.pop();
        return items.remove(items.size() - 1);
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return!items.isEmpty();
            }

            @Override
            public Integer next() {
                if (hasNext()) {
                    return pop();
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }

    public int length() {
        return items.size();
    }

    public void empty() {
        items.clear();
        minStack.clear();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int findMin() {
        if (!isEmpty()) {
            return minStack.peek();
        } else {
            throw new EmptyStackException();
        }
    }