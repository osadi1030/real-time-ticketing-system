package ticketingsystem;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Utility {

    public static int getValidatedChoice(Scanner scanner, int maxOption) {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > maxOption) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.print("[ERROR] Please enter a valid option (1-" + maxOption + "): ");
            }
        }
        return choice;
    }

    public static String getValidatedInput(Scanner scanner, String prompt, String regex, String errorMessage) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine();
            if (Pattern.matches(regex, input)) {
                break;
            } else {
                System.out.println("[ERROR] " + errorMessage);
            }
        }
        return input;
    }
}
