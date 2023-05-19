package game.quiz;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.Getter;

/**
 * Represents a single trivia question from the jservice.io API.
 */
@Data
@Getter
public class Question {
    @SerializedName("id")
    private int id;
    @SerializedName("answer")
    private String answer;
    @SerializedName("question")
    private String question;
}
