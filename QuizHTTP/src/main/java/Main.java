import quiz.Game;

import java.util.Scanner;

public class Main {
    /**
     * Main method to start the quiz game.
     * Waits for the user to input the "/start" command before starting the game.
     */
    public static void main(String[] args) {
        System.out.println("Type \"/start\" to begin, \"/q\" to quit");
        Scanner input = new Scanner(System.in);
        while (!input.nextLine().startsWith("/start")) {
            System.out.println("wrong command");
        }
        Game game = new Game();
        game.start();
    }
}