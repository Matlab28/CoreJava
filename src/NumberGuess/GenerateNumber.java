package NumberGuess;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GenerateNumber {
    Scanner scanner;
    Random random;
    ArrayList<String> list;
    private static int score, round = 1;
    private String number;

    public GenerateNumber() {
        random = new Random();
        list = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void guessing() {
        while (true) {
            String numbersss = ".*\\d+.*";
            int a = random.nextInt(100);
            System.out.println("=========== ROUND " + (round += 1) + "===========");
            System.out.print("Guess number: ");
            try {
                setNumber(scanner.next());
                System.out.println("Your guess: " + number);
                System.out.println("Mine is: " + a);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            if (number.equalsIgnoreCase("done")) {
                System.out.println("\n-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
                System.out.println("Game over.");
                System.out.println("Total scores: " + score);
                System.out.println("Total rounds: " + round);
                System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n");
                break;
            }

            if (!number.matches(numbersss)) {
                throw new RuntimeException("Invalid input...");
            }

            if (random.equals(Integer.parseInt(number))) {
                System.out.println("Congratulations! You guessed right.");
                System.out.println("Score: " + (score += 1));
            } else {
                System.out.println("Unfortunately you guessed wrong...");
            }

            list.add(number);
        }
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
