package CitizenshipCheck;

import java.util.*;

public class Citizenship {
    private String name, citizenship, id;

    Map<String, String> citizen;
    List<String> country;

    public Citizenship() {
        citizen = new LinkedHashMap<>();
        country = new ArrayList<>();
    }

    public void info(Scanner scanner) {
        while (true) {
            String letters = "^(?=.*[a-z])(?=.*[A-Z]).+$\n";
            String numbers = ".*\\d+.*";
            System.out.print("Enter your name: ");
            setName(scanner.next());

            if (getName().matches(numbers)) {
                System.out.println("\nYour name cannot contain any numbers...\n");
                continue;
            }

            System.out.print("Enter ID series: ");
            setId(scanner.next());

            if (!getId().matches(letters) && !getId().matches(numbers)) {
                System.out.println("\nIt must contain letters and numbers simultaneously...\n");
                continue;
            }

            if (getId().length() != 7) {
                System.out.println("\nIts length must be 7...\n");
                continue;
            }

            System.out.println("Is '" + getId().toUpperCase() + ". your ID?");
            System.out.print("PLease approve yes or no: ");
            String approving = scanner.next();

            if (approving.equalsIgnoreCase("yes")) {
                System.out.println("Alright, thank you " + getName() + "!");
            } else if (approving.equalsIgnoreCase("no")) {
                System.out.println("Then please try again.\n");
                continue;
            } else {
                System.out.println("You can choose only yes or no...");
                continue;
            }

            citizen.put(getId(), getName());
            setCountry(scanner);

            System.out.println("\n\nDo you want to check your citizenship?");
            System.out.print("PLease approve yes or no: ");
            String checking = scanner.next();

            if (checking.equalsIgnoreCase("yes")) {
                checkIt(scanner);
            } else if (checking.equalsIgnoreCase("no")) {
                System.out.println("Alright " + getName() + "!");
                break;
            }

            System.out.println("Do you want to add another person?");
            System.out.print("PLease approve yes or no: ");
            System.out.println("By the way, if you want to leave, just write 'exit'.");
            String addingCheck = scanner.next();

            if (addingCheck.equalsIgnoreCase("exit")) {
                System.out.println("Alright " + getName() + ", thank you for using our system!");
                break;
            }

            if (addingCheck.equalsIgnoreCase("yes")) {
                System.out.println();
            } else if (addingCheck.equalsIgnoreCase("no")) {
                System.out.println("Thank you " + getName() + "!");
                break;
            } else {
                System.out.println("Please enter only yes or no...");
            }

        }
    }


    public void setCountry(Scanner scanner) {
        while (true) {
            System.out.println("Enter your country...");
            setCitizenship(scanner.next());

            if (getCitizenship().length() != 2) {
                System.out.println("Please enter only short first two letters of your country...");
                continue;
            }

            System.out.println("Alright " + getName() + ", your country set.");
            country.add(getCitizenship());
            break;
        }
    }

    public void checkCountry() {
        if (getCitizenship().equalsIgnoreCase("uk")) {
            System.out.println(getName() + ", your citizenship is United Kingdom");
        } else if (getCitizenship().equalsIgnoreCase("az")) {
            System.out.println(getName() + ", your citizenship is Azerbaijan");
        } else if (getCitizenship().equalsIgnoreCase("ru")) {
            System.out.println(getName() + ", your citizenship is Russia");
        } else if (getCitizenship().equalsIgnoreCase("tr")) {
            System.out.println(getName() + ", your citizenship is Turkiye");
        } else if (getCitizenship().equalsIgnoreCase("es")) {
            System.out.println(getName() + ",your citizenship is Spain");
        } else {
            throw new RuntimeException("Invalid information...");
        }
    }

    public void checkIt(Scanner scanner) {
        while (true) {
            System.out.print("Please enter your ID series: ");
            String idCheck = scanner.next();

            if (idCheck.equals(getId())) {
                System.out.println("\n-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
                checkCountry();
                System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n");
                break;
            } else if (!idCheck.equals(getId())) {
                System.out.println("\nPlease enter the right ID series...\n");
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
