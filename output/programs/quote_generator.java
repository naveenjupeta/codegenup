import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class QuoteGenerator {

    private int lastRandomNumber;
    private List<String> quotes;
    private Random randomGenerator;

    public QuoteGenerator(List<String> quotes) {
        this.lastRandomNumber = -1;
        this.quotes = quotes;
        this.randomGenerator = new Random();
    }

    public String generateQuote() {
        int randomNumber = this.randomGenerator.nextInt(this.quotes.size());

        if (randomNumber!= this.lastRandomNumber) {
            this.lastRandomNumber = randomNumber;
            return this.quotes.get(randomNumber);
        } else {
            return generateQuote();
        }
    }