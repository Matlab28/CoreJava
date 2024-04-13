package BuildingManage;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Building extends Security {
    Map<String, String> gas, light, water, wifi;
    LinkedList<String> parking;
    private String gasCode, lightCode, waterCode, wifiCode;

    public Building() {
        gas = new LinkedHashMap<>();
        light = new LinkedHashMap<>();
        water = new LinkedHashMap<>();
        wifi = new LinkedHashMap<>();
        parking = new LinkedList<>();
    }

    public void manage(Scanner scanner) {
        askPassword(scanner);
        System.out.print("\nEnter the subscriber code for gas: ");
        setGasCode(scanner.next());
        exception();
        gas.put(getGasCode(), getName());

        System.out.print("Enter the subscriber code for water: ");
        setWaterCode(scanner.next());
        exception();
        water.put(getWaterCode(), getName());

        System.out.print("Enter the subscriber code for light: ");
        setLightCode(scanner.next());
        exception();
        light.put(getLightCode(), getName());

        System.out.print("Enter the subscriber code for WIFI: ");
        setWifiCode(scanner.next());
        exception();
        wifi.put(getWifiCode(), getName());

        System.out.println("\n-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n");
        System.out.println("The subscription codes:");
        display();
    }

    public void exception() {
        String letters = "^(?=.*[a-z])(?=.*[A-Z]).+$\n";
        String numbers = ".*\\d+.*";
        if (getGasCode().matches(letters) && getLightCode().matches(letters) &&
                getWaterCode().matches(letters) && getWifiCode().matches(letters)) {
            throw new RuntimeException("It cannot contain any letters...");
        } else if (!getGasCode().matches(numbers) && !getWaterCode().matches(numbers) &&
                !getLightCode().matches(numbers) && !getWifiCode().matches(numbers)) {
            throw new RuntimeException("It must contain only letters...");
        }
    }

    public void display() {
        for (Map.Entry<String, String> gas : gas.entrySet()) {
            System.out.println("Username: " + gas.getValue());
            System.out.println("\nGas subscriber code: " + gas.getKey());
            for (Map.Entry<String, String> water : water.entrySet()) {
                System.out.println("Water subscriber code: " + water.getKey());
                for (Map.Entry<String, String> light : light.entrySet()) {
                    System.out.println("Light subscriber code: " + light.getKey());
                    for (Map.Entry<String, String> wifi : wifi.entrySet()) {
                        System.out.println("Wifi subscriber code: " + wifi.getKey());
                    }
                }
            }
        }
    }

    public void payOrChat(Scanner scanner) {
        Chat chat = new Chat();
        System.out.println("Do you want to pay utilities or chat?");
        System.out.print("Confirm with 'utility' or 'chat': ");
        String uOrc = scanner.next();

        if (uOrc.equalsIgnoreCase("utility")) {
            while (true) {
                System.out.println("Which utility do you want to pay (gas, light, water, or wifi)?");
                String choosing = scanner.next();

                System.out.print("How much do you want to pay? ");
                double paying = 0;
                try {
                    paying = scanner.nextDouble();
                } catch (Exception e) {
                    throw new RuntimeException("Invalid Information...");
                }

                switch (choosing) {
                    case "gas":
                        System.out.println("'" + paying + "' azn has been taken out from your balance for gas");
                        break;
                    case "light":
                        System.out.println("'" + paying + "' azn has been taken out from your balance for light");
                        break;
                    case "water":
                        System.out.println("'" + paying + "' azn has been taken out from your balance for water");
                        break;
                    case "wifi":
                        System.out.println("'" + paying + "' azn has been taken out from your balance for wifi");
                        break;
                    default:
                        System.out.println("Please enter the right utility name...");
                        continue;
                }

                System.out.print("Do you want to pay another one (yes or no)? ");
                String yesNo = scanner.next();

                if (yesNo.equalsIgnoreCase("yes")) {
                    continue;
                } else if (yesNo.equalsIgnoreCase("no")) {
                    break;
                }
            }
        } else if (uOrc.equalsIgnoreCase("chat")) {
            chat.addPhoneNumber(scanner);
            chat.communication(scanner);
        } else {
            System.out.println("Please enter the right name...");
        }
    }

    public void parking() {
        System.out.println("");
    }

    public String getGasCode() {
        return gasCode;
    }

    public void setGasCode(String gasCode) {
        this.gasCode = gasCode;
    }

    public String getLightCode() {
        return lightCode;
    }

    public void setLightCode(String lightCode) {
        this.lightCode = lightCode;
    }

    public String getWaterCode() {
        return waterCode;
    }

    public void setWaterCode(String waterCode) {
        this.waterCode = waterCode;
    }

    public String getWifiCode() {
        return wifiCode;
    }

    public void setWifiCode(String wifiCode) {
        this.wifiCode = wifiCode;
    }
}
