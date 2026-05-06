import java.util.Scanner;

public class level1question1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String firstString = scanner.next();

        System.out.print("Enter second string: ");
        String secondString = scanner.next();

        boolean equalUsingCharAt = areStringsEqualUsingCharAt(firstString, secondString);
        boolean equalUsingEquals = firstString.equals(secondString);

        System.out.println("Equal using charAt(): " + equalUsingCharAt);
        System.out.println("Equal using equals(): " + equalUsingEquals);
        System.out.println("Do both results match? " + (equalUsingCharAt == equalUsingEquals));

        scanner.close();
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
}
