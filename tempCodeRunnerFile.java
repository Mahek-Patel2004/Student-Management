import java.util.Scanner;

public class TerracedFieldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of datasets
        int numDatasets = scanner.nextInt();

        for (int i = 0; i < numDatasets; i++) {
            // Input the number of steps in the terraced field
            int n = scanner.nextInt();

            // Calculate the cost of the tour
            int cost = calculateTourCost(n);

            // Output the cost of the tour for this dataset
            System.out.println(cost);
        }

        // Close the scanner
        scanner.close();
    }

    // Function to calculate the cost of the tour
    private static int calculateTourCost(int n) {
        // Initialize cost to 0
        int cost = 0;

        // Iterate through each step and check if it's divisible by 8 or the final step
        for (int step = 1; step <= n; step++) {
            if (step % 8 == 0 || step == n) {
                // Count the number of lucky digits (6 and 8) in the current step
                cost += countLuckyDigits(step);
            }
        }

        // Return the total cost for the tour
        return cost;
    }

    // Function to count the number of lucky digits in a number
    private static int countLuckyDigits(int num) {
        int count = 0;
        while (num > 0) {
            int digit = num % 10;
            if (digit == 6 || digit == 8) {
                count++;
            }
            num /= 10;
        }
        return count;
    }
}