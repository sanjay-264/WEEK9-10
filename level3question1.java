import java.util.Scanner;

public class level3question1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = scanner.next();

        char[] uniqueCharacters = findUniqueCharactersUsingCharAt(text);

        System.out.println("Unique characters: " + formatCharArray(uniqueCharacters));

        scanner.close();
    }

    private static int findStringLengthWithoutLengthMethod(String text) {
        int count = 0;
        while (true) {
            try {
                text.charAt(count);
                count++;
            } catch (StringIndexOutOfBoundsException exception) {
                return count;
            }
        }
    }

    private static char[] findUniqueCharactersUsingCharAt(String text) {
        int textLength = findStringLengthWithoutLengthMethod(text);

        char[] tempUnique = new char[textLength];
        int uniqueCount = 0;

        for (int i = 0; i < textLength; i++) {
            char current = text.charAt(i);

            boolean isUniqueSoFar = true;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == current) {
                    isUniqueSoFar = false;
                    break;
                }
            }

            if (isUniqueSoFar) {
                tempUnique[uniqueCount] = current;
                uniqueCount++;
            }
        }

        char[] uniqueCharacters = new char[uniqueCount];
        for (int k = 0; k < uniqueCount; k++) {
            uniqueCharacters[k] = tempUnique[k];
        }

        return uniqueCharacters;
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
