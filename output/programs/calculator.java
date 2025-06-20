  import java.util.Stack;

  public class EvaluateExpression {
      public static double evaluate(String expression) {
          expression = expression.replaceAll(" ", "");
          Stack<Character> operators = new Stack<Character>();
          Stack<Double> values = new Stack<Double>();
          for (int i = 0; i < expression.length(); i++) {
              char c = expression.charAt(i);
              if (c == '(') {
                  continue;
              } else if (c == ')') {
                  double value = values.pop();
                  values.push(applyOperator(values.pop(), operators.pop(), value));
              } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                  operators.push(c);
              } else {
                  values.push(Double.parseDouble(c + ""));
              }
          }
          return values.pop();
      }

      private static double applyOperator(double value1, char op, double value2) {
          switch (op) {
              case '+':
                  return value1 + value2;
              case '-':
                  return value1 - value2;
              case '*':
                  return value1 * value2;
              case '/':
                  return value1 / value2;
              default:
                  throw new IllegalArgumentException("Invalid operator: " + op);
          }
      }
  }