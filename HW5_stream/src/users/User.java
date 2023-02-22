package users;

/**
 * better to convert it to record
 */
public class User {
    private final long id;
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String nationality;

    public User(long id, String firstName, String lastName, int age, String nationality) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nationality = nationality;
    }

    public int getAge() {
        return age;
    }

    public long getId() {
        return id;
    }

    public String getNationality() {
        return nationality;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return String.valueOf(this.id) +
                ' ' +
                this.firstName +
                ' ' +
                this.lastName +
                ' ' +
                this.age +
                ' ' +
                this.nationality;
    }

    @Override
    public int hashCode() {
        return (int) id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;

        return id == ((User) o).id;
    }
}
