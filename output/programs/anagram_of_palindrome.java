public class AnagramOfPalindrome {
    public static boolean isAnagramOfPalindrome(String word) {
        int[] letterCounts = new int[26];
        for (char letter : word.toCharArray()) {
            letterCounts[letter - 'a']++;
        }
        int oddCount = 0;
        for (int count : letterCounts) {
            if (count % 2!= 0) {
                oddCount++;
            }
        }
        return oddCount <= 1;
    }

    public static void main(String[] args) {
        System.out.println(isAnagramOfPalindrome("a"));
        System.out.println(isAnagramOfPalindrome("ab"));
        System.out.println(isAnagramOfPalindrome("aab"));
        System.out.println(isAnagramOfPalindrome("arceace"));
        System.out.println(isAnagramOfPalindrome("arceaceb"));
    }