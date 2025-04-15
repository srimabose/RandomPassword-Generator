import java.util.Scanner;
import java.util.Random;

public class PasswordGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Character sets
        String numbers = "0123456789";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialChars = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/`~";

        // User input
        System.out.print("Enter desired password length: ");
        int length = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Include numbers? (yes/no): ");
        boolean includeNumbers = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Include lowercase letters? (yes/no): ");
        boolean includeLower = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Include uppercase letters? (yes/no): ");
        boolean includeUpper = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Include special characters? (yes/no): ");
        boolean includeSpecial = scanner.nextLine().equalsIgnoreCase("yes");

        String allowedChars = "";
        if (includeNumbers) allowedChars += numbers;
        if (includeLower) allowedChars += lowercase;
        if (includeUpper) allowedChars += uppercase;
        if (includeSpecial) allowedChars += specialChars;

        if (allowedChars.isEmpty()) {
            System.out.println("You must select at least one character type!");
        } else {
            String password = generatePassword(length, allowedChars);
            System.out.println("Generated Password: " + password);
        }

        scanner.close();
    }

    public static String generatePassword(int length, String allowedChars) {
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(allowedChars.length());
            password.append(allowedChars.charAt(index));
        }

        return password.toString();
    }
}
