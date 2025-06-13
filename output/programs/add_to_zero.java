public class AddToZero {
    public static boolean addToZero(int[] nums) {
        if (nums.length < 2) {
            return false;
        }

        java.util.Set<Integer> numSet = new java.util.HashSet<>(nums.length);

        for (int num : nums) {
            numSet.add(num);
        }

        for (int num : nums) {
            if (numSet.contains(-num)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(addToZero(new int[]{}));
        System.out.println(addToZero(new int[]{1}));
        System.out.println(addToZero(new int[]{1, 2, 3}));
        System.out.println(addToZero(new int[]{1, 2, 3, -2}));
    }