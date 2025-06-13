
1. Create a new Java class or modify an existing one.
2. Translate the Python code line-by-line into Java.
3. Handle any differences in syntax or libraries between Python and Java.
4. Test the converted code to ensure its functionality remains the same.

Here is an example of how you can convert the Python code to Java:

```java
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ModeFinder {
    public Set<Integer> findMode(int[] arr) {
        if (arr.length == 0) {
            return new HashSet<>();
        }
        if (arr.length == 1) {
            return new HashSet<>(arr[0]);
        }

        HashMap<Integer, Integer> nums = new HashMap<>();
        Integer mode = null;
        Set<Integer> n = new HashSet<>();

        for (int i : arr) {
            nums.put(i, nums.getOrDefault(i, 0) + 1);
        }

        for (int num : nums.keySet()) {