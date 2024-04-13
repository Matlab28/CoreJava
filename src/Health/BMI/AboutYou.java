package Health.BMI;

import java.util.Scanner;

public class AboutYou {
    private String height;
    private double weight;

    public void yourInfo(Scanner scanner) {
        System.out.println("The best BMI is between 18.5-24.9.");
        System.out.print("\nEnter your height (with cm): ");
        setHeight(scanner.next());
        System.out.print("Enter your weight (with kq): ");
        setWeight(scanner.nextDouble());

        double bmi = getWeight() / Math.pow(Double.parseDouble(getHeight()), 2);
        System.out.println("\nYour BMI (Body Massive Index) is: " + bmi);
        int updated = (int) bmi;
        System.out.println("It's approximately: " + updated);
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
