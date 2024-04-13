package GuestList;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Managing {
    ArrayList<String> guestList;
    Scanner scanner;
    private String name;
    private int a, b = 1;

    public Managing() {
        scanner = new Scanner(System.in);
        guestList = new ArrayList<>();
    }

    public void manageGuests() {
        while (true) {
            String letters = ".*[A-Za-z].*";
            System.out.print("Add " + (a += 1) + ". guest name: ");
            setName(scanner.next());

            if (!getName().matches(letters)) {
                throw new RuntimeException("Invalid input...");
            }

            if (getName().equalsIgnoreCase("done")) {
                System.out.print("Do you want to add or remove any guests? - ");
                String addRemove = scanner.next();

                if (addRemove.equalsIgnoreCase("add")) {
                    continue;
                } else if (addRemove.equalsIgnoreCase("remove")) {
                    removeGuest();
                } else {
                    display();
                    break;
                }
            }

            guestList.add(name);
        }
    }

    public void removeGuest() {
        while (true) {
            System.out.print("Enter the name of guest you want to remove: ");
            String removing = null;
            try {
                removing = scanner.next();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            guestList.remove(removing);

            if (removing.equalsIgnoreCase("done")) {
                break;
            }
        }
    }

    public void display() {
        for (String list : guestList) {
            System.out.println(b++ + ". guest: " + list);
        }
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Managing managing = (Managing) o;
        return a == managing.a && b == managing.b && Objects.equals(guestList, managing.guestList) && Objects.equals(scanner, managing.scanner) && Objects.equals(name, managing.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guestList, scanner, name, a, b);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
