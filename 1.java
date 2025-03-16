import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlgoMate {
    // List to store the calculation history so that past results can be viewed later.
    private static List<String> history = new ArrayList<>();
    
    // ANSI constants for colored output in the terminal.
    private static final String ANSI_RESET = "\u001B[0m"; // Resets text color
    private static final String ANSI_CYAN = "\u001B[36m"; // Cyan color for UI elements

    // The main method that runs when the program starts.
    public static void main(String[] args) {
        // Scanner reads input from the user via the terminal.
        Scanner scanner = new Scanner(System.in);
        
        // Show welcome screen when the program starts.
        displayWelcomeScreen();
        
        // Main loop that keeps the program running until the user chooses to exit.
        while (true) {
            // Display the main menu options.
            printMainMenu();
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            // Depending on the user's input, the program calls different methods.
            if (choice == 1) {
                normalCalculation(scanner);
            } else if (choice == 2) {
                scientificCalculation(scanner);
            } else if (choice == 3) {
                viewHistory();
            } else if (choice == 4) {
                System.out.println("\nExiting AlgoMate. Goodbye!");
                break;
            } else {
                System.out.println("\n[!] Invalid choice. Try again.");
            }
        }
        // Close the scanner when done to free up resources.
        scanner.close();
    }
    
    // This method prints a boxed message; it uses Unicode box-drawing characters.
    // title: the header of the box; lines: the text inside the box.
    private static void printBox(String title, String[] lines) {
        int width = 50; // Defines the width of the box.
        // Repeat the box-drawing character to create the top and bottom borders.
        String horizontal = "═".repeat(width);
        // Create the title line, centered within a box.
        String titleLine = "║" + centerText(title, width) + "║";
        System.out.println("╔" + horizontal + "╗"); // Top border
        System.out.println(titleLine);              // Title line
        System.out.println("╟" + horizontal + "╢"); // Separator between title and contents
        // Loop through each line in the text array and print it centered.
        for (String line : lines) {
            System.out.println("║" + centerText(line, width) + "║");
        }
        System.out.println("╚" + horizontal + "╝"); // Bottom border
    }
    
    // A helper method that centers a given text within a specified width.
    private static String centerText(String text, int width) {
        // If the text is longer than the width, just return a shortened version.
        if (text.length() >= width) {
            return text.substring(0, width);
        }
        // Calculate how much space is needed on each side.
        int padding = (width - text.length()) / 2;
        int extra = (width - text.length()) % 2; // Adjust if width difference is odd.
        return " ".repeat(padding) + text + " ".repeat(padding + extra);
    }
    
    // Displays the welcome screen using a box style.
    private static void displayWelcomeScreen() {
        String title = "Welcome to AlgoMate!";
        String[] lines = {
            "Your Smart Calculation Partner",
            ""
        };
        System.out.println();
        printBox(title, lines); // Print the welcome message in a box.
        System.out.println();
    }
    
    // Displays the main menu with options for the user.
    private static void printMainMenu() {
        String title = "A l g o M a t e";
        String[] lines = {
            "1. Normal Calculation",
            "2. Scientific Calculation",
            "3. View History",
            "4. Exit"
        };
        System.out.println();
        printBox(title, lines); // Print the main menu inside a box.
        System.out.println();
    }
    
    // Provides a menu for normal (basic arithmetic) calculations.
    public static void normalCalculation(Scanner scanner) {
        while (true) {
            String title = "Normal Calculation";
            String[] lines = {
                "1. Addition (+)",
                "2. Subtraction (-)",
                "3. Multiplication (*)",
                "4. Division (/)",
                "5. Exit to Main Menu"
            };
            System.out.println();
            printBox(title, lines);
            System.out.print("Select an operation: ");
            int operation = scanner.nextInt();
            // Exit the loop if the user chooses to return to the main menu.
            if (operation == 5) {
                break;
            }
            // Ask the user to input two numbers.
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();
            double result = 0;
            String historyEntry = "";
            // Perform the selected operation and form a history entry string.
            switch (operation) {
                case 1: 
                    result = num1 + num2; 
                    historyEntry = num1 + " + " + num2 + " = " + result; 
                    break;
                case 2: 
                    result = num1 - num2; 
                    historyEntry = num1 + " - " + num2 + " = " + result; 
                    break;
                case 3: 
                    result = num1 * num2; 
                    historyEntry = num1 + " * " + num2 + " = " + result; 
                    break;
                case 4: 
                    // Check if the second number is zero to avoid division by zero.
                    if (num2 == 0) {
                        System.out.println("\n[!] Cannot divide by zero. Try again.\n");
                        continue;
                    }
                    result = num1 / num2;
                    historyEntry = num1 + " / " + num2 + " = " + result;
                    break;
                default: 
                    System.out.println("\n[!] Invalid operation. Try again.\n");
                    continue;
            }
            // Save the calculation result to history.
            history.add(historyEntry);
            System.out.println("\nResult: " + result + "\n");
        }
    }
    
    // Provides a menu for scientific calculations.
    // The actual calculation code for scientific operations should be added where indicated.
    public static void scientificCalculation(Scanner scanner) {
        while (true) {
            String title = "Scientific Calculation";
            String[] lines = {
                "1. Trigonometry (sin, cos, tan)",
                "2. Inverse Trigonometry",
                "3. Exponential (x^y)",
                "4. Square Root",
                "5. Logarithm",
                "6. Factorial",
                "7. Exit to Main Menu"
            };
            System.out.println();
            printBox(title, lines);
            System.out.print("Select an operation: ");
            int operation = scanner.nextInt();
            // Exit to main menu when option 7 is chosen.
            if (operation == 7) {
                break;
            }
            // ...existing code for scientific calculations...
            // Here you can add the logic for each scientific operation.
        }
    }
    
    // This method clears the terminal screen (works on Windows).
    private static void clearScreen() {
        try {
            // "cmd /c cls" runs the Windows command to clear the terminal.
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch(Exception e) {
            // If an error occurs, ignore it.
        }
    }

    // Displays the history of all calculations in a styled box.
    public static void viewHistory() {
        // Clear the screen so that the history display is clear.
        clearScreen();
        System.out.println();
        // Print the top border with ANSI coloring.
        System.out.println(ANSI_CYAN + "╔" + "═".repeat(50) + "╗" + ANSI_RESET);
        // Print the title of the history section.
        System.out.println(ANSI_CYAN + "║" + centerText("Calculation History", 50) + "║" + ANSI_RESET);
        // Print a separator below the title.
        System.out.println(ANSI_CYAN + "╟" + "═".repeat(50) + "╢" + ANSI_RESET);
        
        // Check if the history is empty and inform the user.
        if (history.isEmpty()) {
            System.out.println(ANSI_CYAN + "║" + centerText("No calculations performed yet.", 50) + "║" + ANSI_RESET);
        } else {
            // Print each history entry in the same styled box.
            for (String entry : history) {
                System.out.println(ANSI_CYAN + "║" + centerText(entry, 50) + "║" + ANSI_RESET);
            }
        }
        // Print the bottom border.
        System.out.println(ANSI_CYAN + "╚" + "═".repeat(50) + "╝" + ANSI_RESET);
    }
}
