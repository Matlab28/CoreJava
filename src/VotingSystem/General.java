package VotingSystem;

import java.util.Scanner;

public class General {
    private String idNumb;

    public void voting(Scanner scanner) {
        while (true) {
            System.out.print("Enter your Identity card's personal number: ");
            setIdNumb(scanner.next().toUpperCase());

            String numbers = ".*\\d+.*";
            String letters = ".*[a-zA-Z].*";
            if (getIdNumb().length() != 7) {
                System.out.println("It's length must be 7.");
                continue;
            }
            if (!getIdNumb().matches(numbers) || !getIdNumb().matches(letters)) {
                System.out.println("It must contain any letters and numbers.");
                continue;
            }

            System.out.println("Is '" + getIdNumb() + "' your ID number?");
            System.out.print("Approve with yes: ");
            String yesOrNo = scanner.next();

            if (yesOrNo.equalsIgnoreCase("yes")) {
                System.out.println("Welcome to the elections.");
                break;
            } else {
            }
        }
        elections(scanner);
    }

    public Character elections(Scanner scanner) {
        System.out.println("Choose a person, who do you want to vote.");
        System.out.print("Choose one of them: X, Y, Z. - ");
        Character choose = scanner.next().charAt(0);

        switch (choose) {
            case 'X':
                System.out.println("You voted 'X' successfully. Thank you for voting!");
                break;
            case 'Y':
                System.out.println("You voted 'Y' successfully. Thank you for voting!");
                break;
            case 'Z':
                System.out.println("You voted 'Z' successfully. Thank you for voting!");
                break;
            default:
                System.out.println("Please choose only one of them:");
        }
        return choose;
    }

    public String getIdNumb() {
        return idNumb;
    }

    public void setIdNumb(String idNumb) {
        this.idNumb = idNumb;
    }
}
