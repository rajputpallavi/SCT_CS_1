import java.util.Scanner;

public class CipherShift {
    public static String caesarCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                char ch = (char)(((c - 'A' + shift + 26) % 26) + 'A');
                result.append(ch);
            } else if (Character.isLowerCase(c)) {
                char ch = (char)(((c - 'a' + shift + 26) % 26) + 'a');
                result.append(ch);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("==================================");
        System.out.println("     Welcome to CipherShift!       ");
        System.out.println("   The Caesar Cipher Encryption   ");
        System.out.println("==================================\n");

        while (running) {
            System.out.println("Choose an option:");
            System.out.println("1. Encrypt text");
            System.out.println("2. Decrypt text");
            System.out.println("3. Exit");
            System.out.print("Enter choice (1-3): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                case 2:
                    System.out.print("\nEnter your message: ");
                    String message = scanner.nextLine();

                    System.out.print("Enter shift value (e.g. 3): ");
                    int shift = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    if (choice == 2) shift = -shift;

                    String result = caesarCipher(message, shift);
                    System.out.println("\nResult:");
                    System.out.println("-------------------------------");
                    System.out.println(result);
                    System.out.println("-------------------------------\n");
                    break;

                case 3:
                    running = false;
                    System.out.println("\nExiting CipherShift. Thank you!");
                    break;

                default:
                    System.out.println("\nInvalid choice! Please select 1, 2, or 3.\n");
            }
        }

        scanner.close();
    }
}
