package users;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @see User
 */
public class Sample {
    List<User> users;

    /**
     * empty constructor
     */
    public Sample() {
    }

    /**
     * copy constructor
     */
    public Sample(List<User> users) {
        this.users = users;
    }

    /**
     * is used as a basic example of data
     */
    public void fillBasically() {
        users = Arrays.asList(
                new User(1, "Michael", "Robert", 37, "TR"),
                new User(2, "Mary", "Patricia", 11, "EN"),
                new User(3, "John", "Michael", 7, "FR"),
                new User(4, "Jennifer", "Linda", 77, "TR"),
                new User(5, "William", "Elizabeth", 23, "US"),
                new User(6, "Sue", "Jackson", 11, "IT"),
                new User(7, "Michael", "Tommy", 37, "EN"));
    }

    /**
     * sorts list of users by age
     */
    public void sortByAge() {
        users = users.stream().sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    /**
     * sorts list of users by id
     */
    public void sortById() {
        users = users.stream().sorted(Comparator.comparing(User::getId))
                .collect(Collectors.toList());
    }

    /**
     * counts nationalities, doesn't change the data
     * @return number of unique nationalities
     */
    public long countNationalities() {
        return users.stream()
                .map(User::getNationality)
                .distinct()
                .count();
    }

    /**
     * returns new filtered Sample, doesn't change the data
     * @return new Sample
     */
    public Sample olderThenAndStartsNotWith(int age, char firstLetter) {
        return new Sample(users.stream()
                .filter(p -> (p.getFirstName().charAt(0) != firstLetter))
                .filter(p -> (p.getAge() > age)).toList());
    }

    /**
     * prints users list
     * <p>
     * print users one by one is faster than overriding toString,
     * because toString has too much string concatenation here.
     * But toString is more flexible
     * <p>
     * Note: if we are sure that data will not be changed (but it is not necessary),
     * we can keep the string in the variable
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (var user : users) {
            result.append(user.toString());
            result.append('\n');
        }
        return result.toString();
    }
}
