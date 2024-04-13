package Uno;

import java.util.*;

public class Structure {
    private String username, randomColors, randomCards;
    private int players, score;
    Random random;
    List<Integer> gamePlayers;
    List<String> gamers;
    Set<String> uniqueCards;
    Set<Integer> unique;

    public Structure() {
        gamePlayers = new ArrayList<>();
        gamers = new ArrayList<>();
        uniqueCards = new HashSet<>();
        unique = new HashSet<>();
        random = new Random();
    }

    public void game(Scanner scanner) {
        while (true) {
            System.out.print("How many players you are (2 or 4)? ");
            setPlayers(scanner.nextInt());
            gamePlayers.add(getPlayers());

            if (getPlayers() != 2 && getPlayers() != 4) {
                System.out.println("Only 2 or 4 players can play...");
                continue;
            }


            System.out.println("Please enter the players name:");
            int count = 1;
            int result = 1;


            for (int i = 0; i < getPlayers(); i++) {
                System.out.print("Enter the " + (count++) + ". name: ");
                setUsername(scanner.next());

                gamers.add(getUsername());
            }

            for (String listOfPlayers : gamers) {
                System.out.println(result++ + ". player's name: " + listOfPlayers);
            }

//            gamers
//                    .forEach(System.out::println);
            cards();
            System.out.println();
        }
    }

    public void cards() {
        System.out.println("We have 'yellow, blue, red, green' colors.");
        int colors = random.nextInt(4);

        switch (colors) {
            case 0:
                randomColors = Cards.RED.getValue();
                break;
            case 1:
                randomColors = Cards.GREEN.getValue();
                break;
            case 2:
                randomColors = Cards.YELLOW.getValue();
                break;
            case 3:
                randomColors = Cards.BLUE.getValue();
                break;
            default:
//x                System.out.println("This color isn't exist...");
        }


        int mainCards = random.nextInt(4);

        switch (mainCards) {
            case 0:
                randomCards = Cards.REVERSED.getValue();
                break;
            case 1:
                randomCards = Cards.BLOCK.getValue();
                break;
            case 2:
                randomCards = Cards.TWO_PLUS.getValue();
                break;
            case 3:
                randomCards = Cards.FOUR_PLUS.getValue();
                break;
            default:
                System.out.println("Other cards don't exist...");
        }

        int numbers = random.nextInt(10);
        int count = 1;
        int says = 0;

        if (getPlayers() == 2) {

//            for (int i = 0; i < 7; i++) {
//                String mainCards1 = randomCards;
//                String cards = randomColors;
//
//                System.out.println((i++) + ") " + mainCards1 + " .... " + cards + " .,.,. " + numbers);
//            }

//            for (int i = 0; i < 7; i++) {
//                do {
//                    StringBuilder builder = new StringBuilder();
//                    builder.append(count++).append(") ")
//                            .append(randomCards).append(" .... ")
//                            .append(randomColors).append(" .,.,. ")
//                            .append(numbers);
////                String mainCards1 = randomCards;
//
//                    System.out.println(builder + "....");
//                    says++;
//                } while (says < 7);
//            }


            System.out.println((count++) + ") " + randomCards + " .... " + randomColors + " .,.,. " + numbers);
            System.out.println((count++) + ") " + randomCards + " .... " + randomColors + " .,.,. " + numbers);
            System.out.println((count++) + ") " + randomCards + " .... " + randomColors + " .,.,. " + numbers);
            System.out.println((count++) + ") " + randomCards + " .... " + randomColors + " .,.,. " + numbers);
            System.out.println((count++) + ") " + randomCards + " .... " + randomColors + " .,.,. " + numbers);
            System.out.println((count++) + ") " + randomCards + " .... " + randomColors + " .,.,. " + numbers);
            System.out.println((count++) + ") " + randomCards + " .... " + randomColors + " .,.,. " + numbers);


        } else if (getPlayers() == 4) {

//            while (uniqueCards.size() <= 7) {
//                uniqueCards.add(getRandomCards());
//                uniqueCards.add(getRandomColors());
//            }
//
//            System.out.println("Cards: " + uniqueCards);

//            for (int i = 0; i < 7; i++) {
//
//            }
        }
    }

    public String getRandomColors() {
        return randomColors;
    }

    public String getRandomCards() {
        return randomCards;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPlayers() {
        return players;
    }

    public void setPlayers(int players) {
        this.players = players;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
