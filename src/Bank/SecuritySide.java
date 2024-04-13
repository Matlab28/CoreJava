package Bank;

import BuildingManage.Security;

import java.util.Scanner;

public class SecuritySide {
    private String password;
    private String name;

    public void askPassword(Scanner scanner) {
        while (true) {
            System.out.print("Please, enter the password: ");
            try {
                setPassword(scanner.next());
            } catch (Exception e) {
                throw new RuntimeException("Enter only password...");
            }

            String numbers = ".*\\d+.*";
            String uppers = ".*[A-Z].*";
            String lowers = ".*[a-z].*";

            if (!getPassword().matches(numbers)) {
                System.out.println("*** Password must contain at least one number ***");
                continue;
            }
            if (!getPassword().matches(uppers)) {
                System.out.println("*** Password must contain at least an upper letter ***");
                continue;
            }
            if (!getPassword().matches(lowers)) {
                System.out.println("*** Password must contain at least a lower letter ***");
                continue;
            }
            if (getPassword().length() != 8) {
                System.out.println("*** Password length must be 8 characters ***");
                continue;
            }

            System.out.print("Please confirm the password: ");
            String confirmation = null;
            try {
                confirmation = scanner.next();
            } catch (Exception e) {
                throw new RuntimeException("Confirm only the password...");
            }

            if (confirmation.equals(getPassword())) {
                System.out.println("Welcome to the system " + getName());
                break;
            } else {
                System.out.println("------------------------------------------------------");
                System.out.println("Please try again...");
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
