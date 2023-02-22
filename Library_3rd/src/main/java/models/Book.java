package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Book {
    private String caption;
    private List<String> authors;
    private int yearOfPublishing;

    Book() {
    }

    public String getCaption() {
        return caption;
    }

    /**
     * database for creating random books
     */
    private final static String[] captions = {"Kittens", "Spiders", "Dogs", "KPO", "Gorilla",
            "Energy", "Power", "Spicy Freedom"
    };
    private final static String[] names = {"Alex", "Andrew", "Bob", "Bella", "Kit",
            "Boris", "Sugar", "Spicy"};

    private final static String[] surnames = {"Baby", "Jonson", "Monday", "Wednesday",
            "Boy", "Girl", "Star", "Kat"
    };

    /**
     * all items are selected with the help of Random()
     * caption is chosen from String[] captions
     * <p>
     * numOfAuthors - length - [1, 2]
     * they all Strings = name (from String[] names) + " " +
     * surname (from String[] surnames)
     * <p>
     * yearOfPublishing - [1600, 2009]
     */
    public void generateRandomBook() {
        Random rnd = new Random();
        caption = captions[rnd.nextInt(captions.length)];
        int numOfAuthors = rnd.nextInt(2) + 1;
        authors = new ArrayList<>();
        for (int i = 0; i < numOfAuthors; ++i) {
            authors.add(names[rnd.nextInt(names.length)] + " " +
                    surnames[rnd.nextInt(surnames.length)]);
        }
        yearOfPublishing = rnd.nextInt(410) + 1600;
    }

    /**
     * String example: ""Gorilla" of 1649 by: Alex Star, Andrew Boy"
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("");
        result.append("\"").append(caption).append("\" of ").
                append(yearOfPublishing).append(" by: ");

        StringBuilder authorsStringBuilder = new StringBuilder("");

        for (int i = 0; i < authors.size() - 1; ++i) {
            authorsStringBuilder.append(authors.get(i)).append(", ");
        }
        authorsStringBuilder.append(authors.get(authors.size() - 1));

        result.append(authorsStringBuilder);

        return result.toString();
    }
}
