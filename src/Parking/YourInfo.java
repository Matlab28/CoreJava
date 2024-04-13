package Parking;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class YourInfo {
    private String carNumber;
    private String name;
    private String countryApprove;

    public void information(Scanner scanner) {
        approving(scanner);
        System.out.print("For saving your information, please enter your name: ");
        setName(scanner.next());
        System.out.println();
        Map<String, String> result = new HashMap<>();
        result.put(getCarNumber().toUpperCase(), getName());

        result.entrySet()
                .stream()
                .map(entry -> {
                    System.out.println("Your car's license plate number: " + entry.getKey());
                    System.out.println("Your name: " + entry.getValue());
                    return entry.getValue() + "'s car, " + entry.getKey();
                })
                .forEach(System.out::println);

        System.out.println("It's 0.7 azn per hour. Please add your card for payment.");
        addingCard(scanner);
    }

    public void approving(Scanner scanner) {
        while (true) {
            System.out.println("Enter your car's licence plate number: ");
            setCarNumber(scanner.next());

            String letters = "^(?=.*[a-z])(?=.*[A-Z]).+$\n";
            String numbers = ".*\\d+.*";

            if (!getCarNumber().matches(letters) && !getCarNumber().matches(numbers)) {
                System.out.println("\nIt must contain any letters and numbers as well...\n");
                continue;
            }

            if (getCountryApprove().equalsIgnoreCase("az") || getCountryApprove().equalsIgnoreCase("ge")) {
                // e.g. 99-AA-99 (AZ), AB-115-BA (GE)
                if (getCarNumber().length() != 7) {
                    System.out.println("Please enter the right number...");
                    continue;
                }
            } else if (getCountryApprove().equalsIgnoreCase("ru")) {
                // У 199 УА 78
                if (getCarNumber().length() != 8) {
                    System.out.println("Please enter the right number...");
                    continue;
                }
            }


            System.out.println("Is '" + (getCarNumber().toUpperCase()) + "' right license number?");
            System.out.print("Please approve yes or no: ");
            String numbApprove = scanner.next();

            if (numbApprove.equalsIgnoreCase("yes")) {
                break;
            } else if (numbApprove.equalsIgnoreCase("no")) {
                System.out.println("\nThen try again...\n");
            }
        }
    }

    public void addingCard(Scanner scanner) {
        while (true) {
            StringBuilder builder = new StringBuilder();
            System.out.println("Enter your card number:");
            String cardNumber = scanner.next();
            String letters = "^(?=.*[a-z])(?=.*[A-Z]).+$\n";
            String numbers = ".*\\d+.*";

            if (cardNumber.matches(letters)) {
                System.out.println("\nIt CANNOT contain any letters...\n");
                continue;
            }
            if (!cardNumber.matches(numbers)) {
                System.out.println("\nIt can only contain numbers...\n");
                continue;
            }

            if (cardNumber.length() != 16) {
                System.out.println("\nCard's length must be 16 characters...\n");
                continue;
            }

            for (int i = 0; i < cardNumber.length(); i += 4) {
                int endIndex = Math.min(i + 4, cardNumber.length());
                String substring = cardNumber.substring(i, endIndex);
                builder.append(substring);

                if (endIndex < cardNumber.length()) {
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

    public void countryApprove(Scanner scanner) {
        while (true) {
            System.out.println("Where is your car registered? Enter the right country:");
            System.out.println("AZ (Azerbaijan), GE (Georgia), RU (Russia), or other.");
            setCountryApprove(scanner.next());

            if (getCountryApprove().equalsIgnoreCase("az")) {
                System.out.println("You selected Azerbaijan (AZ), is this right?");
                System.out.println("Please approve with yes or no: ");
                String yesNo = scanner.next();

                if (yesNo.equalsIgnoreCase("yes")) {
                    System.out.println("Your car's registrations from Azerbaijan.");
                    information(scanner);
                    break;
                } else if (yesNo.equalsIgnoreCase("no")) {
                    System.out.println("\n-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
                    System.out.println("Then, please try again...");
                    System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n");
                    continue;
                }
            } else if (getCountryApprove().equalsIgnoreCase("ge")) {
                System.out.println("You selected Georgia (GE), is this right?");
                System.out.println("Please approve with yes or no: ");
                String yesOrNo = scanner.next();

                if (yesOrNo.equalsIgnoreCase("yes")) {
                    System.out.println("Your car's registrations from Georgia.");
                    information(scanner);
                    break;
                } else if (yesOrNo.equalsIgnoreCase("no")) {
                    System.out.println("\n-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
                    System.out.println("Then, please try again...");
                    System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n");
                    continue;
                }
            } else if (getCountryApprove().equalsIgnoreCase("ru")) {
                System.out.println("You selected Russia (RU), is this right?");
                System.out.println("Please approve with yes or no: ");
                String yesONo = scanner.next();

                if (yesONo.equalsIgnoreCase("yes")) {
                    System.out.println("Your car's registrations from Russia.");
                    information(scanner);
                    break;
                } else if (yesONo.equalsIgnoreCase("no")) {
                    System.out.println("\n-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
                    System.out.println("Then, please try again...");
                    System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n");
                    continue;
                }
            } else if (getCountryApprove().equalsIgnoreCase("other")) {
                System.out.print("Enter the name of the country: ");
                String addCountry = scanner.next();
                System.out.println("You selected " + addCountry + ", is this right?");
                System.out.println("Please approve with yes or no: ");
                String another = scanner.next();

                if (another.equalsIgnoreCase("yes")) {
                    System.out.println("Your car's registrations from " + addCountry + ".");
                    information(scanner);
                    break;
                } else if (another.equalsIgnoreCase("no")) {
                    System.out.println("\n-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
                    System.out.println("Then, please try again...");
                    System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n");
                    continue;
                }
            } else {
                System.out.println("\n============================================");
                System.out.println("Please enter the accurate information...");
                System.out.println("============================================\n");
            }
        }
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryApprove() {
        return countryApprove;
    }

    public void setCountryApprove(String countryApprove) {
        this.countryApprove = countryApprove;
    }
}
