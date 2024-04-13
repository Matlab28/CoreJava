package Health.IBW;

import java.util.Scanner;

public class YourInfo {
    private String gender;
    private String height;

    public void yourIbw(Scanner scanner) {
        System.out.print("Enter your gender (male or female): ");
        setGender(scanner.next());
        System.out.print("Enter your height (with cm): ");
        setHeight(scanner.next());

        if (getGender().equalsIgnoreCase("male")) {
            double maleIbw = 22 * Math.pow(Double.parseDouble(getHeight()), 2);
            System.out.println("Your IBW (Ideal Body Weight) is: " + maleIbw + " kg.");
            double maleUpdated = (int) maleIbw;
            System.out.println("It's approximately: " + maleUpdated + " kg.");
        } else if (getGender().equalsIgnoreCase("female")) {
            double femaleIbw = 22 * Math.pow((Double.parseDouble(getHeight()) - 0.1), 2);
            System.out.println("Your IBW (Ideal Body Weight) is: " + femaleIbw + " kg.");
            int femaleUpdated = (int) femaleIbw;
            System.out.println("It's approximately: " + femaleUpdated + " kg.");
        } else {
            System.out.println("Please enter only male or female.");
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
