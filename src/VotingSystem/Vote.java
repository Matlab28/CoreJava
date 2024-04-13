package VotingSystem;

import java.util.Scanner;

public class Vote {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        General general = new General();
        general.voting(scanner);
    }
}
