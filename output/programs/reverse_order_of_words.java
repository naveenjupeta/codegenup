public static List<Character> reverseOrderOfWords(List<Character> lst) {
    String words = String.join("", lst);
    String[] wordsArray = words.split(" ");
    List<String> reversedArray = new ArrayList<>();
    for (int i = wordsArray.length - 1; i >= 0; i--) {
        reversedArray.add(wordsArray[i]);
    }
    String reversedWords = String.join(" ", reversedArray);
    return new ArrayList<>(reversedWords.chars().mapToObj(c -> (char) c));