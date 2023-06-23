package quiz;

import com.google.gson.annotations.SerializedName;

/**
 * Represents a single trivia question from the jservice.io API.
 */
public class Question {
    @SerializedName("id")
    private int id;
    @SerializedName("answer")
    private String answer;
    @SerializedName("question")
    private String question;

    String getAnswer() {
        return answer;
    }

    String getQuestion() {
        return question;
    }
}
