import users.Sample;

/**
 * most of the code was successfully taken from
 * <a href="https://habr.com/ru/company/otus/blog/658999/">...</a>
 */
public class Main {
    public static void main(String[] args) {
        Sample users  = new Sample();
        users.fillBasically();

        users.sortByAge();
        System.out.println("sortByAge()\n" + users);

        users.sortById();
        System.out.println("sortById()\n" + users);

        System.out.println("Number of nationalities: "
                + users.countNationalities());

        System.out.println();
        System.out.println("older then 10 and starts not with 'M'\n"
                + users.olderThenAndStartsNotWith(10, 'M'));
    }
}