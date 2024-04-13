package RspWithScore;

import Rock_Sciss_Paper.Essentials;

import java.util.Random;
import java.util.Scanner;

public class Creation {

    public static int round, yourScore, myScore = 1;

    public void play(Scanner scanner) {
        while (true) {
            System.out.println("======= ROUND " + (round+=1) +" =======");

            Random random = new Random();
            int computer = random.nextInt(3);
            String myChoose;

            switch (computer) {
                case 0:
                    myChoose = Tools.ROCK.value;
                    break;
                case 1:
                    myChoose = Tools.PAPER.value;
                    break;
                case 2:
                    myChoose = Tools.SCISSORS.value;
                    break;
                default:
                    throw new RuntimeException("Error...");
            }

            System.out.print("Enter yours (rock, scissors, or paper): ");
            String userChoose = scanner.next();

            if (userChoose.equalsIgnoreCase("exit")) {
                System.out.println("\n-_-_=_-_=_-_=_-_=_-_=_-_=_-_=_-_=_-_=_-_=");
                System.out.println("You've interrupted game. Game over.");
                System.out.println("your total score is: " + yourScore);
                System.out.println("My total score is: " + myScore);
                System.out.println("Total rounds we've played: " + round);
                System.out.println("-_-_=_-_=_-_=_-_=_-_=_-_=_-_=_-_=_-_=_-_=");
                break;
            }

            if (userChoose.equalsIgnoreCase("rock")) {
                System.out.println("Your choice: Rock");
                System.out.println("Mine is: " + myChoose);
                if (myChoose.equals(Tools.ROCK.value)) {
                    System.out.println("Wow, game is tie! Let's play again...");

                } else if (!userChoose.equals(myChoose)) {
                    if (myChoose.equals(Tools.PAPER.value)) {
                        System.out.println("You've lost...but don't worry, let's play again!");
                        System.out.println("My sore is: " + (myScore+=1));
                    } else if (myChoose.equals(Tools.SCISSORS.value)) {
                        System.out.println("Wow! You won, let's play again!");
                        System.out.println("Your score is: " + (yourScore+=1));
                    }
                }
            } else if (userChoose.equalsIgnoreCase("paper")) {
                System.out.println("Your choice: Paper");
                System.out.println("Mine is: " + myChoose);
                if (myChoose.equals(Tools.PAPER.value)) {
                    System.out.println("Wow, game is tie! Let's play again...");
                } else if (!userChoose.equals(myChoose)) {
                    if (myChoose.equals(Tools.ROCK.value)) {
                        System.out.println("Wow! You won, let's play again!");
                        System.out.println("Your score is: " + (yourScore+=1));
                    } else if (myChoose.equals(Tools.SCISSORS.value)) {
                        System.out.println("You've lost...but don't worry, let's play again!");
                        System.out.println("My sore is: " + (myScore+=1));
                    }
                }
            } else if (userChoose.equalsIgnoreCase("scissors")) {
                System.out.println("Your choice: Scissors");
                System.out.println("Mine is: " + myChoose);
                if (myChoose.equals(Tools.SCISSORS.value)) {
                    System.out.println("Wow, game is tie! Let's play again...");
                } else if (!userChoose.equals(myChoose)) {
                    if (myChoose.equals(Tools.PAPER.value)) {
                        System.out.println("Wow! You won, let's play again!");
                        System.out.println("Your score is: " + (yourScore+=1));
                    } else if (myChoose.equals(Tools.ROCK.value)) {
                        System.out.println("You've lost...but don't worry, let's play again!");
                        System.out.println("My sore is: " + (myScore+=1));
                    }
                }
            } else {
                System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("Please enter only 'rock, scissors, or paper'...");
                System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
            }
            System.out.println("\n-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n");
        }
    }
}
