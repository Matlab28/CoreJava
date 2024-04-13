package Rock_Sciss_Paper;

import java.util.Random;
import java.util.Scanner;

public class GameStructure {
    Essentials essentials;

    public void game(Scanner scanner) {
        while (true) {
            Random random = new Random();
            int computer = random.nextInt(3);
            String myChoose;

            switch (computer) {
                case 0:
                    myChoose = Essentials.ROCK.value;
                    break;
                case 1:
                    myChoose = Essentials.PAPER.value;
                    break;
                case 2:
                    myChoose = Essentials.SCISSORS.value;
                    break;
                default:
                    throw new RuntimeException("Error...");
            }

            System.out.print("Enter yours (rock, scissors, or paper): ");
            String userChoose = scanner.next();

            if (userChoose.equalsIgnoreCase("exit")) {
                System.out.println("You've interrupted game. Game over.");
                break;
            }

            if (userChoose.equalsIgnoreCase("rock")) {
                System.out.println("Your choice: Rock");
                System.out.println("Mine is: " + myChoose);
                if (myChoose.equals(Essentials.ROCK.value)) {
                    System.out.println("Wow, game is tie! Let's play again...");
                } else if (!userChoose.equals(myChoose)) {
                    if (myChoose.equals(Essentials.PAPER.value)) {
                        System.out.println("You've lost...but don't worry, let's play again!");
                    } else if (myChoose.equals(Essentials.SCISSORS.value)) {
                        System.out.println("Wow! You won, let's play again!");
                    }
                }
            } else if (userChoose.equalsIgnoreCase("paper")) {
                System.out.println("Your choice: Paper");
                System.out.println("Mine is: " + myChoose);
                if (myChoose.equals(Essentials.PAPER.value)) {
                    System.out.println("Wow, game is tie! Let's play again...");
                } else if (!userChoose.equals(myChoose)) {
                    if (myChoose.equals(Essentials.ROCK.value)) {
                        System.out.println("Wow! You won, let's play again!");
                    } else if (myChoose.equals(Essentials.SCISSORS.value)) {
                        System.out.println("You've lost...but don't worry, let's play again!");
                    }
                }
            } else if (userChoose.equalsIgnoreCase("scissors")) {
                System.out.println("Your choice: Scissors");
                System.out.println("Mine is: " + myChoose);
                if (myChoose.equals(Essentials.SCISSORS.value)) {
                    System.out.println("Wow, game is tie! Let's play again...");
                } else if (!userChoose.equals(myChoose)) {
                    if (myChoose.equals(Essentials.PAPER.value)) {
                        System.out.println("Wow! You won, let's play again!");
                    } else if (myChoose.equals(Essentials.ROCK.value)) {
                        System.out.println("You've lost...but don't worry, let's play again!");
                    }
                }
            } else {
                System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("Please enter only 'rock, scissors, or paper'...");
                System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
            }
            System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
        }
    }
}
