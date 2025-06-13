  ```java
  import java.util.Map;
  import java.util.HashMap;
  import java.util.List;
  import java.util.ArrayList;
  import java.util.Collections;

  public class MostFrequentWord {
      public static void mostFrequentWord(String str) {
          Map<String, Integer> words = new HashMap<String, Integer>();
          List<String> list_of_words = new ArrayList<String>(str.split(" "));

          for (String word : list_of_words) {
              words.put(word, words.getOrDefault(word, 0) + 1);
          }

          List<String> mostFrequentWords = new ArrayList<String>();

          int max_value = Collections.max(words.values());

          for (Map.Entry<String, Integer> entry : words.entrySet()) {
              if (entry.getValue() == max_value) {
                  mostFrequentWords.add(entry.getKey());
              }
          }

          Collections.sort(mostFrequentWords);

          for (String word : mostFrequentWords) {