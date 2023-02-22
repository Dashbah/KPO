public class Singleton {
    private static volatile Singleton instance;
    private int count = 0;

    private Singleton() {
        count++;
    }

    public static Singleton getInstance() {
        var localInstance = instance;
        if (localInstance == null) {
            synchronized (Singleton.class) {
                localInstance = instance;
                if (localInstance != null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public int getCount() {
        return count;
    }
}