
Here is how you could convert the given Python code into Java code:

```java
public class HighestProductOfThree {
    public static int highestProductOfThree(int[] listOfInts) {
        if (listOfInts.length < 3) {
            throw new IllegalArgumentException("Input list must have at least three integers");
        }

        int highestProduct = listOfInts[0] * listOfInts[1] * listOfInts[2];
        int highest = listOfInts[0];
        int lowest = listOfInts[0];
        int highestTwo = listOfInts[0] * listOfInts[1];
        int lowestTwo = listOfInts[0] * listOfInts[1];

        for (int i = 2; i < listOfInts.length - 1; i++) {
            int product = listOfInts[i] * listOfInts[i + 1];
            int currentNum = listOfInts[i];

            if (currentNum > highest) {