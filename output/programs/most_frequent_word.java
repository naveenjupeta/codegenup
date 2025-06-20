import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class MostFrequentWord {
    public static void mostFrequentWord(String str) {
        Map<String, Integer> words = new HashMap<>();
        List<String> mostFrequentWords = new ArrayList<>();

        String[] list_of_words = str.split(" ");

        for (String word : list_of_words) {
            words.put(word, words.getOrDefault(word, 0) + 1);
        }

        int max_value = 0;

        for (Integer value : words.values()) {
            if (value > max_value) {
                max_value = value;
            }
        }

        for (String word : words.keySet()) {
            if (words.get(word) == max_value) {
                mostFrequentWords.add(word);
            }
        }

        Collections.sort(mostFrequentWords);

        for (String word : mostFrequentWords) {
            System.out.print(word + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        mostFrequentWord("hello my name is hello joanne");
        mostFrequentWord("hello my name is hello joanne is");
        mostFrequentWord("hello my name is joanne");
    }