public class CountRecursively {
  public static int countRecursively(List<Object> lst) {
    if (lst.isEmpty()) {
      return 0;
    }

    return 1 + countRecursively(lst.subList(1, lst.size()));
  }

  public static void main(String[] args) {
    List<Object> lst1 = new ArrayList<>();
    List<Object> lst2 = new ArrayList<>(Arrays.asList(1, 2, 3));

    System.out.println(countRecursively(lst1));
    System.out.println(countRecursively(lst2));
  }