  import org.junit.Test;
  import static org.junit.Assert.assertTrue;
  import static org.junit.Assert.assertFalse;

  public class BalancedBrackets {
      public static boolean hasBalancedBrackets(String phrase) {
          String brackets = "[]{}<>";
          String openBrackets = "[{<";
          String closeBrackets = "]}>";
          String seen = "";

          for (char let : phrase.toCharArray()) {
              if (openBrackets.indexOf(let)!= -1) {
                  seen += let;
              } else if (closeBrackets.indexOf(let)!= -1) {
                  if (seen.length() > 0 && brackets.indexOf(let) == brackets.indexOf(seen.charAt(seen.length() - 1))) {
                      seen = seen.substring(0, seen.length() - 1);
                  } else {
                      return false;
                  }
              }
          }
          return seen.length() == 0;
      }
  }