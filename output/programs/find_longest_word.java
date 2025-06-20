import java.util.List;

public class LongestWord {
    public static int findLongestWord(List<String> words) {
        int longest = 0;

        for (String word : words) {
            longest = Math.max(word.length(), longest);
        }

        return longest;
    }

    public static void main(String[] args) {
        List<String> words = List.of("hi", "hello");
        System.out.println(findLongestWord(words));  // Output: 5

        List<String> words2 = List.of("Balloonicorn", "Hackbright");
        System.out.println(findLongestWord(words2));  // Output: 12
    }