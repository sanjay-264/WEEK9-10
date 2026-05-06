import java.util.Scanner;

public class level1question3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = scanner.next();

        char[] charactersFromUserMethod = getCharactersWithoutToCharArray(text);
        char[] charactersFromBuiltIn = text.toCharArray();

        boolean arraysAreEqual = areCharArraysEqual(charactersFromUserMethod, charactersFromBuiltIn);

        System.out.println("Characters from user method: " + formatCharArray(charactersFromUserMethod));
        System.out.println("Characters from toCharArray(): " + formatCharArray(charactersFromBuiltIn));
        System.out.println("Do both character arrays match? " + arraysAreEqual);

        scanner.close();
    }

    private static char[] getCharactersWithoutToCharArray(String text) {
        char[] result = new char[text.length()];
        for (int index = 0; index < text.length(); index++) {
            result[index] = text.charAt(index);
        }
        return result;
    }

    private static boolean areCharArraysEqual(char[] first, char[] second) {
        if (first == null || second == null) {
            return first == second;
        }

        if (first.length != second.length) {
            return false;
        }

        for (int index = 0; index < first.length; index++) {
            if (first[index] != second[index]) {
                return false;
            }
        }
        return true;
    }

    private static String formatCharArray(char[] chars) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");

        for (int i = 0; i < chars.length; i++) {
            builder.append(chars[i]);
            if (i < chars.length - 1) {
                builder.append(", ");
            }
        }

        builder.append("]");
        return builder.toString();
    }
}
