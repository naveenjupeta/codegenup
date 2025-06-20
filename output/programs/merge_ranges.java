import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class MergeRanges {
    public static List<int[]> mergeRanges(List<int[]> meetingTimes) {
        Collections.sort(meetingTimes, (a, b) -> a[0] - b[0]);

        List<int[]> mergedRanges = new ArrayList<>();

        for (int[] meetingTime : meetingTimes) {
            int start = meetingTime[0];
            int end = meetingTime[1];

            if (mergedRanges.isEmpty() || mergedRanges.get(mergedRanges.size() - 1)[1] < start) {
                mergedRanges.add(new int[] {start, end});
            } else {
                mergedRanges.get(mergedRanges.size() - 1)[1] = Math.max(mergedRanges.get(mergedRanges.size() - 1)[1], end);
            }
        }

        return mergedRanges;
    }