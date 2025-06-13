 2. The function `get_max_profit_optimized` also takes a list of prices and returns the maximum profit that can be made by buying and selling stock within that day.
 3. Both functions use a double for-loop to iterate over the prices and find the maximum profit.
 4. The function `get_max_profit` has a runtime of O(n^2) and a spacetime of O(n), where n is the length of the prices list.
 5. The function `get_max_profit_optimized` has a runtime of O(n) and a spacetime of O(1).
 6. Both functions have doctests to verify their correctness.

Here is the Java equivalent of the Python code:

```java
public static int get_max_profit(int[] prices) {
    int max_profit = prices[1] - prices[0];

    for (int a = 0; a < prices.length; a++) {