public class Decode {
    public static String decode(String s) {
        String decoded = "";

        for (int i = 0; i < s.length(); i++) {
            try {
                if (Character.isDigit(s.charAt(i))) {
                    int skip = Integer.parseInt(s.substring(i, i + 1));
                    decoded += s.charAt(skip + i + 1);
                }
            } catch (Exception e) {
                continue;
            }
        }

        return decoded;
    }

    public static String decodeRecursive(String s) {
        return decodeRecursiveHelper(s, "", 0);
    }

    private static String decodeRecursiveHelper(String s, String decoded, int i) {
        if (i >= s.length()) {
            return decoded;
        }

        if (Character.isDigit(s.charAt(i))) {
            int skip = Integer.parseInt(s.substring(i, i + 1));
            decoded += s.charAt(skip + i + 1);
        }

        return decodeRecursiveHelper(s, decoded, i + 1);
    }