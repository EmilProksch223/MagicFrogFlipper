import components.Flipper;
import components.targets.*;
import visitors.FlipperTargetVisitor;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      

        Flipper flipper = Flipper.getInstance();

        boolean gameLoop = true;

        while(gameLoop) {
            String input = scanner.nextLine().toLowerCase();
            switch(input) {
                case("insert"):
                    flipper.insertCoin();
                    break;
                case("start"):
                    flipper.start();
                    break;
                case("l"):
                    flipper.leftControl();
                    break;
                case("r"):
                    flipper.rightControl();
                    break;
                case("b"):
                    flipper.bothControl();
                    break;
                default: System.out.printf("Keine gültige Eingabe.\n");
            }
        }
    }
}