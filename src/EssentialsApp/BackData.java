package EssentialsApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BackData {
    private String name;
    private String allEach;
    private double balance;
    private String time;

    public void generally(Scanner scanner) {
        System.out.print("Welcome " + getName() + ", how many categories do you want to add? ");

        String[] categories = new String[scanner.nextInt()];
        List<String> categoryList = new ArrayList<>();
        double totalAmount = 0.0;


        int count = 1;
        int result = 1;
        int separateCategory = 2;
        System.out.println("\nPlease select category (or categories):");
        System.out.println("Coffee shop, book shop, market, clothing, or just for saving? ");
        for (int i = 0; i < categories.length; i++) {
            System.out.print("Add " + count++ + ". category: ");
            try {
                categories[i] = scanner.next();
            } catch (Exception e) {
                throw new RuntimeException("Please add only category's products...");
            }
        }

        System.out.println("\nYour categories list:");
        for (String list : categories) {
            System.out.println(result++ + ") category: " + list);
        }

        System.out.print("\nHow much money do you have in your account? - ");
        try {
            setBalance(scanner.nextDouble());
        } catch (Exception e) {
            throw new RuntimeException("You can only your balance...");
        }

        if (getBalance() < 0) {
            throw new RuntimeException("it can't be lower than zero...");
        }

        System.out.println("How much money do you want to set your categories?");
        System.out.println("\n-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
        System.out.println("You have two options:");
        System.out.println("First, you can set money separately for your each category;");
        System.out.println("Second, you can set money for all of them only once.");
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-\n");
        System.out.println("If you want choose 1st, enter 'all', otherwise, enter 'separate'.");
        System.out.print("Choose one of them: ");


        String choosing = scanner.next();


        if (choosing.equalsIgnoreCase("separate")) {
            System.out.println("Please set money for each category one-by-one:");
            System.out.print("Enter for 1. ");

            for (String forEachOfThem : categories) {
                try {
                    setAllEach(scanner.next());
                    totalAmount += Double.parseDouble(getAllEach());
                    System.out.println("'" + getAllEach() + "' azn set for " + forEachOfThem + "'");
                    System.out.print("Enter for " + separateCategory++ + ". ");
                } catch (Exception e) {
                    throw new RuntimeException("Enter only money for categories...");
                }
            }

            if (totalAmount > balance) {
                throw new RuntimeException("You set '" + totalAmount + "' azn for categories. And you have '" +
                        getBalance() + "' azn in your account. " +
                        "You can't set money for categories, which is higher than balance...");
            }

            System.out.println("\nTotally, you have set '" + totalAmount + "' for you categories.");
            double left = getBalance() - totalAmount;
            System.out.println("And '" + left + "' azn left in your account.");

//            System.out.println("\nYour list, which is after added amounts:");
            System.out.println("\nCategories processed:");
            for (String category : categoryList) {
                System.out.println("Category: " + category);
            }
        } else if (choosing.equalsIgnoreCase("all")) {
            System.out.print("Please set how much money do you want to keep - ");
            double all = scanner.nextDouble();

            if (all > getBalance() || all < 0) {
                throw new RuntimeException("It cannot be higher than balance or you can't set money lower than zero...");
            }
            System.out.println("You set '" + all + "' azn for your categories.");
            double left2 = getBalance() - all;
            System.out.println("'" + left2 + "' azn left in your account.");
            System.out.println("\n-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-\n");
            System.out.println("'" + all + "' azn allocated for your categories");
            int lastResult = 1;
            for (String allPrint : categories) {
                System.out.println(lastResult++ + ") " + allPrint);
            }
        } else {
            System.out.println("Please enter only 'all' or 'separate'...");
        }
    }

    public void timeManagement2(Scanner scanner) {
        System.out.println("You should set term weekly (7 days) or monthly (30 days).");
        System.out.println("Which one do you want?");
        System.out.print("Please add today's daytime: ");
        int daytime = scanner.nextInt();
        while (true) {
            System.out.print("Please enter only 'weekly' or 'monthly': ");
//            timeManagement2(scanner.next());

            if (getTime().equalsIgnoreCase("weekly")) {
                System.out.println("Your time started " + daytime + " January, 2024");
                System.out.println("Its expiration is " + (daytime + 7) + " January, 2024");
                System.out.println("\nPS: If any amount leave in your account, it'll transfer your bank account automatically.");
                System.out.println("\nCongratulations " + getName() + ", you could set your" +
                        "'Essentials' list successfully.");
                System.out.println("See you next week!");
                break;
            } else if (getTime().equalsIgnoreCase("monthly")) {
                System.out.println("Your time started " + daytime + " January, 2024");
                System.out.println("Its expiration is " + (daytime - 1) + " February, 2024");
                System.out.println("\nPS: If any amount leave in your account, it'll transfer your bank account automatically.");
                System.out.println("\nCongratulations " + getName() + ", you could set your" +
                        "'Essentials' list successfully.");
                System.out.println("See you next month!");
                break;
            } else {
                System.out.print("Please enter only 'weekly' or 'monthly': ");
            }
        }
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAllEach() {
        return allEach;
    }

    public void setAllEach(String allEach) {
        this.allEach = allEach;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
