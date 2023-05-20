package game.quiz;

import game.user.AppUser;

import java.util.List;

public class UserGameService {

    public void saveResults(String userName, int numOfRightQuestions, int numOfQuestions) {
        // to server
    }

    void register() {
        // to server
    }

    boolean auth() {
        return true;
    }

    public List<AppUser> getAllUsersRequest() {
        return List.of(
                new AppUser("Kate", "1234"),
                new AppUser("Pete", "4321")
        );
    }
}
