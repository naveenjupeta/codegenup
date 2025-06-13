 2. Declare the necessary Java classes and methods to match the Python code.
 3. Translate the Python code into Java code by replacing Python functions and methods with their Java equivalents.
 4. Handle any differences in the way Java and Python handle data types, such as string formatting and integer division.
 5. Test the Java code to ensure that it produces the same output as the Python code.

```java
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class QuoteGenerator {
    private Random random;
    private List<String> quotes;
    private int lastRandomNumber;

    public QuoteGenerator(List<String> quotes) {
        this.random = new Random();
        this.quotes = quotes;
        this.lastRandomNumber = -1;
    }

    public String generateQuote() {
        int randomNumber = random.nextInt(quotes.size());
        if (randomNumber!= lastRandomNumber) {
            lastRandomNumber = randomNumber;
            return quotes.get(randomNumber);
        } else {
            return generateQuote();