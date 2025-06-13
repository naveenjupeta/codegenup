
```java
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class TaskHandler {
    private Map<String, Integer> taskList;
    private Map<String, List<String>> taskOrder;

    public TaskHandler() {
        taskList = new HashMap<String, Integer>();
        taskOrder = new HashMap<String, List<String>>();

        // Define task order here
        taskOrder.put("RE-FUELING SHIP", List.of("SHIP DOCKING"));
        taskOrder.put("UNLOADING VESSEL", List.of("SHIP DOCKING"));
        taskOrder.put("TRUCK LOADING CONTAINER", List.of("UNLOADING VESSEL"));
        taskOrder.put("CUSTOMS CHECK", List.of("TRUCK LOADING CONTAINER"));
    }

    public int tasksRemaining() {
        int total = 0;
        for (int count : taskList.values()) {
            total += count;
        }
        return total;
    }
