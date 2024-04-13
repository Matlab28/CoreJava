package BuildingManage;

import java.util.Random;
import java.util.Scanner;

public class Chat extends Security {
    Random random;
    private String chat, number;

    public Chat() {
        random = new Random();
    }

    public void addPhoneNumber(Scanner scanner) {
        System.out.println("Enter your number:");
        setNumber(scanner.next());
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < getNumber().length(); i++) {
            output.append(getNumber().charAt(i));
            if ((i + 1) % 3 == 0 && i != getNumber().length() - 1 && (i + 1) < getNumber().length() - 3) {
                output.append("-");
            }
        }

        while (true) {
            System.out.println("We send code for approving to '" + output.toString() + "' number. Please approve it.");
            int min = 1000;
            int max = 9999;
            int digits = random.nextInt(max - min + 1) + min;
            System.out.println("Clarification code: " + digits);
            System.out.print("Please confirm it: ");
            String confirmation = scanner.next();

            if (Integer.parseInt(confirmation) == digits) {
                System.out.println("Thank you " + getName() + ", you could confirm successfully.");
                break;
            } else {
                System.out.println("\nWrong code. Please try again...\n");
            }
        }
    }

    public void communication(Scanner scanner) {
        while (true) {
            System.out.println("\nType something:");
            setChat(scanner.nextLine());

            if (getChat().equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("\n" + getName() + " sent a message:");
            System.out.println("---------------------------------------------");
            System.out.println(" - " + getChat());
            System.out.println("---------------------------------------------");
        }
    }
    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
