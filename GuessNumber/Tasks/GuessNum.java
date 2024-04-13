import java.util.Scanner;
import java.util.Random;

public class GuessNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Step 1: Generate a random number within the specified range
        int lowerBound = 1;
        int upperBound = 100;
        int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

        // Additional details
        int maxAttempts = 5;
        int attempts = 0;
        int rounds = 0;
        int score = 0;

        boolean playAgain = true;

        while (playAgain) {
            rounds++;
            System.out.println("\nRound " + rounds + " - Guess the number between " + lowerBound + " and " + upperBound + "!");

            // Step 2 and 3: Prompt the user to enter their guess and compare with the generated number
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();

                if (guess == secretNumber) {
                    System.out.println("Congratulations! You guessed the correct number!");
                    score++;
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                attempts++;
                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            // If the user couldn't guess the number within the attempts
            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've reached the maximum attempts. The correct number was " + secretNumber + ".");
            }

            // Ask the user if they want to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            if (!playAgainInput.equals("yes")) {
                playAgain = false;
            } else {
                // Reset attempts for the next round
                attempts = 0;
                // Generate a new random number for the next round
                secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            }
        }

        // Step 7: Display the user's score
        System.out.println("\nYou played " + rounds + " round(s) and scored " + score + " point(s). Thanks for playing!");

        // Close the scanner
        scanner.close();
    }
}
