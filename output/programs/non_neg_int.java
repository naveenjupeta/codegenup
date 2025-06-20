import java.util.HashSet;
import java.util.Set;

public class FindMissingInteger {
    public static int findMissingInteger(int[] arr) {
        Set<Integer> arrSet = new HashSet<Integer>();

        for (int i = 0; i < arr.length; i++) {
            arrSet.add(arr[i]);
        }

        for (int i = 0; i <= arr.length; i++) {
            if (!arrSet.contains(i)) {
                return i;
            }
        }

        return -1;
    }