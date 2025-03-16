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
            System.out.println("*  5. Logarithm                       *");
            System.out.println("*  6. Factorial                       *");
            System.out.println("*  7. Exit to Main Menu               *");
            System.out.println("****************************************");
            System.out.print("Select an operation: ");

            int operation = scanner.nextInt();
            if (operation == 7) {
                break;
            }
            
            // Operation for trigonometric functions
            if (operation == 1 || operation == 2) {
                System.out.println("Select a function:");
                System.out.println("1. sin");
                System.out.println("2. cos");
                System.out.println("3. tan");
                if (operation == 2) {
                    System.out.println("4. asin");
                    System.out.println("5. acos");
                    System.out.println("6. atan");
                }
                System.out.print("Select an option: ");
                int trigChoice = scanner.nextInt();
                System.out.print("Enter a number: ");
                double num = scanner.nextDouble();
                double result = 0;
                String historyEntry = "";
                
                switch (trigChoice) {
                    case 1: result = Math.sin(num); historyEntry = "sin(" + num + ") = " + result; break;
                    case 2: result = Math.cos(num); historyEntry = "cos(" + num + ") = " + result; break;
                    case 3: result = Math.tan(num); historyEntry = "tan(" + num + ") = " + result; break;
                    case 4: result = Math.asin(num); historyEntry = "asin(" + num + ") = " + result; break;
                    case 5: result = Math.acos(num); historyEntry = "acos(" + num + ") = " + result; break;
                    case 6: result = Math.atan(num); historyEntry = "atan(" + num + ") = " + result; break;
                    default: 
                        System.out.println("Invalid choice. Try again.");
                        continue;
                }
                history.add(historyEntry);
                System.out.println("Result: " + result);
                continue;
            }
            
            // Operation for exponential (x^y)
            else if (operation == 3) {
                System.out.print("Enter the base number: ");
                double base = scanner.nextDouble();
                System.out.print("Enter the exponent: ");
                double exponent = scanner.nextDouble();
                double result = Math.pow(base, exponent);
                String historyEntry = base + " ^ " + exponent + " = " + result;
                history.add(historyEntry);
                System.out.println("Result: " + result);
                continue;
            }
            
            // Operation for Square Root
            else if (operation == 4) {
                System.out.print("Enter the number to find the square root: ");
                double num = scanner.nextDouble();
                // Check if the number is negative.
                if (num < 0) {
                    System.out.println("Cannot compute square root of a negative number.");
                    continue;
                }
                double result = Math.sqrt(num);
                String historyEntry = "√" + num + " = " + result;
                history.add(historyEntry);
                System.out.println("Result: " + result);
                continue;
            }
            
            // Operation for Logarithm (natural log)
            else if (operation == 5) {
                System.out.print("Enter the number for logarithm (natural log): ");
                double num = scanner.nextDouble();
                // Log requires the number to be positive.
                if (num <= 0) {
                    System.out.println("Logarithm is undefined for zero or negative numbers.");
                    continue;
                }
                double result = Math.log(num);
                String historyEntry = "ln(" + num + ") = " + result;
                history.add(historyEntry);
                System.out.println("Result: " + result);
                continue;
            }
            
            // Operation for Factorial
            else if (operation == 6) {
                System.out.print("Enter a non-negative integer for factorial: ");
                int num = scanner.nextInt();
                if (num < 0) {
                    System.out.println("Factorial is undefined for negative numbers.");
                    continue;
                }
                long result = factorial(num);
                String historyEntry = num + "! = " + result;
                history.add(historyEntry);
                System.out.println("Result: " + result);
                continue;
            }
            else {
                System.out.println("Invalid operation. Try again.");
            }
        }
    }

    // Helper method to calculate factorial recursively.
    private static long factorial(int n) {
        if (n == 0 || n == 1)
            return 1;
        else
            return n * factorial(n - 1);
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
