package quiz;

import com.google.gson.annotations.SerializedName;

/**
 * Represents a single trivia question from the jservice.io API.
 */
public class Question {
    @SerializedName("id")
    int id;
    @SerializedName("answer")
    String answer;
    @SerializedName("question")
    String question;
    @SerializedName("value")
    int value;
    @SerializedName("airdate")
    String airdate;
    @SerializedName("created_at")
    String createdAt;
    @SerializedName("updated_at")
    String updatedAt;
    @SerializedName("category_id")
    int categoryId;
    @SerializedName("game_id")
    int gameId;
    @SerializedName("invalid_count")
    int invalidCount;
    @SerializedName("category")
    Category category;

    public Question() {
    }

    class Category {
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
}
