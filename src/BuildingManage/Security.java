package BuildingManage;

import java.util.Scanner;

public class Security {
    private String name, password;

    public void askPassword(Scanner scanner) {
        System.out.print("Enter the username: ");
        try {
            setName(scanner.next());
        } catch (Exception e) {
            throw new RuntimeException("Enter the right username...");
        }
        while (true) {
            String uppers = ".*[A-Z].*";
            String lowers = ".*[a-z].*";
            String numbers = ".*\\d+.*";

            System.out.print("Enter the password: ");
            setPassword(scanner.next());

            if (!getPassword().matches(numbers)) {
                System.out.println("*** Password must contain numbers ***");
                continue;
            }

            if (!getPassword().matches(uppers)) {
                System.out.println("*** Password must contain at least an uppercase ***");
                continue;
            }

            if (!getPassword().matches(lowers)) {
                System.out.println("*** Password must contain at least a lowercase ***");
                continue;
            }

            if (getPassword().length() != 8) {
                System.out.println("*** Password length must be 8 characters ***");
                continue;
            }

            confirmation(scanner);
            break;
        }
    }

    public void confirmation(Scanner scanner) {
        while (true) {
            System.out.print("Please confirm the password: ");
            String confirmation = scanner.next();

            if (confirmation.equals(getPassword())) {
                System.out.println("Welcome to the Building System " + getName() + "!");
                break;
            } else {
                System.out.println("Wrong password, please try again...");
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
