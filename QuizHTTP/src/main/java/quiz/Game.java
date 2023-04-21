package quiz;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Game {
    private Client clientServer;
    private int numOfQuestions = 0;
    private int numOfRightQuestions = 0;

    /**
     * This method starts the quiz game by connecting to the server, getting a random question,
     * asking the user for an answer, and checking if it is correct.
     * It keeps asking questions until the user inputs the "/q" command to quit the game.
     */
    public void start() {
        try {
            clientServer = new Client("jservice.io", 80);
        } catch (IOException e) {
            System.out.println("Error while connecting to server " + e.getMessage());
            return;
        }

        Question question;
        String personAnswer;
        do {
            question = getQuestion();
            printQuestion(question.question);
            personAnswer = getAnswer();
            if (personAnswer.startsWith("/q")) {
                break;
            }
            ++numOfQuestions;
            if (Objects.equals(question.answer, personAnswer)) {
                ++numOfRightQuestions;
            }
            System.out.println("correct answer: " + question.answer);
        } while (true);

        showResult();
    }

    /**
     * This method gets a random question
     * and deserializes the response into a Question object.
     * @return a Question object representing the retrieved question.
     */
    Question getQuestion() {
        String questionString;
        Question question = new Question();
        try {
            questionString = clientServer.getQuestion("/api/random?count=1");
            question = Deserializer.Deserialize(questionString, Question[].class)[0];
        } catch (IOException e) {
            System.out.println("error while getting question: " + e.getMessage());
        }
        return question;
    }

    /**
     * This method asks the user for an answer to the current question and returns it as a String.
     * @return a String representing the user's answer.
     */
    String getAnswer() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }


    /**
     * This method prints the given question to the console.
     * @param question a String representing the question to be printed.
     */
    void printQuestion(String question) {
        System.out.println(question);
    }

    /**
     * This method displays the final result of the game, showing the number
     * of questions answered correctly and the total number of questions answered.
     */
    void showResult() {
        System.out.println("Congrats! Result: " + numOfRightQuestions + "/" + numOfQuestions);
    }
}
