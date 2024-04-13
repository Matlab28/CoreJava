package BuildingManage;

import java.util.Scanner;

public class Managing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Building building = new Building();
        building.manage(scanner);
        building.payOrChat(scanner);
    }
}
