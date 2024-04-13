package Bank;

import java.util.Scanner;

public class GeneralSystem extends SecuritySide {
    private static boolean methodCalled = false;
    private String accountNumber;
    private double balance, deposit, transferAmount;

    public double depositLeft() {
        return getBalance() - getDeposit();
    }

    public double afterDeposit() {
        return depositLeft() - getTransferAmount();
    }

    public double transfer() {
        return getBalance() - getTransferAmount();
    }

    public void confirmation(Scanner scanner) {
        while (true) {
            StringBuilder builder = new StringBuilder();
            System.out.print("Please enter your account number: ");
            setAccountNumber(scanner.next());

            String lowers = ".*[a-z].*";
            String uppers = ".*[A-Z].*";

            if (getAccountNumber().matches(lowers) || getAccountNumber().matches(uppers)) {
                System.out.println("It cannot contain any letters...");
                continue;
            }
            if (getAccountNumber().length() != 16) {
                System.out.println("Account number's length must be 16 characters...");
                continue;
            }
            for (int i = 0; i < getAccountNumber().length(); i += 4) {
                int endIndex = Math.min(i + 4, getAccountNumber().length());
                String substring = getAccountNumber().substring(i, endIndex);
                builder.append(substring);

                if (endIndex < getAccountNumber().length()) {
                    builder.append(" ");
                }
            }

            System.out.println("Is '" + (builder.toString()) + "' the right account number?");

            System.out.print("Please confirm with yes or no: ");
            String yesOrNo = scanner.next();

            if (yesOrNo.equalsIgnoreCase("yes")) {
                System.out.println("Thank you " + getName() + "!");
                break;
            } else if (yesOrNo.equalsIgnoreCase("no")) {
            }
        }
    }

    public void addBalance(Scanner scanner) {
        while (true) {
            System.out.print("How much money do you have in your balance? ");
            setBalance(scanner.nextDouble());

            if (getBalance() <= 0) {
                throw new RuntimeException("It can't be lower than zero...");
            }

            System.out.println("You have '" + getBalance() + "' azn in your account.");
            break;
        }
    }

    public void addDeposit(Scanner scanner) {
        while (true) {
            methodCalled = true;
            System.out.print("How much money do you want to set deposit? ");
            setDeposit(scanner.nextDouble());

            if (getDeposit() <= 0) {
                throw new RuntimeException("It can't be equal, or lower than zero...");
            }
            if (getDeposit() > getBalance()) {
                System.out.println("You can't set deposit, which is higher than your balance...");
                continue;
            }
            System.out.println("'" + getDeposit() + "' azn set as deposit.");
            System.out.println("'" + depositLeft() + "' azn left in your account.");
            break;
        }
    }

    public void sendMoney(Scanner scanner) {
        while (true) {
            System.out.print("How much money do you want to send? ");
            try {
                setTransferAmount(scanner.nextDouble());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            if (getTransferAmount() <= 0) {
                throw new RuntimeException("Your transfer amount can't be equal or lower than zero...");
            }
            if (getTransferAmount() > getBalance()) {
                System.out.println("You can't send amount, which is higher than your balance...");
                continue;
            }
            if (methodCalled == false) {
                System.out.println("'" + transfer() + "' azn transferred successfully.");
            } else {
                System.out.println("'" + afterDeposit() + "' azn transferred successfully.");
            }
            System.out.println(getName() + ", thank you for using OurBank.");
            break;
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(double transferAmount) {
        this.transferAmount = transferAmount;
    }
}
