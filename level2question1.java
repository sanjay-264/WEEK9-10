import java.util.Scanner;

public class level2question1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = scanner.next();

        int lengthWithoutBuiltIn = findStringLengthWithoutLengthMethod(text);
        int lengthUsingBuiltIn = text.length();

        System.out.println("Length without length(): " + lengthWithoutBuiltIn);
        System.out.println("Length using length(): " + lengthUsingBuiltIn);
        System.out.println("Do both results match? " + (lengthWithoutBuiltIn == lengthUsingBuiltIn));

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
}
