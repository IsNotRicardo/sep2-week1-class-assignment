import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        System.out.println("Select a language:");
        System.out.println("1. English");
        System.out.println("2. Finnish");
        System.out.println("3. Swedish");
        System.out.println("4. Japanese");

        System.out.print("\nEnter your choice: ");
        int choice = scanner.nextInt();

        Locale locale = switch (choice) {
            case 1 -> new Locale.Builder().setLanguage("en").setRegion("US").build();
            case 2 -> new Locale.Builder().setLanguage("fi").setRegion("FI").build();
            case 3 -> new Locale.Builder().setLanguage("sv").setRegion("SE").build();
            case 4 -> new Locale.Builder().setLanguage("ja").setRegion("JP").build();
            default -> {
                System.out.println("Invalid choice. Defaulting to English.");
                yield new Locale.Builder().setLanguage("en").setRegion("US").build();
            }
        };

        ResourceBundle messages;
        try {
            messages = ResourceBundle.getBundle("messages", locale);
        } catch (Exception e) {
            System.out.println("Invalid locale. Verify code! Defaulting to English.");
            messages = ResourceBundle.getBundle("messages", new Locale.Builder().setLanguage("en").setRegion("US").build());
        }

        System.out.print(messages.getString("PROMPT_NUMBER_OF_ITEMS") + ": ");
        int numberOfItems = scanner.nextInt();

        for (int i = 0; i < numberOfItems; i++) {
            System.out.print(messages.getString("PROMPT_ITEM_PRICE") + ": ");
            double unitPrice = scanner.nextDouble();
            System.out.print(messages.getString("PROMPT_ITEM_QUANTITY") + ": ");
            int quantity = scanner.nextInt();
            cart.addItem(unitPrice, quantity);
        }

        System.out.println(messages.getString("TOTAL_COST") + ": " + String.format("%.2f", cart.getTotalValue()));
    }
}
