import java.util.ArrayList;
import java.util.List;

public class ProductOfIntegers {
    public static List<Integer> getProductsOfAllIntsExceptAtIndex(List<Integer> input) {
        List<Integer> products = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            int product = 1;

            for (int j = 0; j < input.size(); j++) {
                if (j!= i) {
                    product *= input.get(j);
                }
            }

            products.add(product);
        }

        return products;
    }

    public static List<Integer> getProductsOfAllIntsExceptAtIndexOptimized(List<Integer> input) {
        List<Integer> products = new ArrayList<>();
        int product = 1;
        int productReverse = 1;
        List<Integer> productsBefore = new ArrayList<>();
        List<Integer> productsAfter = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            productsBefore.add(product);
            product *= input.get(i);
        }

        for (int i = input.size() - 1; i >= 0; i--) {
            productsAfter.add(productReverse);
            productReverse *= input.get(i);
        }

        for (int i = 0; i < productsBefore.size(); i++) {
            products.add(productsAfter.get(productsAfter.size() - i - 1) * productsBefore.get(i));
        }

        return products;
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(7);
        input.add(3);
        input.add(4);

        List<Integer> expected = new ArrayList<>();
        expected.add(84);
        expected.add(12);
        expected.add(28);
        expected.add(21);

        List<Integer> actual = getProductsOfAllIntsExceptAtIndex(input);
        assert expected.equals(actual);

        actual = getProductsOfAllIntsExceptAtIndexOptimized(input);
        assert expected.equals(actual);
    }