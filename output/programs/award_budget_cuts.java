  import java.util.Arrays;

  public class AwardBudgetCuts {
      public static double findGrantCap(double[] grantsArray, double newBudget) {
          Arrays.sort(grantsArray);
          int i = grantsArray.length - 1;
          boolean flag = false;
          double cap = newBudget / grantsArray.length;
          newBudget = newBudget;

          while (!flag) {
              while (cap > grantsArray[i]) {
                  newBudget -= grantsArray[i];
                  i--;
              }

              double newCap = newBudget / (i + 1);

              if (cap == newCap) {
                  flag = true;
              } else {
                  cap = newCap;
              }
          }

          return cap;
      }
  }