package PetAdoption;

import java.util.Scanner;

public class Breeds {
    public String animal;
    public String breed;

    public String choose(Scanner scanner) {
        System.out.print("Which one do you want to adopt? (Cat or dog)?: ");
        animal = scanner.next();

        if (animal.equalsIgnoreCase("cat")) {
            System.out.println("Which breed cat do you want?");
            System.out.println("1. British shorthair, 2. Scottish shorthair, 3. Persian cat, ");
        }
        return animal;
    }
}
