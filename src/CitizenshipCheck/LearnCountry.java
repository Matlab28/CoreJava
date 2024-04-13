package CitizenshipCheck;

import java.util.Scanner;

public class LearnCountry {
    public static void main(String[] args) {
        Citizenship citizenship = new Citizenship();
        Scanner scanner = new Scanner(System.in);
        citizenship.info(scanner);
    }
}
