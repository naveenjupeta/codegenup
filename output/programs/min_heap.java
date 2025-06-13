
```java
import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    private List<Integer> storage;

    public MinHeap() {
        storage = new ArrayList<>();
    }

    public void swap(int a, int b) {
        int temp = storage.get(a);
        storage.set(a, storage.get(b));
        storage.set(b, temp);
    }

    public int size() {
        return storage.size();
    }

    public int peak() {
        return storage.get(0);
    }

    public void insert(int value) {
        storage.add(value);
        int index = size() - 1;
        bubbleUp(index);
    }

    public int get_parent(int child) {
        if (child % 2 == 0) {
            return (child - 2) / 2;
        } else {
            return (child - 1) / 2;
        }
    }

    public void bubbleUp(int child) {
        int parent = get_parent(child);
