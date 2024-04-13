package Rock_Sciss_Paper;

import java.util.Scanner;

public class PlayIt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameStructure structure = new GameStructure();
        structure.game(scanner);
    }
}
