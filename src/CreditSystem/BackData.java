package CreditSystem;

import java.util.Scanner;

public class BackData {
    private String name;
    private double loanMoney;
    private int months;
    private int salary;
    public void workingTime(Scanner scanner) {
        while (true) {
            System.out.println("Hi " + getName() + ", are you working?");
            String approve = scanner.next();

            if (approve.equalsIgnoreCase("yes")) {
                System.out.print("How long you've been working (months): ");
                setMonths(scanner.nextInt());

                if (getMonths() < 6) {
                    System.out.println("You have to work at least 6 months for loan money");
                    break;
                } else {
                    System.out.println(getName() + ", you can loan money from OurBank.");
                    break;
                }
            } else if (approve.equalsIgnoreCase("no")) {
                System.out.println("Unfortunately, you have to work for loaning money");
                break;
            } else {
                System.out.println("Please enter only yes or no.");
            }
        }
    }

    public void salaryConfirmation(Scanner scanner) {
        System.out.print("How much is your salary? - ");
        setSalary(scanner.nextInt());

        if (getSalary() <= 0) {
            throw new RuntimeException("It can't be negative or lower than zero...");
        }
        System.out.println("Your salary is '" + getSalary() + "' azn,");
        int creditAmount = getSalary() * 8;
        System.out.println("In this case, you can loan utmost ' " + creditAmount + "' azn.");

        returnMoney(scanner);
    }

    public void returnMoney(Scanner scanner) {
        System.out.println("\nIn which term do you want to return money?");
        System.out.print("Options: 3/6/12/18/24/30/36 months: ");
        int term = scanner.nextInt();

        switch (term) {
            case 3:
                System.out.println("In this term, you'll pay extra 7% of the loan.");
                double returningMoney3 = ((getSalary() * 8) * 107) / 100;
                System.out.println("You should pay '" + returningMoney3 + "' azn.");
                double monthly3 = returningMoney3 / 3;
                System.out.println("Every month, you'll pay '" + monthly3 + "' azn.");
                break;
            case 6:
                System.out.println("In this term, you'll pay extra 9% of the loan.");
                double returningMoney6 = ((getSalary() * 8) * 109) / 100;
                System.out.println("You should pay '" + returningMoney6 + "' azn.");
                double monthly6 = returningMoney6 / 6;
                System.out.println("Every month, you'll pay '" + monthly6 + "' azn.");
                break;
            case 12:
                System.out.println("In this term, you'll pay extra 12% of the loan.");
                double returningMoney12 = ((getSalary() * 8) * 112) / 100;
                System.out.println("You should pay '" + returningMoney12 + "' azn.");
                double monthly12 = returningMoney12 / 12;
                System.out.println("Every month, you'll pay '" + monthly12 + "' azn.");
                break;
            case 18:
                System.out.println("In this term, you'll pay extra 14% of the loan.");
                double returningMoney18 = ((getSalary() * 8) * 114) / 100;
                System.out.println("You should pay '" + returningMoney18 + "' azn.");
                double monthly18 = returningMoney18 / 18;
                System.out.println("Every month, you'll pay '" + monthly18 + "' azn.");
                break;
            case 24:
                System.out.println("In this term, you'll pay extra 16% of the loan.");
                double returningMoney24 = ((getSalary() * 8) * 116) / 100;
                System.out.println("You should pay '" + returningMoney24 + "' azn.");
                double monthly24 = returningMoney24 / 24;
                System.out.println("Every month, you'll pay '" + monthly24 + "' azn.");
                break;
            case 30:
                System.out.println("In this term, you'll pay extra 18% of the loan.");
                double returningMoney30 = ((getSalary() * 8) * 118) / 100;
                System.out.println("You should pay '" + returningMoney30 + "' azn.");
                double monthly30 = returningMoney30 / 30;
                System.out.println("Every month, you'll pay '" + monthly30 + "' azn.");
                break;
            case 36:
                System.out.println("In this term, you'll pay extra 20% of the loan.");
                double returningMoney36 = ((getSalary() * 8) * 120) / 100;
                System.out.println("You should pay '" + returningMoney36 + "' azn.");
                double monthly36 = returningMoney36 / 36;
                System.out.println("Every month, you'll pay '" + monthly36 + "' azn.");
                break;
            default:
                System.out.println("Please, choose one of them:");
                returnMoney(scanner);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLoanMoney() {
        return loanMoney;
    }

    public void setLoanMoney(double loanMoney) {
        this.loanMoney = loanMoney;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
