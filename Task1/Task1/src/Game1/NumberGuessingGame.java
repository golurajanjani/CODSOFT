package Game1;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 10;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        int roundsWon = 0;

        while (playAgain) {
            int attempts = 0;
            boolean guessedCorrectly = false;
            int targetNumber = generateRandomNumber(MIN_RANGE, MAX_RANGE);

            System.out.println("Guess the number between " + MIN_RANGE + " and " + MAX_RANGE + ":");

            while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    guessedCorrectly = true;
                    roundsWon++;
                } else if (userGuess > targetNumber) {
                    System.out.println("Your guess is too high.");
                } else {
                    System.out.println("Your guess is too low.");
                }

                if (attempts >= MAX_ATTEMPTS && !guessedCorrectly) {
                    System.out.println("Sorry, you've used all your attempts. The correct number was " + targetNumber);
                }
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Game over! You won " + roundsWon + " round(s).");
        scanner.close();
    }

    private static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}