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
    @SerializedName("value")
    private int value;
    @SerializedName("airdate")
    private String airdate;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("category_id")
    private int categoryId;
    @SerializedName("game_id")
    private int gameId;
    @SerializedName("invalid_count")
    private int invalidCount;
    @SerializedName("category")
    private Category category;

    private class Category {
        @SerializedName("id")
        int id;
        @SerializedName("title")
        String title;
        @SerializedName("created_at")
        String createdAt;
        @SerializedName("updated_at")
        String updatedAt;
        @SerializedName("clues_count")
        int cluesCount;
    }

    String getAnswer() {
        return answer;
    }

    String getQuestion() {
        return question;
    }
}
