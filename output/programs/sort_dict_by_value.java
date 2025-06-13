 2. You can use the appropriate Java constructs to achieve the same result as the Python code.
 3. You can use the Java API to perform operations such as sorting and printing.
 4. You can use the Java equivalents of Python built-in functions and data structures.

Here is how you can convert the Python code to Java:

```java
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Comparator;

public class ConvertPythonToJava {
    public static void main(String[] args) {
        Map<String, Integer> data = new HashMap<>();
        data.put("one", 1);
        data.put("two", 2);
        data.put("four", 4);
        data.put("three", 3);

        Map<String, Integer> sortedMap = new LinkedHashMap<>(data);
        sortedMap.entrySet().stream()
               .sorted(Map.Entry.comparingByValue())