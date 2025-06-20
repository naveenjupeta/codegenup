import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class ModeFinder {
    public static Set<Integer> findMode(int[] arr) {
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
            int val = nums.get(num);
            if (val > mode) {
                mode = val;
                n = new HashSet<>();
                n.add(num);
            } else if (val == mode &&!n.contains(num)) {
                n.add(num);
            }
        }

        return n;
    }