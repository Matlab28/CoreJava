package Bank;

import java.util.Scanner;

public class OurBank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GeneralSystem generalSystem = new GeneralSystem();
        System.out.println("Please enter your name: ");
        generalSystem.setName(scanner.next());
        System.out.println();
        generalSystem.askPassword(scanner);
        System.out.println();
        generalSystem.confirmation(scanner);
        System.out.println();
        generalSystem.addBalance(scanner);
        System.out.println("\nDo you want to set deposit?");
        while (true) {
            System.out.print("Please confirm yes or no: ");
            String deposit = scanner.next();

            if (deposit.equalsIgnoreCase("yes")) {
                generalSystem.addDeposit(scanner);
                break;
            } else if (deposit.equalsIgnoreCase("no")) {
                System.out.println("Alright " + generalSystem.getName() + ".");
                break;
            } else {
            }
        }

        System.out.println("\nDo you want to transfer money to someone?");
        while (true) {
            System.out.print("Please confirm yes or no: ");
            String transfer = scanner.next();

            if (transfer.equalsIgnoreCase("yes")) {
                generalSystem.confirmation(scanner);
                generalSystem.sendMoney(scanner);
                break;
            } else if (transfer.equalsIgnoreCase("no")) {
                System.out.println("Thank you for using " + generalSystem.getName());
                break;
            } else {
            }
        }
    }
}
