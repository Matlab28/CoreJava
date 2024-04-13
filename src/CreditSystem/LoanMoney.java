package CreditSystem;

import java.util.Scanner;

public class LoanMoney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BackData backData = new BackData();
        System.out.print("Please, enter your name: ");
        backData.setName(scanner.next());
        System.out.println();
        backData.workingTime(scanner);
        System.out.println();
        backData.salaryConfirmation(scanner);
    }
}
