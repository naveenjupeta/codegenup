import java.util.List;

public class HighestProductOfThree {
    public static int highestProductOfThree(List<Integer> list) {
        if (list.size() < 3) {
            throw new IllegalArgumentException("List must have at least 3 integers");
        }

        int highestProduct = list.get(0) * list.get(1) * list.get(2);
        int highest = list.get(0);
        int lowest = list.get(0);
        int highestTwo = list.get(0) * list.get(1);
        int lowestTwo = list.get(0) * list.get(1);

        for (int i = 2; i < list.size() - 1; i++) {
            int product = list.get(i) * list.get(i + 1);
            int currentNum = list.get(i);

            if (currentNum > highest) {
                highest = currentNum;
                if (product > highestTwo) {
                    highestTwo = product;
                }
            } else if (currentNum < lowest) {
                lowest = currentNum;
                if (product < lowestTwo) {
                    lowestTwo = product;
                }
            }
        }

        if (highestTwo * highest > lowestTwo * lowest) {
            highestProduct = highestTwo * highest;
        } else if (highestTwo * highest < lowestTwo * lowest) {
            highestProduct = lowestTwo * lowest;
        } else if (highestTwo * lowest < lowestTwo * highest) {
            highestProduct = lowestTwo * highest;
        } else {
            highestProduct = highestTwo * lowest;
        }

        return highestProduct;
    }