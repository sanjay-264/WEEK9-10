import java.util.Scanner;

public class level2question2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a line of text: ");
        String text = scanner.nextLine();

        String[] wordsUsingUserMethod = splitTextIntoWordsUsingCharAt(text);
        String[] wordsUsingBuiltIn = text.trim().isEmpty() ? new String[0] : text.trim().split("\\s+");

        boolean arraysMatch = areStringArraysEqual(wordsUsingUserMethod, wordsUsingBuiltIn);

        System.out.println("Words (user method): " + formatStringArray(wordsUsingUserMethod));
        System.out.println("Words (split method): " + formatStringArray(wordsUsingBuiltIn));
        System.out.println("Do both results match? " + arraysMatch);

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

    private static String[] splitTextIntoWordsUsingCharAt(String text) {
        String trimmedText = text.trim();
        if (trimmedText.isEmpty()) {
            return new String[0];
        }

        int textLength = findStringLengthWithoutLengthMethod(trimmedText);

        int[] spaceIndexes = new int[textLength];
        int spaceCount = 0;
        boolean previousWasSpace = false;

        for (int i = 0; i < textLength; i++) {
            char current = trimmedText.charAt(i);
            boolean currentIsSpace = (current == ' ');

            if (currentIsSpace && !previousWasSpace) {
                spaceIndexes[spaceCount] = i;
                spaceCount++;
            }
            previousWasSpace = currentIsSpace;
        }

        int wordCount = spaceCount + 1;
        String[] words = new String[wordCount];

        int wordStart = 0;
        int wordIndex = 0;

        for (int s = 0; s < spaceCount; s++) {
            int spaceIndex = spaceIndexes[s];

            if (spaceIndex > wordStart) {
                words[wordIndex] = buildSubstringUsingCharAt(trimmedText, wordStart, spaceIndex);
                wordIndex++;
            }

            int nextStart = spaceIndex + 1;
            while (nextStart < textLength && trimmedText.charAt(nextStart) == ' ') {
                nextStart++;
            }
            wordStart = nextStart;
        }

        if (wordIndex < wordCount) {
            words[wordIndex] = buildSubstringUsingCharAt(trimmedText, wordStart, textLength);
        }

        return compactNonNullWords(words);
    }

    private static String buildSubstringUsingCharAt(String text, int startIndex, int endIndex) {
        StringBuilder builder = new StringBuilder();
        for (int i = startIndex; i < endIndex; i++) {
            builder.append(text.charAt(i));
        }
        return builder.toString();
    }

    private static String[] compactNonNullWords(String[] words) {
        int count = 0;
        for (String w : words) {
            if (w != null && !w.isEmpty()) {
                count++;
            }
        }

        String[] result = new String[count];
        int index = 0;
        for (String w : words) {
            if (w != null && !w.isEmpty()) {
                result[index] = w;
                index++;
            }
        }
        return result;
    }

    private static boolean areStringArraysEqual(String[] a, String[] b) {
        if (a == null || b == null) {
            return a == b;
        }
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) {
                return false;
            }
        }
        return true;
    }

    private static String formatStringArray(String[] items) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");

        for (int i = 0; i < items.length; i++) {
            builder.append(items[i]);
            if (i < items.length - 1) {
                builder.append(", ");
            }
        }

        builder.append("]");
        return builder.toString();
    }
}
