public class BinarySearch {
    public static int binarySearch(int val) {
        assert 0 < val && val < 101 : "Val must be between 1-100";

        int numGuesses = 0;
        int guess = 0;
        int low = 0;
        int high = 101;

        while (guess!= val) {
            numGuesses++;
            guess = (high - low) / 2 + low;

            if (guess > val) {
                high = guess;
            } else if (guess < val) {
                low = guess;
            }
        }

        return numGuesses;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(50));
        System.out.println(binarySearch(25));
        System.out.println(binarySearch(75));
        System.out.println(binarySearch(31) <= 7);
        System.out.println(max(binarySearch(i) for i in range(1, 101)) <= 7);
    }