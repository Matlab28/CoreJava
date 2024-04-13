package Health.BMI;

import java.util.Scanner;

public class YourBMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AboutYou aboutYou = new AboutYou();
        aboutYou.yourInfo(scanner);
    }
}
