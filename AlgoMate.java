import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlgoMate {
    private static List<String> history = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n**************************************");
            System.out.println("*                                      *");
            System.out.println("*             A l g o M a t e          *");
            System.out.println("*                                      *");
            System.out.println("****************************************");
            System.out.println("*                                      *");
            System.out.println("*  1. Normal Calculation               *");
            System.out.println("*  2. Scientific Calculation           *");
            System.out.println("*  3. View History                     *");
            System.out.println("*  4. Exit                             *");
            System.out.println("*                                      *");
            System.out.println("****************************************");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                normalCalculation(scanner);
            } else if (choice == 2) {
                scientificCalculation(scanner);
            } else if (choice == 3) {
                viewHistory();
            } else if (choice == 4) {
                System.out.println("Exiting AlgoMate. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }

    public static void normalCalculation(Scanner scanner) {
        while (true) {
            System.out.println("\n**************************************");
            System.out.println("*       Normal Calculation            *");
            System.out.println("****************************************");
            System.out.println("*  Select an operation:               *");
            System.out.println("*  1. Addition (+)                    *");
            System.out.println("*  2. Subtraction (-)                 *");
            System.out.println("*  3. Multiplication (*)              *");
            System.out.println("*  4. Division (/)                    *");
            System.out.println("*  5. Exit to Main Menu               *");
            System.out.println("****************************************");
            System.out.print("Select an operation: ");

            int operation = scanner.nextInt();
            if (operation == 5) {
                break;
            }

            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();
            double result = 0;
            String historyEntry = "";

            switch (operation) {
                case 1: result = num1 + num2; historyEntry = num1 + " + " + num2 + " = " + result; break;
                case 2: result = num1 - num2; historyEntry = num1 + " - " + num2 + " = " + result; break;
                case 3: result = num1 * num2; historyEntry = num1 + " * " + num2 + " = " + result; break;
                case 4: 
                    if (num2 == 0) {
                        System.out.println("Cannot divide by zero. Try again.");
                        continue;
                    }
                    result = num1 / num2;
                    historyEntry = num1 + " / " + num2 + " = " + result;
                    break;
                default: 
                    System.out.println("Invalid operation. Try again.");
                    continue;
            }
            history.add(historyEntry);
            System.out.println("Result: " + result);
        }
    }

    public static void scientificCalculation(Scanner scanner) {
        while (true) {
            System.out.println("\n**************************************");
            System.out.println("*      Scientific Calculation         *");
            System.out.println("****************************************");
            System.out.println("*  Select an operation:               *");
            System.out.println("*  1. Trigonometry (sin, cos, tan)    *");
            System.out.println("*  2. Inverse Trigonometry            *");
            System.out.println("*  3. Exponential (x^y)               *");
            System.out.println("*  4. Square Root                     *");
            System.out.println("*  5. Logarithm                        *");
            System.out.println("*  6. Factorial                        *");
            System.out.println("*  7. Exit to Main Menu               *");
            System.out.println("****************************************");
            System.out.print("Select an operation: ");

            int operation = scanner.nextInt();
            if (operation == 7) {
                break;
            }

            System.out.print("Enter a number: ");
            double num = scanner.nextDouble();
            double result = 0;
            String historyEntry = "";

            switch (operation) {
                case 1: result = Math.sin(num); historyEntry = "sin(" + num + ") = " + result; break;
                case 2: result = Math.asin(num); historyEntry = "asin(" + num + ") = " + result; break;
                case 3: 
                    System.out.print("Enter exponent: ");
                    double exponent = scanner.nextDouble();
                    result = Math.pow(num, exponent);
                    historyEntry = num + "^" + exponent + " = " + result;
                    break;
                case 4: result = Math.sqrt(num); historyEntry = "sqrt(" + num + ") = " + result; break;
                case 5: result = Math.log(num); historyEntry = "log(" + num + ") = " + result; break;
                case 6: 
                    result = 1;
                    for (int i = 1; i <= num; i++) {
                        result *= i;
                    }
                    historyEntry = "factorial(" + num + ") = " + result;
                    break;
                default: System.out.println("Invalid operation. Try again."); continue;
            }
            history.add(historyEntry);
            System.out.println("Result: " + result);
        }
    }

    public static void viewHistory() {
        System.out.println("\n******** Calculation History ********");
        if (history.isEmpty()) {
            System.out.println("No calculations performed yet.");
        } else {
            for (String entry : history) {
                System.out.println(entry);
            }
        }
        System.out.println("************************************");
    }
}
