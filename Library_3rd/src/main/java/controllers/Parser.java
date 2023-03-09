package controllers;

import Commands.*;

import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * is used to parse Strings or input from
 * console
 */
public class Parser {
    private static final Scanner input = new Scanner(System.in);

    /**
     * parses String
     * @param inputString
     * @return specific Command class
     * @throws IllegalArgumentException if there is no such command
     */
    public static Command parseCommand() throws IllegalArgumentException {
        var inputString = input.nextLine();
        if (inputString.startsWith("/get")) {
            if (inputString.length() > 5) {
                return new GetBookCommand(inputString.substring(5));
            }
        }
        if (inputString.startsWith("/list")) {
            return new ShowTakenBooksCommand();
        }
        if (inputString.startsWith("/put")) {
            if (inputString.length() > 5) {
                return new PutBookCommand(inputString.substring(5));
            }
        }
        if (inputString.startsWith("/all")) {
            return new ShowAllItemsCommand();
        }
        throw new IllegalArgumentException("no such command!");
    }

    /**
     * reads console input until user enters correct number
     * @param leftBound number should be >= leftBound
     * @param rightBound number should be <= rightBound
     * @return number entered
     */
    public static int intParser(int leftBound, int rightBound) {
        System.out.println("Enter num from " + leftBound +
                " to " + rightBound);
        while (true) {
            int command;
            try {
                command = input.nextInt();
                if (command < leftBound || command > rightBound) {
                    throw new IllegalArgumentException("wrong bounds");
                }
                return command;
            } catch (InputMismatchException ex) {
                input.nextLine();
                System.out.println("Not a number");
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
