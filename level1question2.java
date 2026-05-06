import java.util.Scanner;

public class level1question2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = scanner.next();

        System.out.print("Enter start index (inclusive): ");
        int startIndex = readInt(scanner);

        System.out.print("Enter end index (exclusive): ");
        int endIndex = readInt(scanner);

        try {
            String substringUsingCharAt = createSubstringUsingCharAt(text, startIndex, endIndex);
            String substringUsingBuiltIn = text.substring(startIndex, endIndex);

            boolean substringsMatch = areStringsEqualUsingCharAt(substringUsingCharAt, substringUsingBuiltIn);

            System.out.println("Substring using charAt(): " + substringUsingCharAt);
            System.out.println("Substring using substring(): " + substringUsingBuiltIn);
            System.out.println("Are both substrings equal? " + substringsMatch);
        } catch (StringIndexOutOfBoundsException exception) {
            System.out.println("Error: Invalid indexes for the given string length.");
            System.out.println("String length = " + text.length() + ", start = " + startIndex + ", end = " + endIndex);
        }

        scanner.close();
    }

    private static String createSubstringUsingCharAt(String text, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            throw new StringIndexOutOfBoundsException("startIndex cannot be greater than endIndex");
        }

        StringBuilder substringBuilder = new StringBuilder();
        for (int index = startIndex; index < endIndex; index++) {
            substringBuilder.append(text.charAt(index));
        }
        return substringBuilder.toString();
    }

    private static boolean areStringsEqualUsingCharAt(String first, String second) {
        if (first == null || second == null) {
            return first == second;
        }

        if (first.length() != second.length()) {
            return false;
        }

        for (int index = 0; index < first.length(); index++) {
            if (first.charAt(index) != second.charAt(index)) {
                return false;
            }
        }
        return true;
    }

    private static int readInt(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.next());
            } catch (NumberFormatException exception) {
                System.out.print("Invalid number. Enter an integer again: ");
            }
        }
    }
}
