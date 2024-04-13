package Parking;

import java.util.Scanner;

public class ParkCar {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        YourInfo info = new YourInfo();
        info.countryApprove(scanner);
    }
}
